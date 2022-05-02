package com.ttn.collection.SinglyLinkedList;

public class SinglyLinkedListNode<T> {
    private T data;
    private SinglyLinkedListNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
