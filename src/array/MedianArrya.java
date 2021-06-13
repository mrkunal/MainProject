package array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MedianArrya {

    public static void main(String[] args) {

        MedianArrya medianArrya = new MedianArrya();
        int[] arr1 = {1, 1, 2, 3};
        int[] arr2 = {4, 6};

//        System.out.println(medianArrya.findMedianSortedArrays(arr1, arr2));
//        System.out.println(medianArrya.distributeCandies(arr1));
        System.out.println(medianArrya.sumOfUnique(arr1));

    }

    public int sumOfUnique(int[] nums) {

        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(s -> s)).entrySet().stream().filter(k -> {
                    return k.getValue().size() < 2;
                }).mapToInt(k -> k.getKey()).sum();

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length);
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);

        Arrays.sort(arr);

        double d;

        if (arr.length % 2 == 0) {
            d = arr[arr.length / 2] + arr[arr.length / 2 - 1];

            d = d / 2;
        } else {
            d = arr[arr.length / 2];
        }

        return d;
    }

    public int distributeCandies(int[] candyType) {

        Set<Integer> uniqueCandies = new HashSet<>();
        int maxCandies = candyType.length / 2;
        for (int i = 0; i < candyType.length; i++) {
            uniqueCandies.add(candyType[i]);
        }

        if (maxCandies <= uniqueCandies.size()) {
            return maxCandies;
        } else {
            return uniqueCandies.size();
        }


    }
}
