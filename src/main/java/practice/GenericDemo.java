package practice;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericDemo {

    static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

    }

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("someString");
        Object val = new String("someString");
        if (stringList.contains(val)) {
            System.out.println("The value is in there");
        } else {
            System.out.println("There's no such value here");
        }

        char[] arr;

    }


}
