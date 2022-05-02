package multithreading.latchthreading;

import multithreading.producerConsumer.Consumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AppExecutor {

    public AppExecutor() {
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker w1 = new Worker(countDownLatch, "W1");
        Worker w2 = new Worker(countDownLatch, "W2");
        Worker w3 = new Worker(countDownLatch, "W3");
        Worker w4 = new Worker(countDownLatch, "W4");


//        executorService.execute(w2);
//        executorService.execute(w3);
//        executorService.execute(w4);
//        executorService.shutdown();

//        executorService.awaitTermination(10000, TimeUnit.SECONDS);


        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

   Integer count=new Integer(1);
        list.forEach( elem->{
            //count++;
            Integer e1=elem;
            System.out.println("Hello"+elem);
            System.out.println(e1);
        });
//        System.out.println("Completed--");
    }
}
