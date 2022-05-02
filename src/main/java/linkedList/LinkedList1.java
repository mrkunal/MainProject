package linkedList;

import java.util.LinkedHashMap;

public class LinkedList1 {

    public static void main(String[] args) {
        SingleLL singleLL = createLinkedList();
        createLoopAndCheckLoop();

    }

    static SingleLL createLinkedList() {
        SingleLL singleLL = new SingleLL();

        for (int i = 0; i < 4; i++) {
            Node node = new Node();
            node.setData(i);
            singleLL.add(node);
        }
        singleLL.display();
        return singleLL;
    }

    static boolean checkLinkedListContainsLoopUsingHashTable(SingleLL singleLL) {

        LinkedHashMap<Integer, Node> linkedHashMap = new LinkedHashMap<>();

        Node temp = singleLL.getHead();

        while (temp != null) {
            int hashcode = temp.hashCode();
            if (linkedHashMap.get(hashcode) != null) {
                return true;
            } else {
                linkedHashMap.put(hashcode, temp);
            }
            temp = temp.getNext();
        }
        return false;
    }

    static void createLoopAndCheckLoop() {
        SingleLL singleLL = createLinkedList();
        //  singleLL.getHead().getNext().getNext().setNext(singleLL.getHead());
        System.out.println(checkLinkedListContainsLoopUsingHashTable(singleLL));
        System.out.println(checkLoopUsingFloydAlgo(singleLL));

    }

    static boolean checkLoopUsingFloydAlgo(SingleLL singleLL) {
        Node temp1, temp2;
        temp1 = singleLL.getHead();
        temp2 = temp1.getNext();

        while (temp2 != null) {
            if (temp1.equals(temp2)) {
                return true;
            }
            temp1 = temp1.getNext();

            temp2 = temp2.getNext() != null ? temp2.getNext().getNext() : null;

        }

        return false;
    }
}
