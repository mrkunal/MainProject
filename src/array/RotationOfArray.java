package array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Program to rotate array elements
 *   A=[1,2,3,4,5,6]  and d=2
 *   Result=[3,4,5,6,1,2]
 *
 * */
public class RotationOfArray {

    //    static int[] a = new int[5];
    public static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public static int d = 5;

    public static void showArray() {
        for (int i : a
                ) {
            System.out.print(" " + i);

        }
    }

    public static void rotateArrayUsingApproach1() {
        int temp;
        int count = d;
        while (count > 0) {
            temp = a[0];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = a[i + 1];
            }
            a[a.length - 1] = temp;
            count--;
        }
    }

    public static void main(String[] args) {

        String val="my age, test string , blah";

        List<String> arr = Arrays.asList(val.split(","));
        arr.forEach(s -> System.out.println(s));
    }
    public static void main1(String[] args) {
        RotationOfArray rotationOfArray = new RotationOfArray();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your rollno");
        int rollno = sc.nextInt();

        rotationOfArray.d = rollno;
        System.out.println("Array Before rotation");
        rotationOfArray.showArray();
        rotationOfArray.rotateArrayUsingApproach1();
//        rotationOfArray.rotateArrayUsingGcdApproach();
        rotationOfArray.rotateArrayApproach3();
        System.out.println("Array after rotation");
        rotationOfArray.showArray();
        System.out.println("hello World");
    }

    // This method will only work if the gcd of n size and d is equal
    public static void rotateArrayUsingGcdApproach() {
        int temp;
        int count = 0;
        while (count < d) {
            temp = a[count];
            int i;
            for (i = count; i + d < a.length; i = i + d) {
                a[i] = a[i + d];
            }
            a[i] = temp;
            count++;
        }

    }

   public static void rotateArrayApproach3() {
        int[] temp = new int[d];


        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        int s;

    }
}
