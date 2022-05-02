package java8;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntConsumer;

public class ZalandoDemoTest {


    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};
        System.out.println(new Date().toInstant());
        System.out.println(solution(arr));
        System.out.println(new Date().toInstant());


        Object[] ob = new Object[2];
        Object ob2;
        ob2 = ob;

//        System.out.println(ob2.hashCode());
//        System.out.println(ob.hashCode());
    }

    public static int solution(int[] A) {


        final int[] k = {1};
        AtomicReference<Boolean> resultFound = new AtomicReference<>(Boolean.FALSE);
        final AtomicInteger[] answer = {new AtomicInteger()};
        IntConsumer intConsumer = (i) -> {
            if (i != k[0] && !resultFound.get()) {
                resultFound.set(Boolean.TRUE);
                answer[0].set(i);
            } else {
                k[0]++;
            }

        };
        Arrays.stream(A)
                .filter(i -> i > 0).distinct()
                .sorted().forEach(intConsumer);
        if (!resultFound.get())
            return k[0];


        return answer[0].get();


    }
}
