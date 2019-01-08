package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.ILazyLoadingDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LazyLoadingTest {
    private SqlSession sqlSession;
    private ILazyLoadingDao lazyLoadingDao;

    @Before
    public void init() {
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            lazyLoadingDao = sqlSession.getMapper(ILazyLoadingDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSelectCountryById(){
        System.out.println("语句1执行...");
        Country country = lazyLoadingDao.selectCountryById(1);  //语句1
        System.out.println("语句2执行...");
        System.out.println(country.getCname());     //语句2：
        System.out.println("语句3执行...");
        System.out.println(country.getMinisters().size());  //语句3：
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
