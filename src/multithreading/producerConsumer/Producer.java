package multithreading.producerConsumer;

import java.util.Date;

/**
 * Created by kunal on 17/8/17.
 */
public class Producer implements Runnable {

    @Override
    public void run() {
        System.out.println("Producer" + Thread.currentThread());
        System.out.println(">>" + new Date());

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Producer Called");

            }
            System.out.println("P Completed 1.1");

            Thread.sleep(4000);
            System.out.println("P Completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error"+e);
        }
    }
}
