package com.codejerry.线程;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/15 17:20
 */
public class SingleTon {
    private volatile static SingleTon instance;

    private SingleTon(){
    }
    public static SingleTon getInstance() {
        if (instance == null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    instance = new SingleTon();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(SingleTon.getInstance());
        System.out.println(SingleTon.getInstance());
        System.out.println(SingleTon.getInstance());
        System.out.println(SingleTon.getInstance());
    }
}
