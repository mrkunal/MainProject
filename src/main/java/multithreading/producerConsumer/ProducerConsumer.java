package multithreading.producerConsumer;

/**
 * Created by kunal on 18/8/17.
 */
public class ProducerConsumer extends Thread {
    @Override
    public void run() {
        System.out.println("thread called" + getPriority());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
  //  ProducerConsumer producerConsumer=new ProducerConsumer();
  //  producerConsumer.start();

        Thread t1=new Thread(new Producer());
        Thread t2=new Thread(new Consumer());
        Thread t3=new Thread(new Consumer());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("interrupt called");

    }
}
