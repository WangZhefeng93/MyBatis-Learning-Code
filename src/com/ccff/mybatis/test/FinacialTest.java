package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IFinacialDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Batch;
import com.ccff.mybatis.model.Customer;
import com.ccff.mybatis.model.FinacialProduct;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FinacialTest {
    private SqlSession sqlSession;
    private IFinacialDao finacialDao;

    @Before
    public void init() {
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            finacialDao = sqlSession.getMapper(IFinacialDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestSelectCustomerByIdUnion(){
        Customer customer = finacialDao.selectCustomerByIdUnion(1);
        System.out.println(customer);
    }

    @Test
    public void TestSelectCustomerByIdAlone(){
        Customer customer = finacialDao.selectCustomerByIdAlone(3);
        System.out.println(customer);
    }

    @Test
    public void TestSelectAllBatchUnion(){
        List<Batch> batches = finacialDao.selectAllBatchUnion();
        for (Batch batch : batches){
            System.out.println(batch);
        }
    }

    @Test
    public void TestSelectAllBatchAlone(){
        List<Batch> batches = finacialDao.selectAllBatchAlone();
        for (Batch batch : batches){
            System.out.println(batch);
        }
    }

    @Test
    public void TestSelectAllFinacialProduct(){
        List<FinacialProduct> finacialProducts = finacialDao.selectAllFinacialProduct();
        for (FinacialProduct finacialProduct : finacialProducts){
            System.out.println(finacialProduct);
        }
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
