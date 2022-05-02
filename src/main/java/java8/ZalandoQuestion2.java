package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ZalandoQuestion2 {

    public static void main(String[] args) {


        System.out.println(minDeletions(        "ccaaffddecee"));
        System.out.println(minDeletionsV2(        "ccaaffddecee"));
//        "aab"
//        "aaabbbcc"
//        "ceabaacb"
//        "eeee"
//         "ccaaffddecee"

    }


    public static int minDeletionsV2(String S) {
        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] characterArray = S.toCharArray();
        int minimumCount = 0;
        int N = S.length();
        for (int i = 0; i < N; i++) {
            if (hashMap.containsKey(characterArray[i])) {
                hashMap.put(characterArray[i],
                        hashMap.get(characterArray[i]) + 1);
            } else {
                hashMap.put(characterArray[i], 1);
            }
        }

//        Stream.of()
//                .collect(Collectors.toMap(i,v->{}));


        hashMap.entrySet().parallelStream().forEach(entry->{
            frequencyQueue.add(entry.getValue());
        });
        while (!frequencyQueue.isEmpty()) {
            int maximumFrequent = frequencyQueue.peek();
            frequencyQueue.remove();
            if (frequencyQueue.isEmpty()) {
                return minimumCount;
            }
            if (maximumFrequent == frequencyQueue.peek()) {
                if (maximumFrequent > 1) {
                    frequencyQueue.add(maximumFrequent - 1);
                }
                minimumCount++;
            }
        }
        return minimumCount;

    }


    public static int minDeletions(String S) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int minimumCount = 0;

        char[] characterArray = S.toCharArray();

        int N = S.length();
        for (int i = 0; i < N; i++) {
            if (hashMap.containsKey(characterArray[i])) {
                hashMap.put(characterArray[i],
                        hashMap.get(characterArray[i]) + 1);
            } else {
                hashMap.put(characterArray[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> it : hashMap.entrySet()) {
            frequencyQueue.add(it.getValue());
        }

        while (!frequencyQueue.isEmpty()) {
            int maximumFrequent = frequencyQueue.peek();
            frequencyQueue.remove();
            if (frequencyQueue.isEmpty()) {
                return minimumCount;
            }

            if (maximumFrequent == frequencyQueue.peek()) {
                if (maximumFrequent > 1) {
                    frequencyQueue.add(maximumFrequent - 1);
                }

                minimumCount++;
            }
        }

        return minimumCount;

    }

}
