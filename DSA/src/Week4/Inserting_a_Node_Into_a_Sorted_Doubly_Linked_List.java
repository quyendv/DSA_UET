package Week4;

public class Inserting_a_Node_Into_a_Sorted_Doubly_Linked_List {
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

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
//        DoublyLinkedListNode newN = new DoublyLinkedListNode(data);
//        if (head == null) return newN;
//        if (data <= head.data) {
//            newN.next = head;
//            return newN;
//        }
//        DoublyLinkedListNode p = head;
//        while (p.next != null && data > p.next.data) p = p.next;
//        newN.next = p.next;
//        newN.prev = p;
//        p.next = newN;
//        return head;

        // recursion
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }
        if (data <= head.data) {
            DoublyLinkedListNode newN = new DoublyLinkedListNode(data);
            newN.next = head;
            return newN;
        }
        head.next = sortedInsert(head.next, data);
        head.next.prev = head;
        return head;
    }
}
