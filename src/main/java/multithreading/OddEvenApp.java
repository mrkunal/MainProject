package multithreading;

public class OddEvenApp {

    public static void main(String[] args) {

        Boolean lock=new Boolean(false);
        EvenClass evenClass=new EvenClass(lock);
        OddClass oddClass=new OddClass(lock);
        oddClass.run();
        evenClass.run();

    }
}

class EvenClass implements Runnable {

    private Boolean lock;

    public EvenClass() {
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public EvenClass(Boolean lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i <= 10; i = i + 2) {

                while (lock) {
                    synchronized (lock) {
                        lock.wait();
                        System.out.println("Executing even wait");
                        Thread.sleep(1000);
                        lock.notify();

                    }
                }

                 /*   synchronized (lock) {
                        System.out.println("" + i);
                        lock = false;
                        }*/

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OddClass implements Runnable {

    private Boolean lock;

    public OddClass() {
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public OddClass(Boolean lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i = i + 2) {

                while (!lock)
                {
                    synchronized (lock) {
                        System.out.println("Executing Odd wait");
                        Thread.sleep(1000);
                        lock.notify();
                        lock.wait();
                    }
                }
/*
                    synchronized (lock) {
                       // lock.wait();
                        System.out.println("" + i);
                        lock = true;
               //         Thread.sleep(1000);
                    //    lock.notify();
                    }*/



            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
