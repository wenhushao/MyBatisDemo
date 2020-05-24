package dao;

import pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询博客 If
    List<Blog> queryBlogByIf(Map map);

    //查询博客 Choose
    List<Blog> queryBlogByChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1 2 3 条博客
    List<Blog> queryBlogByForEeach(Map map);
}
