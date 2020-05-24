package dao;

import entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int add();

    //通过Map添加
    int addMapper(Map<String, Object> map);

    int update();

    //通过Map修改
    int updateMapper(Map<String, Object> map);

    int delete();

    Users selectOne();

    List<Users> selectAll();

    //分页查询
    List<Users> selectByLimit(Map<String, Integer> map);

    List<Users> selectByRowBounds();
}
