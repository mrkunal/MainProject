package com.ttn.collection;

import java.util.Arrays;

public class N26Question2 {


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8


            int size=A.length;
            Arrays.sort(A);
            int incrementalMiddle=A[size/2];
            int decrementalMiddle=A[(size/2)-1];
            int incrementalOperations= 0, decrementalOperations=0;
            for(int elem:A){
                incrementalOperations+= Math.abs(elem-incrementalMiddle);
                decrementalOperations+= Math.abs(elem-decrementalMiddle);
            }

            return Math.min(decrementalOperations,incrementalOperations);
        }
    }

}
