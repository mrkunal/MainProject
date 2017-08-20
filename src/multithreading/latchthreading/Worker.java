package multithreading.latchthreading;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/**
 * Created by kunal on 20/8/17.
 */
public class Worker extends Thread {

    CountDownLatch latch;
    String name;

    public Worker(CountDownLatch latch, String name) {
        this.latch = latch;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Worker Thread L" + latch.getCount() + ": " + name + " :" + Thread.currentThread());
            try {
                URL url = new URL(
                        "https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwjS_Nef9OXVAhUFL48KHQivAN0QjRwIBw&url=https%3A%2F%2Fpixabay.com%2Fen%2Fphotos%2Fsnow%2F&psig=AFQjCNH1wqKGnxjgHaPb35A-2yeAX2IE6w&ust=1503321797905474");
                InputStream in = new BufferedInputStream(url.openStream());
                // Thread.sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Worker Thread Done : " + latch.getCount() + ":" + name + " :" + Thread.currentThread());
        latch.countDown();

    }
}
