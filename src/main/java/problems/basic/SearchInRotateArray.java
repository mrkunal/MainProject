package problems.basic;

import array.RotationOfArray;

public class SearchInRotateArray {
    public static void main(String[] args) {
        RotationOfArray.rotateArrayUsingGcdApproach();
        int[] a = RotationOfArray.a;
        int x = 3;
        int l = a.length;
        RotationOfArray.showArray();
        System.out.println(">>>" + bsearch(a, x, RotationOfArray.d, 0, a.length - 1));
    }

    static int bsearch(int[] arr, int x, int rot, int start, int end) {
        int idx = (end - start) / 2;
        int newIdx = (idx + rot) % arr.length;
        if (arr[newIdx] == x) {
            return newIdx;
        } else if (start == end) {
            return -1;
        } else if (arr[newIdx] < x) {
            return bsearch(arr, x, rot, idx, end);
        } else if (arr[newIdx] > x) {
            return bsearch(arr, x, rot, start, idx);
        }
        return -1;
    }


}
