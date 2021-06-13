package practice;

import java.util.Comparator;
import java.util.ListIterator;

public class MergeSortedLinkedListsIntoOne {

    class CustomList implements Comparable<CustomList> {
        int value;
        CustomList next;

        public CustomList(int value, CustomList next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public int compareTo(CustomList o) {
            return this.value > o.value ? 1 : (this.value < o.value ? -1 : 0);
        }
    }


    public static void main(String[] args) {

        CustomList list1;
        CustomList list2;

        int[] arr = {4, 8, 15, 19};
        int[] arr2 = {7, 9, 10, 16};

        MergeSortedLinkedListsIntoOne obj = new MergeSortedLinkedListsIntoOne();
        list1 = obj.createList(arr);
        list2 = obj.createList(arr2);

        CustomList customList = obj.merge(list1, list2);

        while (customList != null) {
            System.out.println(customList.value);
            customList = customList.next;
        }

    }

    CustomList merge(CustomList list1, CustomList list2) {

        CustomList head = null;
        CustomList current = null;
        if (list1 == null && list2 == null) {
            return head;
        }


        while (list1 != null || list2 != null) {

            if (list1 == null && list2 != null) {
                if (current != null)
                    current.next = list2;
                else
                    head = list2;
                return head;
            } else if (list2 == null && list1 != null) {
                if (current != null)
                    current.next = list1;
                else
                    head = list1;
                return head;
            }

            if (list1.compareTo(list2) > 0) {
                if (head == null) {
                    head = list2;
                    current = head;
                } else {
                    current.next = list2;
                    current=current.next;
                }
                list2 = list2.next;
            } else {
                if (head == null) {
                    head = list1;
                    current = head;
                } else {
                    current.next = list1;
                    current=current.next;

                }
                list1 = list1.next;
            }

        }
        return head;


    }

    CustomList createList(int[] arr) {
        CustomList head = null;
        CustomList current = head;
        for (int i = 0; i < arr.length; i++) {
            CustomList customList = new CustomList(arr[i], null);
            if (head == null) {
                head = customList;
                current = head;
            } else {
                current.next = customList;
                current = customList;
            }
        }

        return head;
    }


}
