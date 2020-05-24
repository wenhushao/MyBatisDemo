package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    public static SqlSession getSession() {
        SqlSession session = null;
        try {
            //读取配置文件
            Reader r = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            SqlSessionFactory sf = sfb.build(r);
            session = sf.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
