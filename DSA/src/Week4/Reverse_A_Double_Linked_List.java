package Week4;

public class Reverse_A_Double_Linked_List {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
//        DoublyLinkedListNode prev = null, cur = head;
//        while (cur != null) {
//            cur.prev = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = cur.prev;
//        }
//        return prev;

        if (head == null) return null;
        if (head.next == null) {
            head.prev = null;
        }
        DoublyLinkedListNode newH = reverse(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return newH;
    }
}
