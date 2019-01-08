package com.ccff.mybatis.dao;

import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IUserDaoImpl implements IUserDao {
    private SqlSession sqlSession;
    private DataConnection dataConnection;

    public IUserDaoImpl(){
        super();
        try {
            DataConnection dataConnection = new DataConnection();
            sqlSession = dataConnection.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public DataConnection getDataConnection() {
        return dataConnection;
    }

    public void setDataConnection(DataConnection dataConnection) {
        this.dataConnection = dataConnection;
    }

    @Override
    public void insertUser(User user) {
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        this.close();
    }

    @Override
    public void insertUserCatchId(User user) {
        sqlSession.insert("test.insertUserCatchId",user);
        sqlSession.commit();
        this.close();
    }

    @Override
    public void deleteUserById(int id) {
        sqlSession.delete("test.deleteUserById",id);
        sqlSession.commit();
        this.close();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        this.close();
    }

    @Override
    public List<User> findAllUserToList() {
        List<User> users = null;
        users = sqlSession.selectList("test.findAllUserToList");
        this.close();
        return users;
    }

    @Override
    public Map<String, User> findAllUserToMap() {
        Map<String,User> userMap = null;
        userMap = sqlSession.selectMap("test.findAllUserToMap","username");
        this.close();
        return userMap;
    }

    @Override
    public List<User> findAllUserToPageList(RowBounds rowBounds) {
        List<User> users = null;
        users = sqlSession.selectList("test.findAllUserToPageList",new Object(),rowBounds);
        this.close();
        return users;
    }

    @Override
    public User findUserById(int id) {
        User user = sqlSession.selectOne("test.findUserById",id);
        this.close();
        return  user;
    }

    @Override
    public List<User> findUserByName(String username) {
        List<User> users = null;
        users = sqlSession.selectList("test.findUserByName",username);
        this.close();
        return users;
    }

    private void close(){
        sqlSession.close();
    }
}
