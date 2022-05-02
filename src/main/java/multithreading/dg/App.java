package multithreading.dg;

/**
 * Created by kunal on 19/8/17.
 */
public class App {

    public static void main(String[] args) {


        MyThread t1 = new MyThread();
        t1.start();

        try {
            synchronized (t1) {
                System.out.println("Waiting for t1 thread");
                t1.wait();
                System.out.println(t1.total);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interuppted");
        }



    }
}
