package java8;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MissingInteger {
    public static void main(String[] args) {


        int[] arr = new int[] {
            1, 3, 6, 4, 1, 2
        };
        System.out.println(missing(arr));

    }

    static int missing(int[] A) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Arrays
                .stream(A)
                .filter(i -> i > 0)
                .sorted().distinct()
                .takeWhile(i -> i == atomicInteger.incrementAndGet());

//                .collect(Collectors.toList());


        return atomicInteger.get();


    }

}
