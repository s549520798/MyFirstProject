# spring study 01

---------------------------
## **1.配置元数据**
> 为了实例化bean,并指定如何对这些bean进行装配,需要向IoC容器提供信息,
所提供的信息被称为**配置元数据**(_configuration metadata_).

配置元数据有三种形式:
- 传统的xml配置形式
- 注解配置(spring 2.5引入)
- 基于java文件的配置形式(spring 3.0引入)

在同一个项目中,可以根据项目需要,或者个人习惯,使用其中的一种或同时使用
多中配置元数据的方式.

#### 基于xml配置方式



#### 基于注解的配置方式
注解<code>@Servide</code>和<code>@Repository</code>都定义了spring管理的
Beans. 这两个注解都扩展自 org.springframework.stereotype.Component.
- @Service 注解除了将一个类定义为bean外,没有其他含义.
- @Repository 能够启用与Spring数据访问相关的其他功能.


- @Autowired 自动装配 
 

#### 基于java的配置方式

## 2. 依赖注入

--------------------------
#### setter注入
1. property 用来进行依赖注入 ref 指向名称是accountDao的 bean.倘若没有配置accountBean的Bean实例 则会编译出错
        
       < property name="accountDao" ref="accountDao"/>
        
2. 除了注入bean之外,还可以使用<property>的 value 属性来注入
        int、String、boolean、Enum 等属性。
        e.g. :
        
        < property name="id" value="1"/>
        < property name="ownerName" value="John"/>
        < property name="balance" value="10.0"/>
        < property name="locked" value="false"/>

3. spring还允许注入Collection 或 Map 值
        
        <bean id="accountDao"
                class="com.lazylee.study.xmlconfig.AccountDaoInMemoryImpl"> 
                < property name="accountMap">
                < map>
                    < entry key="1" value-ref="account1"/>
                    < entry key="2" value-ref="account2"/>
                < /map>
            < /property>
        < /bean>
#### 构造函数注入
构造函数注入是在组件创建期间被执行.

1. 在xml配置文件中配置< bean>属性
      
      
      <bean ...>
        <!-- 构造器注入 -->
        < constructor-arg ref="accountDao"/>
      </bean>

2. 和setter注入一样,构造函数注入也可以注入 int,String,boolean,Enum,Map等值.通过 constructor-arg 的 value属性
来填入相关的值,必要的类型转换由spring容器处理.

3. 当包含多个人构造器使spring容器无法自己完成实例化工作时,需要人工对spring提供一些帮助,以便其完成bean的初始化工作
在constructor-arg 中添加 _index_ 属性.

      
      <bean ...>
        <!-- 构造器注入 -->
        < constructor-arg ref="bra" index="0"/>
        < constructor-arg ref="brz" index="1"/>
      </bean>
**注:可以将setter注入和构造器注入同时使用.**

**注:对于循环依赖的情况,例如A的构造依赖与B,B的构造依赖于A,则spring构造注入不能实例化这两个Bean,但是setter注入
可以实现这两个Bean的实例化**

 