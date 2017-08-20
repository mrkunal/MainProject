package multithreading.dg;

/**
 * Created by kunal on 19/8/17.
 */
public class Display {
    String a;

    public static synchronized void showDisplay(String name){
        try {
            for (int i=0;i<10;i++){

                System.out.println("Displaying "+name);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}
