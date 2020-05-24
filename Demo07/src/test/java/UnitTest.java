import dao.UsersMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Users;
import utils.MyBatisUtil;

public class UnitTest {
    @Test
    public void queryUsersById() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.queryUsersById(1);
        System.out.println(users);
        System.out.println("==============");
        Users users2 = usersMapper.queryUsersById(1);
        System.out.println(users2);
        System.out.println(users == users2);
        sqlSession.close();
    }

    @Test
    public void queryUsersById2() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        SqlSession sqlSession2 = MyBatisUtil.getSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.queryUsersById(2);
        System.out.println(users);
        sqlSession.close();

        UsersMapper usersMapper2 = sqlSession2.getMapper(UsersMapper.class);
        Users users2 = usersMapper2.queryUsersById(2);
        System.out.println(users2);
        sqlSession2.close();

        System.out.println(users == users2);
    }
}
