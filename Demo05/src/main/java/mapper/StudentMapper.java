package mapper;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生信息，及老师信息 按照查询嵌套处理
    List<Student> getStudentAll();

    //根据结果嵌套处理
    List<Student> getStudentAll2();
}
