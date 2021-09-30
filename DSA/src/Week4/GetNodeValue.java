package Week4;

public class GetNodeValue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static int getNode(SinglyLinkedListNode head, int posFromTail) {
        SinglyLinkedListNode cur = head, ans = head;
        while (cur.next != null) {
            if (posFromTail-- <= 0) {
                ans = ans.next;
            }
            cur = cur.next;
        }
        return ans.data;
    }
}
