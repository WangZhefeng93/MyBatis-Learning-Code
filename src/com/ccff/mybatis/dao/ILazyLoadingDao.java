package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.Country;

public interface ILazyLoadingDao {
    //测试延迟加载方法：一对多查询：根据cid查询国家信息
    Country selectCountryById(int cid);
}
