package com.bala.thread;

public class MultiThreadWithSleep {
    public static void main(String[] args) {
        PrintTread p = new PrintTread();
        new Thread1(p).start();
        new Thread2(p).start();
    }
}

class PrintTread extends Thread {
    public void print(int n) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + n + " i valu " + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Completed Thread " + n + " -------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread {
    PrintTread thread;

    public Thread1(PrintTread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.print(1);
    }
}


class Thread2 extends Thread {
    PrintTread thread;

    public Thread2(PrintTread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.print(2);
    }
}
