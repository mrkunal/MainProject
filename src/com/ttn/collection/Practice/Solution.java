package com.ttn.collection.Practice;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        //   int max=0;
        ArrayList<Integer> al=new ArrayList<Integer>(Collections.nCopies(n, 0));

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            for(int i=a-1;i<b;i++)
            {
                System.out.println("##"+al.get(i));

                al.add(i,al.get(i)+ k);

                //         max = max < al.get(i) ? al.get(i).intValue() :max;

                System.out.println(i+"-"+a+"#"+b+ ""+ al);

            }

        }

        //    System.out.println(max);


        in.close();
    }
}
