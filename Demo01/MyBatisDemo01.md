# MyBatis Demo01
 * Map传参
 
 接口
  ```java
int addMapper(Map<String, Object> map);
```
配置文件UsersMapper.xml
```xml
<insert id="addMapper" parameterType="map">
    insert into users (id,name,password) values (#{userid},#{username},#{pwd})
</insert>
```
UnitTest
```java
@Test
public void addMap(){
    session = MyBatisUtil.getSession();
    UsersMapper usersMapper=session.getMapper(UsersMapper.class);
    Map<String,Object> map=new HashMap<String, Object>();
    map.put("userid",24);
    map.put("username","mapp测试");
    map.put("pwd","mapadd");
    int a=usersMapper.addMapper(map);
    session.commit();	//提交事务
    session.close();	//关闭事务
    if (a > 0) {
        System.out.println("addMap成功");
    }
}
```
 * 日志
 
 STDOUT_LOGGING
 ```xml
<!-- 日志 -->
 <settings>
     <setting name="logImpl" value="STDOUT_LOGGING"/>
 </settings>
 ```