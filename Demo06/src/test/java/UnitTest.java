import dao.BlogMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IdUtil;
import utils.MyBatisUtil;

import java.util.*;

public class UnitTest {

    @Test
    public void addInintBlog() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtil.getId());
        blog.setTitle("MyBatis如此简单");
        blog.setAuthor("莫离");
        blog.setCreateTime(new Date());
        blog.setViews(100);

        blogMapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("Java 如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("Spring 如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IdUtil.getId());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);

        sqlSession.close();

    }

    @Test
    public void queryBlogByIf() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<>();
        //map.put("title","Java 如此简单");
        map.put("author", "张伟");
        List<Blog> blogList = blogMapper.queryBlogByIf(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogByChoose() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap<>();
//        map.put("title","Java 如此简单");
//        map.put("author","张伟");
        map.put("views", 100);
        List<Blog> blogList = blogMapper.queryBlogByChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "C 如此简单");
        map.put("author", "张伟");
        map.put("id", "6fce3805492249808819bc266e87c0a5");

        blogMapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogByForEach() {
        SqlSession sqlSession = MyBatisUtil.getSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        List<Blog> blogList = blogMapper.queryBlogByForEeach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
