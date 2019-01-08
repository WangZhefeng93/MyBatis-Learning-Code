package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IUserDao;
import com.ccff.mybatis.dao.IUserDaoImpl;
import com.ccff.mybatis.model.User;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    private IUserDao userDao;

    public MyBatisTest(){
        super();
        userDao = new IUserDaoImpl();
    }


    public void TestSelect() {
        User user = userDao.findUserById(1);
        System.out.println("姓名："+user.getUsername());
        System.out.println("性别："+user.getGender());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        System.out.println("生日："+simpleDateFormat.format(user.getBirthday()));
        System.out.println("所在地："+user.getProvince());
    }


    public void TestInsertUser(){
        Date day = new Date();
        User user = new User("王五","123456","男","123@qq.com","辽宁省","沈阳市",day);
        userDao.insertUser(user);
    }


    public void TestInsertUserCatchId(){
        Date day = new Date();
        User user = new User("王五","123456","男","123@qq.com","辽宁省","沈阳市",day);
        System.out.println("插入前User = "+user);
        userDao.insertUserCatchId(user);
        System.out.println("插入后User = "+user);
    }

    public void TestDeleteUserById(){
        userDao.deleteUserById(10);
    }

    public void TestUpdateUser(){
        User user = new User();
        user.setId(4);
        user.setUsername("王丽");
        userDao.updateUser(user);
    }

    @Test
    public void TestFindAllUserToList(){
        List<User> users = userDao.findAllUserToList();
        for (User user : users){
            System.out.println(user);
        }
    }

    public void TestFindAllUserToMap(){
        Map<String,User> userMap = userDao.findAllUserToMap();
        User user = userMap.get("张三");
        System.out.println(user);
    }

    public void TestFindUserByName(){
        List<User> users = userDao.findUserByName("丽");
        for (User user : users){
            System.out.println(user);
        }
    }


    public void TestSelectByIdAlias() {
        User user = userDao.findUserById(3);
        System.out.println(user);
    }

    @Test
    public void TestFindAllUserToPageList(){
        RowBounds rowBounds = new RowBounds(0,2);
        List<User> users = userDao.findAllUserToPageList(rowBounds);
        for (User user : users){
            System.out.println(user);
        }
    }

}
