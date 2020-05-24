package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    //查询老师
    List<Teacher> getTeacherAll();

    //查询指定老师下的学生
    Teacher getTeacherById(@Param("tid") int id);

    Teacher getTeacherById2(@Param("tid") int id);
}
