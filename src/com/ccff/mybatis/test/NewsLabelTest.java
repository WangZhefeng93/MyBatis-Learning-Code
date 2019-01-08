package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.INewsLabelDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.NewsLabel;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class NewsLabelTest {
    private SqlSession sqlSession;
    private INewsLabelDao newsLabelDao;

    @Before
    public void init() {
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            newsLabelDao = sqlSession.getMapper(INewsLabelDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSelectChildrenByParentId(){
        List<NewsLabel> newsLabels = newsLabelDao.selectChildrenByParentId(1);
        for (NewsLabel newsLabel : newsLabels){
            System.out.println(newsLabel);
        }
    }

    @Test
    public void TestSelectNewsLabelById(){
        NewsLabel newsLabel = newsLabelDao.selectNewsLabelById(1);
        System.out.println(newsLabel);
    }

    @Test
    public void TestSelectParentByParentId(){
        NewsLabel newsLabel = newsLabelDao.selectParentByParentId(3);
        System.out.println(newsLabel);
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
