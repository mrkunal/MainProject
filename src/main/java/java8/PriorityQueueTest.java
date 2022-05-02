package java8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {


    public static void main(String[] args) {


        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 >= o2 ? -1 : 1;
            }
        };
//        PriorityQueue<Integer> pQueue = new PriorityQueue<>(c);
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(c);
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(50);
        pQueue.add(40);
        pQueue.add(30);
        pQueue.add(15);

//        // Printing the top element of PriorityQueue
//        System.out.println(pQueue.peek());
//
//        // Printing the top element and removing it
//        // from the PriorityQueue container
//        System.out.println(pQueue.poll());
//
//        // Printing the top element again
//        System.out.println(pQueue.peek());

        while (!pQueue.isEmpty()) {
            System.out.println(pQueue.poll());
        }


//        int year=1700;
//
//        float val=year/100;
//        System.out.println( Math.round(val)*100);

    }
}
