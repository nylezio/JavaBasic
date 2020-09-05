package com.codejerry.线程;

import java.util.concurrent.TimeUnit;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/15 19:56
 */
public class VolatileTest {
    public volatile boolean shutdown = false;
    public void close(){
        shutdown = true;
    }
    public void doWork() {
        while (!shutdown) {
            System.out.println("safe....");
        }
    }


    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();

        try {
            volatileTest.doWork();
            TimeUnit.SECONDS.sleep(2);
            volatileTest.close();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
