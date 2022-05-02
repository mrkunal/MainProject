package com.ttn.collection;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class PracticeTest {

    public static void main(String[] args) {

        calculateDistinct();

        LinkedHashSet<Integer> set=new LinkedHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(0);
        set.add(0);
        System.out.println(set);
    }

    static void calculateDistinct() {
        int[] arr = {1, 2, 4, 5, 2};

        Assert.assertEquals("Returning distinct", 4, Arrays.stream(arr).distinct().count());

        int[] arrNew = {1, 1, 2, 2, 3, 3, 4, 5};


    }
}
