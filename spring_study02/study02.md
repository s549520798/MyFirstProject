# study02

------
### BeanFactory
> BeanFactory 是一个类工厂,但是它和普通的工厂类有很大区别,传统的工厂类仅仅
 负责创造一个或者几个类的实例,但spring的BeanFactory不仅创建,并且来管理这些
 类的对象.
 
> spring中的Bean要比JavaBean更宽泛一些,所有可以被spring容器创建的java类都
 可以被称为Bean.
 -----
 ### ApplicationContext 简介
        ApplicationContext 是由BeanFactory派生而来的,它提供了更多面向实际的功能.在BeanFactory中很多功能是通过编程来实现的,
    但是在ApplicatinContext中更多的是通过xml配置文件来是现实的.
 
 #### ApplicationContext的体系结构
 实现类
 - ClassPathXmlApplicationContext (默认从类路径加载配置文件)
 - FileSystemXmlApplicationContext (默认从文件系统加载配置文件)
 
 -------
 ### ApplicationContext 和 BeanFactory
 #### 区别
 在BeanFactory初始化容器的时候,并不会去实例化Bean,而是在第一次调用的时候对Bean进行实例化.
 而ApplicationContext再初始化容器的时候会将 配置文件中的单实例Bean都实例化,所以启动时间会比BeanFactory时间要长
 #### 联系
 ApplicationContext 是由 BeanFactory发展而来,前者继承了后者,并且实现了去多其他功能的接口,
 ----
 
 
 