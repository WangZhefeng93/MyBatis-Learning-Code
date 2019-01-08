package com.ccff.mybatis.test;

import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.ShoppingCart;
import com.ccff.mybatis.objectFactory.CartObjectFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartObjectFactoryTest {
    @Test
    public void test() throws IOException {
        DataConnection dataConnection = new DataConnection();
        SqlSession sqlSession = dataConnection.getSqlSession();
        CartObjectFactory cartObjectFactory = new CartObjectFactory();
        //设置参数类型List和参数值List
        List constructorArgTypes= new ArrayList();
        constructorArgTypes.add(int.class);
        constructorArgTypes.add(String.class);
        constructorArgTypes.add(int.class);
        constructorArgTypes.add(double.class);
        constructorArgTypes.add(double.class);
        List constructorArgs = new ArrayList();
        constructorArgs.add(1); //productId
        constructorArgs.add("牙刷");  //productName
        constructorArgs.add(12);    //number
        constructorArgs.add(5.00);  //price
        constructorArgs.add(0.00);  //totalAmount
        ShoppingCart shoppingCart = (ShoppingCart) cartObjectFactory.create(ShoppingCart.class,constructorArgTypes,constructorArgs);
        System.out.println(shoppingCart.getTotalAmount());
        sqlSession.close();
    }
}