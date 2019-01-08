package com.ccff.mybatis.dao;

import com.ccff.mybatis.datasource.DataConnection;
import com.ccff.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class IStudentImpl implements IStudentDao {
    private SqlSession sqlSession;
    private DataConnection dataConnection;

    public IStudentImpl(){
        super();
        try {
            DataConnection dataConnection = new DataConnection();
            sqlSession = dataConnection.getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> selectStudentsIf(Student student) {
        List<Student> students = null;
        students = sqlSession.selectList("StudentTest.selectStudentsIf",student);
        this.close();
        return students;
    }

    @Override
    public List<Student> selectStudentsWhere(Student student) {
        List<Student> students = null;
        students = sqlSession.selectList("StudentTest.selectStudentsWhere",student);
        this.close();
        return students;
    }

    @Override
    public List<Student> selectStudentsChoose(Student student) {
        List<Student> students = null;
        students = sqlSession.selectList("StudentTest.selectStudentsChoose",student);
        this.close();
        return students;
    }

    @Override
    public List<Student> selectStudentsForeachArray(Object[] studentIds) {
        List<Student> students = null;
        students = sqlSession.selectList("StudentTest.selectStudentsForeachArray",studentIds);
        this.close();
        return students;
    }

    @Override
    public List<Student> selectStudentsForeachList(List<Integer> studentIds) {
        List<Student> students = null;
        students = sqlSession.selectList("StudentTest.selectStudentsForeachList",studentIds);
        this.close();
        return students;
    }

    @Override
    public List<Student> selectStudentsForeachList2(List<Student> students) {
        List<Student> studentRes = null;
        studentRes = sqlSession.selectList("StudentTest.selectStudentsForeachList2",students);
        this.close();
        return studentRes;
    }

    @Override
    public List<Student> selectStudentsBySQLFragment(List<Student> students) {
        List<Student> studentRes = null;
        studentRes = sqlSession.selectList("StudentTest.selectStudentsBySQLFragment",students);
        this.close();
        return studentRes;
    }

    private void close(){
        sqlSession.close();
    }
}
