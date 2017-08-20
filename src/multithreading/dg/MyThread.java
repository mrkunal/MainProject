package multithreading.dg;

/**
 * Created by kunal on 19/8/17.
 */
public class MyThread extends Thread {

    int total = 0;


    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                this.total += i;
            }
            this.notify();
        }
    }
}
