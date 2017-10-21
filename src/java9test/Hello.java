package java9test;

public class Hello {

    int x = 10;

    public static void main(String[] args) {
        System.out.println("Hellow");
        Hello t = new Hello();
        t.m2();

        Interface1 p1=new Interface1() {
            @Override
            public void m1() {
                System.out.println("helloplease");
            }
        };

        p1.m1();

    }

    public void m2() {
        int y=20;
        Interface1 i = () -> {
            System.out.println(">>x" + x);
            System.out.println(">>y" + y);
            x=100;
        };
        Interface1 i1 = () -> {
            System.out.println(">>x" + x);
            System.out.println(">>y" + y);
            x=100;
        };
        i.m1();
    }


}


interface Interface1 {
    public void m1();
}

