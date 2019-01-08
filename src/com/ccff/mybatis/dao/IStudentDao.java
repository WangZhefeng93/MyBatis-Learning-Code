package com.ccff.mybatis.dao;

import com.ccff.mybatis.model.Student;

import java.util.List;

public interface IStudentDao {
    //用于测试if标签
    List<Student> selectStudentsIf(Student student);

    //用于测试where标签
    List<Student> selectStudentsWhere(Student student);

    //用于测试choose标签
    List<Student> selectStudentsChoose(Student student);

    //用于测试foreach标签
    List<Student> selectStudentsForeachArray(Object[] studentIds);
    List<Student> selectStudentsForeachList(List<Integer> studentIds);
    List<Student> selectStudentsForeachList2(List<Student> students);

    //用于测试sql标签
    List<Student> selectStudentsBySQLFragment(List<Student> students);
}
