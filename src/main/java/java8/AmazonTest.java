package java8;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalImbalance' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY weight as parameter.
     */

    public static long getTotalImbalance(List<Integer> weight) {


        int size = weight.size();
        int q,r;
        int sum=0;
        int[] arr = weight.stream().mapToInt(Integer::intValue).toArray();

        int block=size;

        for(int k=2;k<=block;k++){
            for(int i=0;i<size;i++){

                if(i+k>size)
                    break;
                sum+= getSubImbalance(arr, i, i+k);
            }
        }

        return sum;
    }



    public static long getSubImbalance(int[] arr,int startIndex,int endIndex){

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=startIndex;i<endIndex;i++){

            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        return max-min;

    }

}

public class AmazonTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> weight = IntStream.range(0, weightCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.getTotalImbalance(weight);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
