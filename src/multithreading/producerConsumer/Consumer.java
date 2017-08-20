package multithreading.producerConsumer;

import java.util.Date;

/**
 * Created by kunal on 17/8/17.
 */
public class Consumer implements Runnable {
    @Override
    public void run() {
        System.out.println("Consumer" + Thread.currentThread());
        System.out.println("<<<" + new Date());

        for (int i = 0; i < 10; i++) {

            System.out.println("Consumer Called");
                Thread.yield();

        }
    }
}
