package com.ttn.collection;

import java.util.*;

public class ListExample1 {
    public static void main(String[] args) {

        LinkedList<Integer> list=new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> itr2=list.descendingIterator();
        ListIterator<Integer> itr=list.listIterator();

    //    while (itr.hasNext()){
//            System.out.println(itr.next());
//            System.out.println(itr2.next());
      //  }

        List<Integer> number = Arrays.asList(2,3,4,5,2,4);
        int even = number.stream().filter(x-> x%2==0).reduce(0,(ans,i)-> ans+i);
        System.out.println(even);

    }
}
