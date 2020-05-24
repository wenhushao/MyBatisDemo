import mapper.StudentMapper;
import mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.MyBatisUtil;

import java.util.List;

public class UnitTest {

    @Test
    public void getTecherById(){
        SqlSession sqlSession= MyBatisUtil.getSession();
        TeacherMapper teacherMapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=teacherMapper.getTeacherById(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void getStudentAll(){
        SqlSession sqlSession=MyBatisUtil.getSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList=studentMapper.getStudentAll();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getStudentAll2(){
        SqlSession sqlSession=MyBatisUtil.getSession();
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList=studentMapper.getStudentAll2();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
