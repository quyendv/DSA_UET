package Week4;

public class Insert_a_Node_at_the_Tail_of_a_Linked_List {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node insertNodeAtTail (Node head, int val) {
//        Node newN = new Node(val);
//        if (head == null) return newN;
//        Node p = head;
//        while (p.next != null) p = p.next;
//        p.next = newN;
//        return head;
        if (head == null) return new Node(val);
        head.next = insertNodeAtTail(head.next, val);
        return head;
    }
}
