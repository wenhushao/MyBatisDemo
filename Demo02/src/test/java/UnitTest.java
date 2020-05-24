import dao.UsersMapper;
import entity.Users;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MyBatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UnitTest {
    SqlSession session = null;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        UnitTest t = new UnitTest();
//        t.add();
//        t.update();
//        t.selectOne();
//        t.delete();
//        t.selectAll();
    }

    @Test
    public void add() {
        session = MyBatisUtil.getSession();
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        Users u = new Users(name, password);
        int a = session.insert("dao.UsersMapper.add", u);
        session.commit();    //提交事务
        session.close();    //关闭事务
        if (a > 0) {
            System.out.println("添加成功！");
            selectAll();
        }
    }

    @Test
    public void addMap() {
        session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 24);
        map.put("username", "mapp测试");
        map.put("pwd", "mapadd");
        int a = usersMapper.addMapper(map);
        session.commit();    //提交事务
        session.close();    //关闭事务
        if (a > 0) {
            System.out.println("addMap成功");
            selectAll();
        }
    }

    @Test
    public void update() {
        session = MyBatisUtil.getSession();
        System.out.println("输入要修改的序号：");
        int id = input.nextInt();
        Users u = (Users) session.selectOne("dao.UsersMapper.selectOne", id);
        System.out.println("修改密码：");
        String password = input.next();
        u.setPassword(password);
        int a = session.update("dao.UsersMapper.update", u);
        session.commit();    //提交事务
        session.close();    //关闭事务
        if (a > 0) {
            System.out.println("修改成功");
            selectAll();
        }
    }

    @Test
    public void updateMap() {
        session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 21);
        map.put("username", "mapp测试02");
        map.put("pwd", "mapupdate");
        int a = usersMapper.updateMapper(map);
        session.commit();    //提交事务
        session.close();    //关闭事务
        if (a > 0) {
            System.out.println("updateMapperMap成功");
            selectAll();
        }
    }

    @Test
    public void delete() {
        session = MyBatisUtil.getSession();
        System.out.println("输入要删除的序号：");
        int id = input.nextInt();
        int a = session.delete("dao.UsersMapper.delete", id);
        session.commit();    //提交事务
        session.close();    //关闭事务
        if (a > 0) {
            System.out.println("删除成功");
            selectAll();
        }
    }

    @Test
    public void selectAll() {
        session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        List<Users> usersList = usersMapper.selectAll();
        System.out.println("序号\t用户名\t密码");
        for (Users u : usersList) {
            System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
        }
    }

    @Test
    public void selectOne() {
        session = MyBatisUtil.getSession();
//        System.out.println("输入要查找的序号：");
//        int id=input.nextInt();
        Users u = session.selectOne("dao.UsersMapper.selectOne", 5);
        System.out.println("序号\t用户名\t密码");
        System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
    }

    //分页查询
    @Test
    public void selectByLimit() {
        session = MyBatisUtil.getSession();
        UsersMapper usersMapper = session.getMapper(UsersMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize", 3);
        List<Users> usersList = usersMapper.selectByLimit(map);
        System.out.println("序号\t用户名\t密码");
        for (Users u : usersList) {
            System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
        }
    }

    @Test
    public void selectByRowBouds() {
        session = MyBatisUtil.getSession();
        RowBounds rowBounds = new RowBounds(0, 2);
        List<Users> usersList = session.selectList("dao.UsersMapper.selectByRowBounds", null, rowBounds);
        System.out.println("序号\t用户名\t密码");
        for (Users u : usersList) {
            System.out.println(u.getId() + "\t" + u.getName() + "\t" + u.getPassword());
        }
    }

}