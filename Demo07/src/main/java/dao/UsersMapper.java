package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Users;

public interface UsersMapper {
    //根据ID查询用户
    Users queryUsersById(@Param("id") int id);
}
