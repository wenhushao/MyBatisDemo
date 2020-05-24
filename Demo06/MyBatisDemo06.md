# MyBatis Demo 06
## 动态SQL Demo

* trim  where set

where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。
如果 where 元素与你期望的不太一样，你也可以通过自定义 trim 元素来定制 where 元素的功能。比如，和 where 元素等价的自定义 trim 元素为：
```xml
<trim prefix="WHERE" prefixOverrides="AND |OR ">
  ...
</trim>
```
set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号（这些逗号是在使用条件语句给列赋值时引入的）。
来看看与 set 元素等价的自定义 trim 元素吧：
```xml
<trim prefix="SET" suffixOverrides=",">
  ...
</trim>
```
* sql片段
```xml
<sql id="if-title-author">
    <if test="title != null">
        and title like #{title}
    </if>
    <if test="author != null">
        and author like #{author}
    </if>
</sql>
```
* 引用sql片段
```xml
<include refid="if-title-author"></include>
```