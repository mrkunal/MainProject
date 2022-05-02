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

            for (int i = 0; i < 100; i++) {
                synchronized (DataStore.class) {
                    if (DataStore.size == 10) {
                        DataStore.class.wait();
                    }
                    DataStore.data[DataStore.insertionPointer] = new Long(i + "");
                    System.out.println("P Insertion" + DataStore.insertionPointer + ":" + i);
                    DataStore.insertionPointer = (DataStore.insertionPointer + 1) % 10;
                    DataStore.size++;
                    DataStore.class.notifyAll();
                    Thread.sleep(200);

                }
            }
            //       Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error" + e);
        }
    }
}
