# spring study 01

---------------------------

[TOC]

## **1.配置元数据**
> 为了实例化bean,并指定如何对这些bean进行装配,需要向IoC容器提供信息,
所提供的信息被称为**配置元数据**(_configuration metadata_).

配置元数据有三种形式:
- 传统的xml配置形式
- 注解配置(spring 2.5引入)
- 基于java文件的配置形式(spring 3.0引入)

在同一个项目中,可以根据项目需要,或者个人习惯,使用其中的一种或同时使用
多中配置元数据的方式.

#### **基于xml配置方式**
XML配置文件头的声明如下：

      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns:context="http://www.springframework.org/schema/context"
             xsi:schemaLocation="http://www.springframework.org/schema/beans"
             "http://www.springframework.org/schema/beans/spring-beans.xsd"
             "http://www.springframework.org/schema/context"
             "http://www.springframework.org/schema/beans/spring-context.xsd">
             
其中 _xmlns="http://www.springframework.org/schema/beans"_ 为默认命名空间；
_xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"_ 是 xsi标准命名空间，用于指定自定义命名空间的Schema文件；
_xmlns:context="http://www.springframework.org/schema/context"_ 自定义命名空间，context为命名空间的别称，
"http://www.springframework.org/schema/context" 是命名空间的全称，必须在xsi为其指定相应的Schema文件，如果命名的别名为空，
则表示该命名空间为文档默认命名空间，如第一条所示；
_xsi:schemaLocation="http://www.springframework.org/schema/beans"  
"http://www.springframework.org/schema/beans/spring-beans.xsd"_ 是为每个自定义命名空间指定了具体的Schema文件；
根据自己的需求添加相应的命名文件。

##### 1.在xml文件中声明Bean
    
    <bean id="accountService" class="com.lazylee.study.xmlconfig.AccountServiceImpl">
            <property name="accountDao" ref="accountDao"/>
    </bean>
    
  使用<bean/>为spring的ioc容器配置Bean.  
  1.其中 id 为这个Bean的名称，容器通过getBean("accountService")就可以得到对应Bean,也可以通过name属性指定
    这个bean的名称,class 属性指定Bean对应的实现类;  
  2.id在容器中必须是唯一的,还需满足XML对id的命名规范:  
      必须以字母开头,后面可以是字母、数字、连字符、下划线、句号和冒号等完整结束符号，逗号和空格等非结束
      符号是非法的。  
  3.当用户想使用违反规定的方式对Bean进行命名时，可以使用name属性对Bean进行命名，name属性没有命名时字符的限制。
  4.id和name都可以指定多个名字，名字之间使用逗号，分号或者空格进行分阁，例如：  
    
    <bean name="car,bus,&sdf" class="......"/>  
  5.spring容器中不允许出现相同id的bean,但name属相却可以重复,但是在使用getBean(beanName)得到Bean时,会返回
    后声明的bean;  
  6.如果id和name属相都未指定,那么可以使用全限定名得到相应的Bean,例如:  
    
    <bean class="com.lazylee.Car">  
      
   可以使用getBean("com.lazylee.Car")得到该Bean.  
    如果存在多个实现类相同的匿名bean,如  
    
    <bean class="com.lazylee.Car">  
    <bean class="com.lazylee.Car">  
    <bean class="com.lazylee.Car">  
  使用getBean("com.lazylee.Car")得到第一个Bean,使用getBean("com.lazylee.Car#1")得到第二个Bean,  
  使用getBean("com.lazylee.Car#2")得到第三个Bean.  
##### 2.使用< property/>为Bean进行属性注入,使用< constructor-arg/> 进行构造函数注入
查看[依赖注入](##2.依赖注入)
##### 3.工厂方法注入
1.非静态工厂方法注入  
如有工厂方法：
    
    public class CarFactory{
    
         public Car createCar(){
             Car car = new Car();
             return car;
         }
    }
则在xml文件中配置Car类的Bean时，可以使用
    
    <!--非静态工厂类Bean -->
    <bean id="carFactory" class="com.example.CarFactory"/> 
    <!-- Car  bean-->
    <bean id="car" factory-bean="carFactory"
                   factory-method="createCar"/>
2.静态工厂类方法注入
静态工厂方法：
    
    public class CarFactory{
        public static Car createCar(){
            Car car = new Car();
            return car;
        }
    }
在xml文件中配置Bean时，则不需要配置工厂类的Bean，只需配置
    
    <bean id="car" class="com.example.CarFactory" 
                   factory-method="createCar"/>
#### 基于注解的配置方式
注解<code>@Servide</code>和<code>@Repository</code>都定义了spring管理的
Beans. 这两个注解都扩展自 org.springframework.stereotype.Component.
- @Service 注解除了将一个类定义为bean外,没有其他含义.
- @Repository 能够启用与Spring数据访问相关的其他功能.
- @Autowired 自动装配 
 

#### 基于java的配置方式
java配置来源于spring的一个子项目 javaConfig ,该项目允许以java类作为spring的配置文件,现在已经加spring核心组件之中
使用 @Configuration 注解的java文件可以被看做java类配置文件
java配置相对于xml配置来说,可以是编程人员更容易控制Bean的初始化过程,配置方式也更加灵活.
提供了专门ApplicationContext的实现类AnnotationConfigurationApplicationContext

#### 基于Groovy的配置方式
spring 允许使用 groovy DSL 来实现配置,可以实现复杂灵活的Bean配置
提供了专门ApplicationContext的实现类GenericGroovyApplicationContext
## 2.依赖注入

--------------------------
#### setter注入(属性注入)
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
 **注意:** spring容器在进行setter注入的时候只会检查是否具有setter方法,而不会去检查set的变量是否存在,但是我们在
 编程时,最好声声明变量的存在
#### 构造函数注入
构造函数注入是在组件创建期间被执行,保证了bean在实例化时属性就被注入.

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

#### 接口注入
通过新建一个接口(interface),声明注入方法,再由需导入依赖的类实现接口.
这样做会增加工作量,且本质上和属性注入无区别,并不推荐使用.

 