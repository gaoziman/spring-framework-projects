package org.javatop.orginal.factory;

import org.javatop.orginal.dao.DemoDao;
import org.javatop.orginal.dao.DemoDaoImpl;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-06-17 21:38
 * @description :
 */
public class BeanFactory {

    private static Properties properties;

    // public static DemoDao getDemoDao() {
    //     // return new DemoDaoImpl();
    //     return new DemoDaoImpl();
    // }

    // 继续改造BeanFactory类，使用反射的方式创建DemoDao对象
   /* public static DemoDao getDemoDao() {
        try {
            return (DemoDao) Class.forName("org.javatop.orginal.dao.DemoDaoImpl").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DemoDao instantiation error, cause: " + e.getMessage());
        }
    }*/

    // 使用静态代码块初始化properties，加载factory.properties文件
    static {
        properties = new Properties();
        try {
            // 必须使用类加载器读取resource文件夹下的配置文件
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            // BeanFactory类的静态初始化都失败了，那后续也没有必要继续执行了
            throw new ExceptionInInitializerError("BeanFactory initialize error, cause: " + e.getMessage());
        }
    }


    public static Object getBean(String beanName) {
        try {
            // 从properties文件中读取指定name对应类的全限定名，并反射实例化
            Class<?> beanClazz = Class.forName(properties.getProperty(beanName));
            return beanClazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("BeanFactory have not [" + beanName + "] bean!", e);
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("[" + beanName + "] instantiation error!", e);
        }
    }
}
