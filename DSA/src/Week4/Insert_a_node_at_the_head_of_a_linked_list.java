package Week4;

public class Insert_a_node_at_the_head_of_a_linked_list {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node insertNodeAtHead(Node head, int val) {
        Node newN = new Node(val);
        newN.next = head;
        return newN;
    }
}
