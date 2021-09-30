package Week4;

public class Delete_a_Node {
    public static class Node {
        int val;
        Node next = null;
        Node(int val) {this.val = val;}
        Node(int val, Node next) {this.val = val; this.next = next;}
    }

    public static Node deleteNode(Node head, int pos) {
//        if (pos == 0) {
//            return head.next;
//        }
//        Node p = head;
//        for (int i = 0; i < pos - 1; i++) p = p.next;
//        p.next = p.next.next;
//        return head;

        if (pos == 0) return head.next;
        head.next = deleteNode(head.next, pos - 1);
        return head;
    }
}
