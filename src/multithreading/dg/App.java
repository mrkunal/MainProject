package multithreading.dg;

/**
 * Created by kunal on 19/8/17.
 */
public class App {

    public static void main(String[] args) {

        Display d1=new Display();
        Display d2=new Display();

    Thread t1=new Thread(new MyThread(d1,"Kunal"));
    Thread t2=new Thread(new MyThread(d2,"Kunu"));

    t1.start();
    t2.start();
    }
}
