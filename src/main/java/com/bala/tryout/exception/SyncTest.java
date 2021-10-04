package com.bala.tryout.exception;

public class SyncTest {
    public static void main(String[] args) throws InterruptedException {
        /*A a = new A();
        new Thread(a::main1).start();
        new Thread(a::main1).start();
        Thread.yield();
        System.out.println(a.x);
        System.out.println(a.y);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("bca");
        strings.add("cab");*/
        int x = 0;
        x++;
        System.out.println(x);
        System.out.println(x++);
        System.out.println(++x);
        String abc = "abc";
        String xy = "abc";
        String xy1 = xy + "b";
        String s = new String("abc");
        System.out.println(abc == s);
        System.out.println(abc == xy);
        System.out.println(xy1);
        System.out.println(System.currentTimeMillis());
        System.out.println(s.intern() == abc);
        System.out.println(System.currentTimeMillis());
        System.out.println(s.intern().equals(abc));
        System.out.println(System.currentTimeMillis());
    }
}

class A {
    public int x;
    public int y;

    public void hello() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                System.out.println(i);
            }
        }
    }

    public synchronized void hello1() {
        System.out.println(x);
        for (int i = 0; i < 10; i++) {
//            synchronized (this) {
            System.out.println(i);
//            }
        }
    }

    public synchronized void main1() {
        x++;
        y++;
    }
}