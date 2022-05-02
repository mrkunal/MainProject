package com.ttn.collection;

public class N26Question {

    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    class Solution {
        public int solution(int[] A) {

            if (A.length == 0)
                return 0;

            int castleCount=1;
            Boolean isIncreasing=null;
            int min=A[0];
            int max=A[0];

            for(int index=1; index<A.length; index++) {

                if(isIncreasing == null) {
                    int minimum = Math.min(min,A[index]);
                    int maximum = Math.max(max,A[index]);

                    if (minimum != min) {
                        isIncreasing=false;
                        castleCount++;
                        min=minimum;
                    } else if(maximum != max){
                        isIncreasing=true;
                        castleCount++;
                        max=maximum;
                    }

                } else {
                    if(isIncreasing){
                        if(A[index] < max) {
                            isIncreasing = false;
                            castleCount++;
                            min = A[index];
                        } else {
                            max = Math.max(max,A[index]);
                        }
                    } else {
                        if(A[index] > min ) {
                            isIncreasing = true;
                            castleCount++;
                            max = A[index];
                        } else {
                            min = Math.min(min,A[index]);
                        }
                    }
                }
            }
            return castleCount;
        }
    }

}
