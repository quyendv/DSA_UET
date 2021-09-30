package Week4;

public class Find_Merge_Point_of_Two_Lists {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p1 = head1, p2 = head2;
        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1.data;
    }
}
