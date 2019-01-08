package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IBasketballPlayerDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.BasketballPlayer;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketballPlayerTest {
    private IBasketballPlayerDao basketballPlayerMapper;
    private SqlSession sqlSession;

    public BasketballPlayerTest(){
        super();
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            basketballPlayerMapper = dataConnection.getBasketballPlayerMapper();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestAddBasketballPlayer(){
        System.out.println("插入球员前：");
        TestSelectAllasketballPlayer();
        BasketballPlayer player = new BasketballPlayer("Kawhi Leonard",28,104.3,200,2,"TRO","F");
        basketballPlayerMapper.addBasketballPlayer(player);
        sqlSession.commit();
        System.out.println("插入球员后：");
        TestSelectAllasketballPlayer();
    }

    @Test
    public void TestDeleteBasketballPlayerById(){
        System.out.println("删除球员前：");
        TestSelectAllasketballPlayer();
        basketballPlayerMapper.deleteBasketballPlayerById(5);
        sqlSession.commit();
        System.out.println("删除球员后：");
        TestSelectAllasketballPlayer();
    }

    @Test
    public void TestUpdateBasketballPlayerById(){
        System.out.println("修改球员前：");
        TestSelectAllasketballPlayer();
        BasketballPlayer player = new BasketballPlayer();
        BasketballPlayer basketballPlayer = null;
        player.setId(3);
        player.setHeight(213);
        basketballPlayerMapper.updateBasketballPlayerById(player);
        sqlSession.commit();
        System.out.println("修改球员后：");
        TestSelectAllasketballPlayer();
    }

    @Test
    public void TestSelectBasketballPlayerById(){
        BasketballPlayer player = basketballPlayerMapper.selectBasketballPlayerById(3);
        System.out.println(player);
    }

    @Test
    public void TestSelectAllasketballPlayer(){
        List<BasketballPlayer> players = basketballPlayerMapper.selectAllasketballPlayer();
        for (BasketballPlayer player : players){
            System.out.println(player);
        }
    }

    @Test
    public void TestSelectBasketballPlayerByConditionByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("nameCondition","en");
        map.put("ageCondition",29);
        List<BasketballPlayer> players = basketballPlayerMapper.selectBasketballPlayerByConditionByMap(map);
        for (BasketballPlayer player : players){
            System.out.println(player);
        }
    }

    @Test
    public void TestSelectBasketballPlayerByConditionByIndex(){
        List<BasketballPlayer> players = basketballPlayerMapper.selectBasketballPlayerByConditionByIndex("en",29);
        for (BasketballPlayer player : players){
            System.out.println(player);
        }
    }

    @Test
    public void TestSelectAllBasketballPlayerPageList(){
        List<BasketballPlayer> players = basketballPlayerMapper.selectAllBasketballPlayerPageList(new RowBounds(2,2));
        for (BasketballPlayer player : players){
            System.out.println(player);
        }
    }
}
