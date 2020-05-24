package dao;

import entity.Users;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    int add();

    int addMapper(Map<String, Object> map);

    int update();

    int updateMapper(Map<String, Object> map);

    int delete();

    Users selectOne();

    List<Users> selectAll();
}
