package com.ttn.collection.SinglyLinkedList;

public class SinglyLinkedList<T> {

    private SinglyLinkedListNode<T> startSinglyLinkedListNode;

    public void add(T data) {

        Double db=new Double(4/3);

        SinglyLinkedListNode<T> singlyLinkedListNode = new SinglyLinkedListNode<>();
        singlyLinkedListNode.setData(data);
        singlyLinkedListNode.setNext(null);

        SinglyLinkedListNode<T> head;
        head = startSinglyLinkedListNode;

        if (head == null) {
            startSinglyLinkedListNode = singlyLinkedListNode;
        } else {
            while (head.getNext() != null) {
                head = head.getNext();
            }
            head.setNext(singlyLinkedListNode);
        }
    }

    public void display() {
        SinglyLinkedListNode<T> head;
        head = startSinglyLinkedListNode;
        while (head != null) {
            System.out.println(":" + head.getData());
            head = head.getNext();
        }
    }
    // Iteratable ,COmparator ,Comparable Interfaces

}
