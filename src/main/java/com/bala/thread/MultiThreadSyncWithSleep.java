package com.bala.thread;

public class MultiThreadSyncWithSleep {
    public static void main(String[] args) {
        PrintTread1 p = new PrintTread1();
        new Thread11(p).start();
        new Thread21(p).start();
    }
}

class PrintTread1 extends Thread {
    public void print(int n) {
        synchronized (this) {
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
}

class Thread11 extends Thread {
    PrintTread1 thread;

    public Thread11(PrintTread1 thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.print(1);
    }
}


class Thread21 extends Thread {
    PrintTread1 thread;

    public Thread21(PrintTread1 thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.print(2);
    }
}
