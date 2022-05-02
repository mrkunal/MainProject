package java8;

//import javafx.collections.transformation.SortedList;

import java.util.*;

public class ZalandoFinalTest {
 /*if(A.length<=4)
            return 0;

    int result = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 2; i++) {
        for (int j = i + 2; j < A.length - 1; j++) {
            int weight = A[i] + A[j];
            if (result > weight)
                result = weight;
        }
    }
        return result;
}*/
    public static void main(String[] args) {
        String input = "50552";
//        int[] arr = {5, 2, 4, 6, 3, 7};
        int[] arr = {4, 2, 2, 5, 1, 5,8};
//        int[] arr = {1, 2, 3, 4, 5};

        System.out.println(solution2(arr));
        System.out.println(solution3(arr));
//        System.out.println(solution(input));
    }

    public static int sum(HashSet<Integer> set, int elem, int[] A) {
        final int[] res = {Integer.MAX_VALUE};
        set.parallelStream().forEach(i -> {
            int val=A[i] + A[elem];
            if (res[0] > val)
                res[0] = val;
        });
        return res[0];
    }

    public static int solution3(int[] A) {
        int result = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < A.length - 2; i++) {
            set.add(i);
            int weight= sum(set,i + 2,A);
            if (weight < result) {
                result = weight;
            }

        }
        return result;
    }


    public static int solution2(int[] A) {

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 2; i++) {
            for (int j = i + 2; j < A.length - 1; j++) {
                int weight = A[i] + A[j];
                if (result > weight)
                    result = weight;
                System.out.println("(" + i + "," + j + ") Value :" + A[i] + " + " + A[j] + "=" + weight);
            }
        }
        return result;
    }


    public static int solution(String S) {

        int result = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            int intValue = Integer.parseInt(S.substring(i, i + 2));
            if (intValue > result) {
                result = intValue;
            }
        }
        return result;
    }

}
