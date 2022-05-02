package java8;

import java.lang.*;

public class RakutenQuestion {

    public int solution(int[] A) {
        // write your code in Java SE 8

        int countWithAscent = 0;
        int countWithDescent = 0;
        boolean isMaxTest = true;
        for (int i = 1; i < A.length; i++) {
            boolean isNice = isNiceHeight(A[i - 1], A[i], isMaxTest);

            if (!isNice) {
                countWithAscent++;
            }

            isNice = isNiceHeight(A[i - 1], A[i], !isMaxTest);

            if (!isNice) {
                countWithDescent++;
            }
            isMaxTest = isMaxTest ? false : true;

        }
         /*
         isMaxTest = false;

         for(int i=1;i<A.length;i++){
         boolean isNice = isNiceHeight(A[i-1],A[i],isMaxTest);
         isMaxTest=isMaxTest?false:true;

          if(!isNice){
            countWithDescent++;
          }
         }
         */

        return Math.min(countWithDescent, countWithAscent);

    }

    public boolean isNiceHeight(int prevElem, int nextElem, boolean isMaxTest) {
        if (isMaxTest) {
            return prevElem < nextElem;
        } else {
            return prevElem > nextElem;
        }
    }


}
