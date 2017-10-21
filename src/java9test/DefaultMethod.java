public class DefaultMethod implements Left, Right {

    public void show() {
        System.out.println(">>>" + Left.i);
        Left.super.show();
    }
    public void h(){
         System.out.println("kkkk");
    }

    public static void main(String args[]) {

        DefaultMethod d = new DefaultMethod();
        d.show();
        System.out.println("###" + DefaultMethod.i);
    }

}

interface Left {
    int i = 2;

    default void show() {
        System.out.println("Left Show");
        h();
    }

    default void h() {
        System.out.println("hhh");
    }
}

interface Right {


    default void show() {
        System.out.println("Right Show");
    }
}
