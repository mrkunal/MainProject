package multithreading.latchthreading;

import multithreading.producerConsumer.Consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppExecutor {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker w1 = new Worker(countDownLatch, "W1");
        Worker w2 = new Worker(countDownLatch, "W2");
        Worker w3 = new Worker(countDownLatch, "W3");
        Worker w4 = new Worker(countDownLatch, "W4");


        executorService.execute(w2);
        executorService.execute(w3);
        executorService.execute(w4);
        executorService.shutdown();

//        executorService.awaitTermination(10000, TimeUnit.SECONDS);


        System.out.println("Completed--");
    }
}
