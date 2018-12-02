package ru.job4j.jmmproblems;

/**
 * @author Aleksandr Fedorov (msg2fedorov@gmail.com)
 * Deadlock example
 */

public class Deadlock {
    public static Object lockFirst = new Object();
    public static Object lockSecond = new Object();

    public static void main(String[] args) {
        ThreadDemo1 t1 = new ThreadDemo1();
        ThreadDemo2 t2 = new ThreadDemo2();
        t1.start();
        t2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (lockFirst) {
                System.out.println("Thread 1: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) { }
                System.out.println("Thread 1: Waiting for lock 2...");

                synchronized (lockSecond) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (lockSecond) {
                System.out.println("Thread 2: Holding lock 2...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) { }
                System.out.println("Thread 2: Waiting for lock 1...");

                synchronized (lockFirst) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}