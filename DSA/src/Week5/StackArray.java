package Week5;

public class StackArray {
    private int[] arr;
    private int size = 0;

    public StackArray(int cap) {
        arr = new int[cap];
    }

    public void resize(int n) {
        arr = new int[n];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(int data) {
        if (size == arr.length - 1) resize(2 * size);
        if (size < arr.length) {
            arr[size++] = data;
        }
    }

    public void pop() {
        size--;
        if (size > 0 && size == arr.length / 4) resize(arr.length / 2);
    }

    public int top() {
        if (!isEmpty()) {
            return arr[size - 1];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

    }
}
