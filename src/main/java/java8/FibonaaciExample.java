package java8;

import java.util.HashMap;
import java.util.HashSet;

public class FibonaaciExample {


    static HashMap<Integer, Long> fibonnaciResponseMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(fibonacci(50));
    }

    static long fibonacciWithHighComplexity(int limit) {
        if (limit == 0)
            return 0;
        else if (limit == 1)
            return 1;
        return fibonacciWithHighComplexity(limit-1)+fibonacciWithHighComplexity(limit-2);
    }















        static long fibonacci(int limit) {
        if (limit == 0)
            return 0;
        else if (limit == 1)
            return 1;

        Long firstNumber = fibonnaciResponseMap.get(limit - 1);

        if (firstNumber == null) {
            firstNumber = fibonacci(limit - 1);
            fibonnaciResponseMap.put(limit - 1, firstNumber);
        }
        Long secondNumber = fibonnaciResponseMap.get(limit - 2);
        if (secondNumber == null) {
            secondNumber = fibonacci(limit - 2);
            fibonnaciResponseMap.put(limit - 2, secondNumber);
        }
        return firstNumber + secondNumber;
    }


}
