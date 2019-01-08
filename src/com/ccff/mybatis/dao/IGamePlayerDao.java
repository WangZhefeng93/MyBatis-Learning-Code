package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.GamePlayer;

public interface IGamePlayerDao {
    GamePlayer queryWarriorGamePlayer(int id);
    GamePlayer queryMagicianGamePlayer(int id);
}
