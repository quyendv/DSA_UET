package Week5;

import org.w3c.dom.events.EventException;

public class StackLinked {
    private Node first;
    private int size = 0;

    private static class Node {
        int value;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int value) {
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
        size++;
    }

    public void pop() {
        if (!isEmpty()) {
            first = first.next;
            size--;
        }
    }

    public int top() {
        if (size == 0) return -1;
        else return first.value;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {

    }
}
