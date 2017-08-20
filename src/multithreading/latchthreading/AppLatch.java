package multithreading.latchthreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kunal on 20/8/17.
 */
public class AppLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Worker w1 = new Worker(countDownLatch, "W1");
        Worker w2 = new Worker(countDownLatch, "W2");
        Worker w3 = new Worker(countDownLatch, "W3");
        Worker w4 = new Worker(countDownLatch, "W4");
        Worker w5 = new Worker(countDownLatch, "W5");
        Worker w6 = new Worker(countDownLatch, "W6");
        Worker w7 = new Worker(countDownLatch, "W7");
        Worker w8 = new Worker(countDownLatch, "W8");
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();
        w6.start();
        w7.start();
        w8.start();


        System.out.println("Waiting for execution Completion");


        System.out.println("Status : w1" + w1.getState());
        System.out.println("Status : w2" + w2.getState());
        System.out.println("Status : w3" + w3.getState());
        System.out.println("Status : w4" + w4.getState());
        System.out.println("Status : w5" + w5.getState());
        System.out.println("Status : w6" + w6.getState());
        System.out.println("Status : w7" + w7.getState());
        System.out.println("Status : w8" + w8.getState());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All Threads Completed");

        System.out.println("Status : w1" + w1.getState());
        System.out.println("Status : w2" + w2.getState());
        System.out.println("Status : w3" + w3.getState());
        System.out.println("Status : w4" + w4.getState());
        System.out.println("Status : w5" + w5.getState());
        System.out.println("Status : w6" + w6.getState());
        System.out.println("Status : w7" + w7.getState());
        System.out.println("Status : w8" + w8.getState());

    }
}
