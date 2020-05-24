import dao.UsersMapper;
import entity.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.List;

public class UnitTest {

    @Test
    public void add() {
        SqlSession session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        usersMapper.add(new Users(25, "注解测试", "zhujiecishi"));
    }

    @Test
    public void update() {
        SqlSession session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        usersMapper.update(new Users(25, "注解测试02", "zhujiecishi"));
    }

    @Test
    public void selectAll() {
        SqlSession session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        List<Users> usersList = usersMapper.selectAll();
        System.out.println("序号\t用户名\t密码");
        for (Users u : usersList) {
            System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
        }
    }

    @Test
    public void selectOne() {
        SqlSession session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        Users u = usersMapper.selectOne(25);
        System.out.println("序号\t用户名\t密码");
        System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
    }

    @Test
    public void delete() {
        SqlSession session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        usersMapper.delete(25);
    }
}
