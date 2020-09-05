package com.codejerry.线程;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/15 17:49
 */
public class SingleTonIn {
    private SingleTonIn() {

    }
    private static class SingleTonHolder {
        private static final SingleTonIn INSTANCE = new SingleTonIn();
    }
    public static SingleTonIn getInstance() {
        return SingleTonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(SingleTonIn.getInstance());
        System.out.println(SingleTonIn.getInstance());
        System.out.println(SingleTonIn.getInstance());
        System.out.println(SingleTonIn.getInstance());
    }
}
