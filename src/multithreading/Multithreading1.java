package multithreading;

public class Multithreading1 extends Thread {


    public void run() {
        System.out.println("Running Thread" + this.getId());
    }

    public static void main(String[] args) {

        for(int i=0;i<10;i++) {
            Multithreading1 multithreading1 = new Multithreading1();
            multithreading1.start();
        }

    }
}
