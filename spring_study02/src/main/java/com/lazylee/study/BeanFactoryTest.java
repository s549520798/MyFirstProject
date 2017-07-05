package com.lazylee.study;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by lazylee on 2017/7/5.
 */
public class BeanFactoryTest {

    /**
     * 通过DefaultListableBeanFactory 和 XmlBeanDefinitionReader 获取Bean的实例对象
     *
     * 首先,XmlBeanDefinitionReader 通过Resource装载 ioc容器的配置文件
     * 然后,通过DefaultListableBeanFactory的getBean方法获取Bean的对象.
     * @throws IOException
     */
    @Test
    public void getBeans() throws IOException {
        // Resource 加载 beans.xml配置文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("beans.xml");
        System.out.println(resource.getURL());
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        /*
        * XmlBeanDefinitionReader 通过Resource装载 ioc容器的配置文件
        * 此时并不会初始化配置文件中的Bean
        * 初始化工作发生在第一次调用时.即 Car car = factory.getBean("car",Car.class) 时进行初始化
        * */
        reader.loadBeanDefinitions(resource);
        /*初始化配置文件中配置bean
        * 当在singleton模式下,bean只会初始化一次,之后再进行调用时,会在spring ioc容器的缓冲池中进行调用同一个bean对象
        * 缓存机制由DefaultSingletonBeanRegistry 提供,该类通过HashMap来实现缓存器,将 Bean 的beanName为key值保存在
        *   hashMap中.
        * */

        Car car = factory.getBean("car",Car.class);
        car.instroduce();

    }
}
