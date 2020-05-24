package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;

public interface TeacherMapper {

    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacherById(@Param("tid") int tid);
}
