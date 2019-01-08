package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IGamePlayerDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.GamePlayer;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class GamePlayerTest {
    private SqlSession sqlSession;
    private IGamePlayerDao gamePlayerDao;

    @Before
    public void init() {
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            gamePlayerDao = sqlSession.getMapper(IGamePlayerDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestGamePlayerInfo(){
        GamePlayer wgp = gamePlayerDao.queryWarriorGamePlayer(1);
        System.out.println("玩家ID："+wgp.getId()+"||玩家昵称："+wgp.getUsername()+"||玩家性别："+wgp.getuGender()+"||玩家等级："+wgp.getuLevel());
        System.out.println("玩家职业属性：");
        Map wMap = wgp.getProfessionalAttributes(); //获取职业属性
        System.out.println("剑气值："+wMap.get("swordValue"));
        System.out.println("战斗力："+wMap.get("fightingPower"));

        GamePlayer mgp = gamePlayerDao.queryMagicianGamePlayer(2);
        System.out.println("玩家ID："+mgp.getId()+"||玩家昵称："+mgp.getUsername()+"||玩家性别："+mgp.getuGender()+"||玩家等级："+mgp.getuLevel());
        System.out.println("玩家职业属性：");
        Map mMap = mgp.getProfessionalAttributes(); //获取职业属性
        System.out.println("法术范围："+mMap.get("spellRange"));
        System.out.println("法术强度："+mMap.get("spellPower"));
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
