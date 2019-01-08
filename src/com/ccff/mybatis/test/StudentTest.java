package com.ccff.mybatis.test;

import com.ccff.mybatis.dao.IStudentDao;
import com.ccff.mybatis.dao.IStudentImpl;
import com.ccff.mybatis.model.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private IStudentDao studentDao;

    public StudentTest(){
        super();
        studentDao = new IStudentImpl();
    }

    @Test
    public void TestSelectStudentsIf(){
        Student student = new Student("李",23,0);
        List<Student> students = studentDao.selectStudentsIf(student);
        System.out.println(students);
    }

    @Test
    public void TestSelectStudentsWhere(){
        Student student = new Student("",23,0);
        List<Student> students = studentDao.selectStudentsWhere(student);
        System.out.println(students);
    }

    @Test
    public void TestSelectStudentsChoose(){
        Student student = new Student("",0,0);
        List<Student> students = studentDao.selectStudentsChoose(student);
        System.out.println(students);
    }

    @Test
    public void TestSelectStudentsForeachArray(){
        Object[] studentIds = new Object[]{1,3};
        List<Student> students = studentDao.selectStudentsForeachArray(studentIds);
        System.out.println(students);
    }

    @Test
    public void TestSelectStudentsForeachList(){
        List<Integer> studentIds = new ArrayList<>();
        studentIds.add(1);
        studentIds.add(3);
        List<Student> students = studentDao.selectStudentsForeachList(studentIds);
        System.out.println(students);
    }

    @Test
    public void TestSelectStudentsForeachList2(){
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        Student student2 = new Student();
        student2.setId(3);
        students.add(student1);
        students.add(student2);
        List<Student> studentRes = studentDao.selectStudentsForeachList2(students);
        System.out.println(studentRes);
    }

    @Test
    public void TestSelectStudentsBySQLFragment(){
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        Student student2 = new Student();
        student2.setId(3);
        students.add(student1);
        students.add(student2);
        List<Student> studentRes = studentDao.selectStudentsBySQLFragment(students);
        System.out.println(studentRes);
    }
}
