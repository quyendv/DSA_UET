package Week4;

public class Delete_DuplicateValue_Nodes {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        for (SinglyLinkedListNode p = head; p != null && p.next != null; ) {
            if (p.data == p.next.data) {
                p.next = p.next.next;
            } else p = p.next;
        }
        return head;
    }
}
