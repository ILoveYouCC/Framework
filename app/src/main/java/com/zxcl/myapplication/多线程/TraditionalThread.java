package com.zxcl.myapplication.多线程;

public class TraditionalThread {

    public static void main(String[] args) {
        /*
         * 线程的第一种创建方式
         * extends Thread，重写 run 方法
         */
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        thread1.start();

        /*
         *线程的第二种创建方式
         * implement Runnable,重写run 方法。然后将runnable对象传入 Thread。
         *
         * 为什么要搞一个Runnable接口来实现多线程呢？从Thread继承不是更方便吗？Runnable接口有如下优势，所以我们常常会选择实现Runnable接口：
         * 1、适合多个程序代码的线程去处理同一个资源。
         * 2、避免Java特性中的单根继承的限制。
         * 3、可以保持代码和数据的分离（创建线程数和数据无关）。
         * 4、更能体现Java面向对象的设计特点。
         */
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread2.start();

        /*
         * 线程的调用优先级
         */
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    System.out.println("Runnable");
                }
            }
        }) {
			/**
			 * 这里重写了 Thread 的 run 方法，所以上面的Runnable的run方法根本就没有调用。
			 */
			@Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    System.out.println("Thread");
                }
            }

		}.start();
    }
}