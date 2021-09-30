package Week4;

import sun.misc.Signal;

public class MergeTwoSortedLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
//        if (head1 == null) return head2;
//        if (head2 == null) return head1;
//        if (head1.data <= head2.data) {
//            head1.next = mergeLists(head1.next, head2);
//            return head1;
//        } else {
//            head2.next = mergeLists(head1, head2.next);
//            return head2;
//        }

        if (head1 == null) return head2;
        if (head2 == null) return head1;
        SinglyLinkedListNode fakeHead = new SinglyLinkedListNode(0);
        SinglyLinkedListNode p = fakeHead;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                p = p.next = head1;
                head1 = head1.next;
            } else {
                p = p.next = head2;
                head2 = head2.next;
            }
        }
        p.next = head1 == null ? head2 : head1;
        return fakeHead.next;
    }
}
