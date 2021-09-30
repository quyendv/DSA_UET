package Week4;

public class Insert_a_node_at_a_specific_position_in_a_linked_list {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node insertNodeAtPosition(Node head, int val, int pos) {
//        Node newN = new Node(val);
//        if (pos == 0) {
//            newN.next = head;
//            return newN;
//        }
//        Node p = head;
//        for (int i = 0; i < pos - 1; i++) p = p.next;
//        newN.next = p.next;
//        p.next = newN;
//        return head;
        if (pos == 0) {
            Node newN = new Node(val);
            newN.next = head;
            return newN;
        }
        head.next = insertNodeAtPosition(head.next, val, pos - 1);
        return head;
    }
}
