package practice;

public class FindMissingNumberInArraySequence {


    public static void main(String[] args) {

        FindMissingNumberInArraySequence obj = new FindMissingNumberInArraySequence();

        int[] arr = {3, 7, 1, 2, 8, 4, 5};
        System.out.println(obj.findNumber(arr));


    }


    int findNumber(int[] arr) {
        int min = Integer.MAX_VALUE;
        int actualSum = 0;
        for (int val = 0; val < arr.length; val++) {
            if (min > arr[val])
                min = arr[val];
            actualSum += arr[val];
        }

        int expectedSum = ((arr.length + 1)/2) * (2 * min + arr.length);
        return expectedSum - actualSum;
    }

}
