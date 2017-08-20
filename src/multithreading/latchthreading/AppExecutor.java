package multithreading.latchthreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppExecutor {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Worker w1 = new Worker(countDownLatch, "W1");
        Worker w2 = new Worker(countDownLatch, "W2");
        Worker w3 = new Worker(countDownLatch, "W3");
        Worker w4 = new Worker(countDownLatch, "W4");


        executorService.execute(w1);
        executorService.execute(w2);
        executorService.execute(w3);
        executorService.execute(w4);
        executorService.shutdown();
    }
}
