package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.ICourseDao;
import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Course;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseTest {
    private SqlSession sqlSession;
    private ICourseDao courseDao;

    @Before
    public void init() {
        DataConnection dataConnection = new DataConnection();
        try {
            sqlSession = dataConnection.getSqlSession();
            courseDao = sqlSession.getMapper(ICourseDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param currPage：当前页号
     * @param pageSize：当前页总共的记录数
     * @return 该页的记录的List集合
     */
    private List<Course> pageByList(int currPage, int pageSize){
        //查询全部数据
        List<Course> courses = courseDao.getPageCourseByList();
        //从第几条数据开始
        int firstIndex = (currPage-1)*pageSize;
        //到第几条结束
        int lastIndex = currPage*pageSize;
        //直接在List中截取
        return courses.subList(firstIndex,lastIndex);
    }

    @Test
    public void TestGetPageCourseByList(){
        //总记录共10条。假设总共分为4页，每页最多3条记录
        System.out.println("===========================第二页记录为：=====================");
        List<Course> secondPage = pageByList(2,3);
        for (Course course : secondPage){
            System.out.println(course);
        }
        System.out.println("===========================第四页记录为：=====================");
        List<Course> lastPage = pageByList(4,1);
        for (Course course : lastPage){
            System.out.println(course);
        }
    }

    @Test
    public void TestGetPageCourseBySQL(){
        Map<String,Object> data = new HashMap<>();
        data.put("currIndex",3);
        data.put("pageSize",3);
        List<Course> thirdPage = courseDao.getPageCourseBySQL(data);
        System.out.println("===========================第三页记录为：=====================");
        for (Course course : thirdPage){
            System.out.println(course);
        }
    }

    @Test
    public void TestGetPageCourseByRowBounds(){
        RowBounds rowBounds = new RowBounds(0,3);
        List<Course> firstPage = courseDao.getPageCourseByRowBounds(rowBounds);
        System.out.println("===========================第一页记录为：=====================");
        for (Course course : firstPage){
            System.out.println(course);
        }
    }

    @Test
    public void TestGetPageCorseByPagePlugin(){
        PageHelper.startPage(4,3);
        List<Course> ForthPage = courseDao.getPageCorseByPagePlugin();
        System.out.println("===========================第四页记录为：=====================");
        for (Course course : ForthPage){
            System.out.println(course);
        }
    }

    @After
    public void tearDown(){
        if (sqlSession != null)
            sqlSession.close();
    }
}
