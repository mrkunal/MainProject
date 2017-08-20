package multithreading.dg;

/**
 * Created by kunal on 19/8/17.
 */
public class MyThread implements Runnable {

    private Display display;
    private String name;
    public MyThread(Display display,String name) {
    this.display=display;
    this.name=name;
    }

    @Override
    public void run() {
        display.showDisplay(this.name);
    }
}
