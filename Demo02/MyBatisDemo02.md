# MyBatis Demo02

* 引入外部配置文件

db.properties
```properties
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=UTF8
username=root
password=201606
```
mybatis-config.xml

```xml
<!-- 引入外部配置 -->
<properties resource="db.properties">
</properties>
```

* 类型别名

```xml
<!-- 类型别名（typeAliases）-->
<typeAliases>
<!--<typeAlias alias="users" type="entity.Users"/>-->
    <package name="entity"/>
</typeAliases>
```
* 分页查询

接口
```java
List<Users> selectByLimit(Map<String, Integer> map);
```
配置文件

```xml
<select id="selectByLimit"  parameterType="map" resultType="users">
    select * from users limit #{startIndex},#{pageSize};
</select>
```

测试
```java
//分页查询
@Test
public void selectByLimit(){
    session= MyBatisUtil.getSession();
    UsersMapper usersMapper= session.getMapper(UsersMapper.class);
    Map<String,Integer> map=new HashMap<String, Integer>();
    map.put("startIndex",0);
    map.put("pageSize",3);
    List<Users> usersList =usersMapper.selectByLimit(map);
    System.out.println("序号\t用户名\t密码");
    for (Users u : usersList) {
        System.out.println(u.getId()+"\t"+u.getName()+"\t"+u.getPassword());
    }
}
```

