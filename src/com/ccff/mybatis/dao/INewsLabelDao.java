package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.NewsLabel;

import java.util.List;

public interface INewsLabelDao {
    //以一对多方式处理：查询指定栏目的所有子孙栏目
    List<NewsLabel> selectChildrenByParentId(int pid);

    //以一对多方式处理：查询指定栏目及其所有子孙栏目
    NewsLabel selectNewsLabelById(int id);

    //以多对一方式处理：根据pid查询某一父栏目的全部信息
    NewsLabel selectParentByParentId(int pid);
}
