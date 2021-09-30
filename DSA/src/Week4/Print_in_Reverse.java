package Week4;

public class Print_in_Reverse {
    public static class Node {
        int val;
        Node next = null;
        Node(int val) {this.val = val;}
        Node(int val, Node next) {this.val = val; this.next = next;}
    }

    public static void reversePrint(Node head) {
        if (head.next != null) reversePrint(head.next);
        System.out.println(head.val);
    }
}
