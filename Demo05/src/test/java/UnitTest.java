import mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Teacher;
import utils.MyBatisUtil;

import java.util.List;

public class UnitTest {

    @Test
    public void getTecherAll() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = teacherMapper.getTeacherAll();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherById() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getTeacherById2() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacherById2(2);
        System.out.println(teacher);
        sqlSession.close();
    }

//    @Test
//    public void getStudentAll(){
//        SqlSession sqlSession=MyBatisUtil.getSession();
//        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList=studentMapper.getStudentAll();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }
//
//    @Test
//    public void getStudentAll2(){
//        SqlSession sqlSession=MyBatisUtil.getSession();
//        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList=studentMapper.getStudentAll2();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
//        sqlSession.close();
//    }

}
