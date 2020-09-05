package com.codejerry.反射;


public class Robot {
    static {
        System.out.println("我是静态代码块");
    }
    private String name;
    public void sayHi(String hello) {
        System.out.println(hello + " " + name);
    }
    private String throwHello(String tag){
        return "Hello " + tag;
    }
}

