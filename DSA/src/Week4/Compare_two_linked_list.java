package Week4;

public class Compare_two_linked_list {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null) return false;
        if (head1.data == head2.data) return compareLists(head1.next, head2.next);
        return false;

//        SinglyLinkedListNode p1 = head1, p2 = head2;
//        while (p1 != null && p2 != null && p1.data == p2.data) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        return p1 == p2;
    }
}
