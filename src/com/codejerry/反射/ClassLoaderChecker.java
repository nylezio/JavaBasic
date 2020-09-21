package com.codejerry.反射;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

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

        getMethods();
    }

    /**
     * 动态生成类的字节码,并打印动态类的每个方法
     */
    public static void getMethods() {
        //动态生成代理类
        Class clazzProxy1 = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);

        //获取这个代理类的构造方法
        Method[] methods = clazzProxy1.getMethods();

        System.out.println("---------------------begin Construstors-----------------");
        //遍历构造方法
        for (Method method : methods) {
            //获取每个名称
            String name = method.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append("(");
            //获取每个构造方法的参数类型
            Class[] clazzTypes = method.getParameterTypes();
            for (Class clazzType : clazzTypes) {
                sb.append(clazzType.getName()).append(".");
            }
            if (clazzTypes != null && clazzTypes.length != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
    }
}
