package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    //插入一个用户
    public void insertUser(User user);
    //插入一个用户，并获取该用户的id
    public void insertUserCatchId(User user);

    //根据id删除某个用户
    public void deleteUserById(int id);

    //修改某个用户
    public void updateUser(User user);


    //查询所有用户，以List形式返回
    public List<User> findAllUserToList();
    //查询所有用户，以Map形式返回
    public Map<String,User> findAllUserToMap();
    //查询所有用户，以分页形式返回
    public List<User> findAllUserToPageList(RowBounds rowBounds);
    //根据id查询某个用户
    public User findUserById(int id);
    //根据username模糊查询某个用户
    public List<User> findUserByName(String username);
}
