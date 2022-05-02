package multithreading.producerConsumer;

import java.util.Date;

/**
 * Created by kunal on 17/8/17.
 */
public class Consumer implements Runnable {

    @Override
    public void run() {
        System.out.println("Consumer" + Thread.currentThread());

        try {
            while(true)
            {
                synchronized (DataStore.class) {
                    if (DataStore.size == 0) {
                        DataStore.class.wait();
                    }
                    System.out.println("Received " + DataStore.fetchPointer + ":" + DataStore.data[DataStore.fetchPointer]);
                 //   DataStore.data[DataStore.fetchPointer] = new Long(i + "");
                    DataStore.fetchPointer = (DataStore.fetchPointer + 1) % 10;
                    DataStore.size--;
                    DataStore.class.notify();
                }
            }

            //       Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error" + e);
        }
    }
}
