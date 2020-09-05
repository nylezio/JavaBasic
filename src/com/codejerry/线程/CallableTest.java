package com.codejerry.线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/14 18:47
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask ft = new FutureTask(new MyCallable());
        new Thread(ft).start();
        if (!ft.isDone()) {
            System.out.println("尚未完成");
        }
        System.out.println("线程获取的值为:" + ft.get());
    }
}
