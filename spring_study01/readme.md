## spring study 01
### 配置元数据
> 为了实例化bean,并指定如何对这些bean进行装配,需要向IoC容器提供信息,
所提供的信息被称为**配置元数据**(_configuration metadata_).

配置元数据有三种形式:
- 传统的xml配置形式
- 注解配置(spring 2.5引入)
- 基于java文件的配置形式(spring 3.0引入)

在同一个项目中,可以根据项目需要,或者个人习惯,使用其中的一种或同时使用
多中配置元数据的方式.

### 基于xml配置方式



### 基于注解的配置方式
注解<code>@Servide</code>和<code>@Repository</code>都定义了spring管理的
Beans. 这两个注解都扩展自 org.springframework.stereotype.Component.
- @Service 注解除了将一个类定义为bean外,没有其他含义.
- @Repository 能够启用与Spring数据访问相关的其他功能.


- @Autowired 自动装配 
 

### java配置方式