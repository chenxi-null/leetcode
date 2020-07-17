package com.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Foo {

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);
    private Semaphore semaphore3 = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
        semaphore1.acquire();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphore1.release();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---|---");
        Foo foo = new Foo();
        run(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                foo.first(() -> System.out.println('1'));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        run(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                foo.second(() -> System.out.println('2'));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        run(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
                foo.third(() -> System.out.println('3'));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println("---over---");
    }

    public static void run(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.setDaemon(true);
        t.start();
    }
}
/*
a - b - c
 */