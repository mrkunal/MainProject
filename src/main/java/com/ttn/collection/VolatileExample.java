package com.ttn.collection;

public class VolatileExample {

    public static void main(String[] args) throws Exception {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    NonVolatile.val++;
                    System.out.println(NonVolatile.val);

//                    Volatile.val++;
//                    System.out.println(Volatile.val);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("From non volatile" + NonVolatile.val);
//                    System.out.println("From volatile" + Volatile.val);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable2);

        t2.start();
        t1.start();

        NonVolatile.lock.wait();

    }

}

class NonVolatile {

    public static int val = 10;
    public static String lock;
}

class Volatile {

    public static volatile int val = 10;
}