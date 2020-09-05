package com.codejerry.线程;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/14 18:45
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String test = "字节2";
        System.out.println("准备获取值");
        try {
            TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        System.out.println("已经获取");
        return test;
    }
}
