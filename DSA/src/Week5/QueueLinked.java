package Week5;

public class QueueLinked {
    private Node head;
    private Node tail;
    private int size;

    static class Node {
        int value;
        Node next;

        public Node(int v, Node n) {
            value = v;
            next = n;
        }
    }

    public QueueLinked() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }


    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
            if (isEmpty()) tail = null;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return head.value;
        } else {
            return -1;
        }
    }

}
