package com.codejerry.反射;

/**
 * @author: codeJerry
 * @description:
 * //        classLoader 加载未初始化类
 * //        Class.forName会输出静态代码块的内容 说明已经将类初始化
 * 在Spring IOC中会加载很多类，采用懒加载的方式，所以需要使用到类加载器ClassLoader这种方式
 * @date: 2020/07/11 16:25
 */
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        MyClassLoader m = new MyClassLoader("C:\\Users\\76582\\Documents\\", "MyClassLoader");
//        classLoader 加载未初始化类
        Class c = m.loadClass("Wali");
//        会输出静态代码块的内容 说明已经将类初始化
        Class.forName("com.codejerry.反射.Robot");
        System.out.println(c.newInstance());
    }
}
