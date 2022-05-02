package problems.basic;

public class Fibonacci {

    public static void main(String[] args) {

        int x = 17;
        int prev = 0, nxt = 1;
        System.out.print(" "+prev);
        System.out.print(" "+nxt);

        for (int i = 2; i < x; i++) {
            int k=nxt;
            nxt+=prev;
            prev=k;
            System.out.print(" "+nxt);
        }
    }

}
