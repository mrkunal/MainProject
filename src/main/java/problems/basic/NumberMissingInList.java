package problems.basic;

import java.util.LinkedList;
import java.util.ListIterator;

public class NumberMissingInList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);


        System.out.println( linkedList.get(1)>>1);
    }

    static void approach1() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(6);
        int size = linkedList.size();
        Integer total = ((size + 1) * ((size + 1) + 1)) / 2;
        ListIterator itr = linkedList.listIterator();
        while (itr.hasNext()) {
            total -= (Integer) itr.next();
        }
        System.out.println("Missing Number" + total);
    }
}
