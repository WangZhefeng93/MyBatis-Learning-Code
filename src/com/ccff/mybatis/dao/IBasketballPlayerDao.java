package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.BasketballPlayer;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface IBasketballPlayerDao {

    //添加球员
    void addBasketballPlayer(BasketballPlayer player);

    //根据id删除球员
    void deleteBasketballPlayerById(int id);

    //根据id修改球员
    void updateBasketballPlayerById(BasketballPlayer player);

    //根据id查询球员
    BasketballPlayer selectBasketballPlayerById(int id);

    //查询所有球员
    List<BasketballPlayer> selectAllasketballPlayer();

    //查询所有球员并分页显示
    List<BasketballPlayer> selectAllBasketballPlayerPageList(RowBounds rowBounds);

    //根据指定条件查询球员（演示多查询条件接收问题）
    List<BasketballPlayer> selectBasketballPlayerByConditionByMap(Map<String,Object> map);
    List<BasketballPlayer> selectBasketballPlayerByConditionByIndex(String name,int age);

}
