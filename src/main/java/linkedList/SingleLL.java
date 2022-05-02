package linkedList;

public class SingleLL {
    Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    boolean add(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return true;
    }

    void display(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.getData());
            temp=temp.next;
        }
    }

}
