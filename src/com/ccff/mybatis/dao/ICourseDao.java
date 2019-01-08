package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.Course;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface ICourseDao {
    //通过List结果集实现分页
    List<Course> getPageCourseByList();

    //通过SQL参数实现分页
    List<Course> getPageCourseBySQL(Map<String,Object> data);

    //通过RowBounds实现分页
    List<Course> getPageCourseByRowBounds(RowBounds rowBounds);

    //通过分页插件实现分页
    List<Course> getPageCorseByPagePlugin();
}