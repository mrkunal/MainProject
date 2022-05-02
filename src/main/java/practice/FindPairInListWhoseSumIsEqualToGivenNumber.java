package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindPairInListWhoseSumIsEqualToGivenNumber {


    public static void main(String[] args) {

        int[] arr={5,7,1,2,8,4,3};
        int sum=10;
        FindPairInListWhoseSumIsEqualToGivenNumber obj=new FindPairInListWhoseSumIsEqualToGivenNumber();
        System.out.println("The sum exists :"+obj.isPairExist(arr,sum));
    }


    boolean isPairExist(int[] arr, int targetSum) {

        Set<Integer> valuesSet = new HashSet<>();
        for (int val = 0; val < arr.length; val++) {
            valuesSet.add(arr[val]);
        }


        for (Integer val : valuesSet) {
            if (val < targetSum) {
                if (valuesSet.contains(targetSum - val)) {
                    return true;
                }
            }
        }
        return false;
    }
}
