# MyBatis Demo 07
## 缓存

cacheEnabled

全局性地开启或关闭所有映射器配置文件中已配置的任何缓存。默认值true
```xml
<!-- 显示默认开启的缓存 -->
<setting name="cacheEnabled" value="true"/>
```
* 一级缓存也叫本地缓存

一级缓存 Mybatis的一级缓存是指SQLSession，一级缓存的作用域是SQlSession, Mabits默认开启一级缓存。

在同一个SqlSession中，执行相同的SQL查询时；第一次会去查询数据库，并写在缓存中，第二次会直接从缓存中取。

当执行SQL时候两次查询中间发生了增删改的操作，则SQLSession的缓存会被清空。 

每次查询会先去缓存中找，如果找不到，再去数据库查询，然后把结果写到缓存中。 

Mybatis的内部缓存使用一个HashMap，key为hashcode+statementId+sql语句。Value为查询出来的结果集映射成的java对象。 

SqlSession执行insert、update、delete等操作commit后会清空该SQLSession缓存。



* 二级缓存也叫全局缓存

二级缓存是mapper级别的，Mybatis默认是没有开启二级缓存的。 

第一次调用mapper下的SQL去查询用户的信息，查询到的信息会存放代该mapper对应的二级缓存区域。 

第二次调用namespace下的mapper映射文件中，相同的sql去查询用户信息，会去对应的二级缓存内取结果。 

```xml
<cache/>
```