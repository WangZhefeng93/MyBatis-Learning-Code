package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IBookDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BookTest {
    private SqlSession sqlSession;
    private IBookDao bookDao;
    private DataConnection dataConnection = new DataConnection();

    @Before
    public void init() {
        try {
            sqlSession = dataConnection.getSqlSession();
            bookDao = sqlSession.getMapper(IBookDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindBookById(){
        Book book = null;
        //第一次查询
        book = bookDao.findBookById(1);
        System.out.println("第一次查询："+book);
        //第二次查询
        book = bookDao.findBookById(1);
        System.out.println("第二次查询："+book);
    }

    @Test
    public void TestFindBookById2(){
        Book book = null;
        //第一次查询
        book = bookDao.findBookById(1);
        System.out.println("第一次查询："+book);
        //第二次查询
        book = bookDao.findBookById2(1);
        System.out.println("第二次查询："+book);
    }

    @Test
    public void TestUpdateBookById(){
        Book book = null;
        //第一次查询
        book = bookDao.findBookById(1);
        System.out.println("第一次查询："+book);
        //执行增删改操作
        Book updateBook = new Book();
        updateBook.setId(3);
        updateBook.setNumber(5);
        bookDao.updateBookById(updateBook);
        sqlSession.commit();
        //第二次查询
        book = bookDao.findBookById2(1);
        System.out.println("第二次查询："+book);
    }

    @Test
    public void TestProofSecondLevelCache(){
        //第一次查询
        bookDao = sqlSession.getMapper(IBookDao.class);
        Book book1 = bookDao.findBookById(1);
        System.out.println("第一次查询："+book1);
        sqlSession.close();
        try {
            sqlSession = dataConnection.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //第二次查询
        bookDao = sqlSession.getMapper(IBookDao.class);
        Book book2 = bookDao.findBookById(1);
        System.out.println("第二次查询："+book2);
    }

    @Test
    public void TestCUDAffectSecondLevelCache(){
        //第一次查询
        bookDao = sqlSession.getMapper(IBookDao.class);
        Book book1 = bookDao.findBookById(1);
        System.out.println("第一次查询："+book1);
        sqlSession.close();
        try {
            sqlSession = dataConnection.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookDao = sqlSession.getMapper(IBookDao.class);
        //执行增删改操作
        Book updateBook = new Book();
        updateBook.setId(2);
        updateBook.setNumber(10);
        bookDao.updateBookById(updateBook);
        sqlSession.commit();
        //第二次查询
        Book book2 = bookDao.findBookById(1);
        System.out.println("第二次查询："+book2);
    }

    @Test
    public void TestUsingEhcache(){
        //第一次查询
        bookDao = sqlSession.getMapper(IBookDao.class);
        Book book1 = bookDao.findBookById(1);
        System.out.println("第一次查询："+book1);
        sqlSession.close();
        try {
            sqlSession = dataConnection.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //第二次查询
        bookDao = sqlSession.getMapper(IBookDao.class);
        Book book2 = bookDao.findBookById(1);
        System.out.println("第二次查询："+book2);
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
