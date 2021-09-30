package Week4;

public class Reverse_a_linked_list {
    public static class Node {
        int val;
        Node next = null;
        Node(int val) {this.val = val;}
        Node(int val, Node next) {this.val = val; this.next = next;}
    }

    public static Node reverse(Node head) {
//        Node cur = head, prev = null, next = null;
//        while(cur!=null) {
//            next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
        if (head == null || head.next == null) {
            return head;
        }
        Node newH = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newH;
    }
}
