package dao;

import entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
//   int add();
//   //通过Map添加
//   int addMapper(Map<String, Object> map);
//   int update();
//   //通过Map修改
//   int updateMapper(Map<String, Object> map);
//   int delete();
//   Users selectOne();
//   List<Users> selectAll();
//   //分页查询
//   List<Users> selectByLimit(Map<String, Integer> map);
//   List<Users> selectByRowBounds();

    @Insert("insert into users(id,name,password) values(#{id},#{name},#{password})")
    int add(Users users);

    @Update("update users set name=#{name},password=#{password} where id=#{id}")
    int update(Users user);

    @Select("select * from users")
    List<Users> selectAll();

    @Select("select * from users where id=#{id}")
    Users selectOne(@Param("id") int id);

    @Delete(" delete from users where id=#{id}")
    int delete(@Param("id") int id);
}
