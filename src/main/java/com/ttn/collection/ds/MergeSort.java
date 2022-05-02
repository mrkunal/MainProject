package com.ttn.collection.ds;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int arr[] = {1, 4, 2,3,6,5};

        MergeSort sort = new MergeSort();
        sort.mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).asDoubleStream().forEach(i -> System.out.print("--" + i));


    }


    void mergeSort(int[] arr, int low, int max) {

        if (low < max) {
            int middle = low + (max - low) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, max);
            merge(arr, low, max, middle);   // arr, 0,4 , 2
        }
    }

    void merge(int[] arr, int low, int max, int middle) {

        int firstArrayLength = middle - low + 1;
        int secondArrayLength = max - middle;

        int[] a1 = new int[firstArrayLength];    // 2
        int[] a2 = new int[secondArrayLength]; // 3

        for (int idx = 0; idx < a1.length; idx++) {     //
            a1[idx] = arr[low + idx];
        }
        for (int idx = 0; idx < a2.length; idx++) {
            a2[idx] = arr[idx + middle + 1];
        }

        int idxArrFirst = 0, idxArrSecond = 0;

        int index = low;
        while (idxArrFirst < firstArrayLength && idxArrSecond < secondArrayLength) {
            if (a1[idxArrFirst] < a2[idxArrSecond]) {
                arr[index++] = a1[idxArrFirst++];
//                idxArrFirst++;
            } else {
                arr[index++] = a2[idxArrSecond++];
//                idxArrSecond++;
            }
//            index++;
        }

        while (idxArrFirst < firstArrayLength) {
            arr[index++] = a1[idxArrFirst++];
//            index++;
//            idxArrFirst++;
        }
        while (idxArrSecond < secondArrayLength) {
            arr[index++] = a2[idxArrSecond++];
//            index++;
//            idxArrSecond++;
        }

   //     Arrays.stream(arr).asDoubleStream().forEach(i -> System.out.print("##" + i));
    }

}
