package Week4;

public class Print_the_Elements_of_a_Linked_List {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        for (Node p = head; p != null; p = p.next)
            System.out.println(p.val);
    }
}
