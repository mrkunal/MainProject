package java8;

public class ExceptionHandlingTest {

    public static void main(String[] args) {
        scneario2();

//        System.out.println(scenario1());
    }

    static class A {
        void m1(A a) {
            System.out.println("m1 method in class A");
        }


        void p(Object o) {
            System.out.println("o called");
        }
        void p(String s) {
            System.out.println("s called");
        }void p(Integer s) {
            System.out.println("i called");
        }


    }

    static class B extends A {
        public void m1(A a) {
            System.out.println("m1 method in class B");
        }
    }

    public static void scneario2() {
        A a = new A();
        a.m1(a);
        a.m1(new B());
        a.p(6);

        B b = new B();
        b.m1(null);

        a = b;
        a.m1(null);
        a.m1(new A());

      //  a.p((Integer) null);
    }

    static int scenario1() {

        try {
            System.out.println("Main called");
            throw new RuntimeException("");
        } catch (Exception e) {
            System.out.println("catch block called");
            return 1;
        } finally {
            System.out.println(" finally also called");
            if (true) {
                //   return 2;
            }
            //   throw new RuntimeException("hah");

        }

    }
}


class BinaryTree<T> {

    private int data;
    private T leftNode;
    private T rightNode;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public T getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(T leftNode) {
        this.leftNode = leftNode;
    }

    public T getRightNode() {
        return rightNode;
    }

    public void setRightNode(T rightNode) {
        this.rightNode = rightNode;
    }
}