package Week4;

public class CycleDetection {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null || head.next == null) return false;
        SinglyLinkedListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == slow;
    }
}
