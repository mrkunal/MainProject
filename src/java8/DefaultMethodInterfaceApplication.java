package java8;

public class DefaultMethodInterfaceApplication {

    public static void main(String[] args) {
        DefaultApplication defaultApplication=new DefaultApplication();
        defaultApplication.method2();

    }
}

interface DefaultInterface{

    abstract void method1();
    default void method2(){
        System.out.println("Default Method 2 called");
    }
}

class DefaultApplication implements DefaultInterface{
    @Override
    public void method1() {
        System.out.println("Method 1");
    }

    @Override
    public void method2() {
        DefaultInterface.super.method2();
        System.out.println("New Method 2 called");
        //method2();
    }
}
