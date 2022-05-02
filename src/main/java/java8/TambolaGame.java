package java8;

import java.util.Scanner;

public class TambolaGame {
    static int arr[][] = {
            {2, -1, 24, 31, -1, 51, -1, 76, -1},
            {-1, 14, 28, 39, -1, -1, 65, -1, 87},
            {-1, 20, -1, -1, 46, 53, -1, 78, 88}

    };

    static int num = 0;

    public static void main(String[] args) {

        printArrayAndCompute();
        takeInput();
    }

    public static void printArrayAndCompute() {

        for (int i = 0; i < 3; i++) {
            System.out.print("[ ");
            for (int j = 0; j < 9; j++) {
                String val = "";
                if (arr[i][j] == num) {
                    arr[i][j] = 0;
                }
                if (arr[i][j] == -1) {
                    val = "--";
                } else if (arr[i][j] == 0) {
                    val = "XX";
                } else {
                    val = String.valueOf(arr[i][j]);
                }
                System.out.print(" " + val);
            }
            System.out.print(" ]");
            System.out.println("");

        }

    }


    public static void takeInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println( num +"Enter number");
            num = sc.nextInt();
            printArrayAndCompute();
        }

    }

}
