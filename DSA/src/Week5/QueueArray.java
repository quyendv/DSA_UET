package Week5;

public class QueueArray {
    public int[] arr;
    public int size = 0;

    public QueueArray(int n) {
        arr = new int[n];
    }

    public void resize(int n) {
        arr = new int[n];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        if (size == arr.length) resize(2 * size);
        arr[size++] = data;
    }

    public void dequeue() {
        if (!isEmpty()) {
            size--;
            if (size >= 0) {
                for (int i = 0; i < size; i++) {
                    arr[i] = arr[i + 1];
                }
            }
        }
    }

    public int top() {
        if (size == 0) return -1;
        return arr[0];
    }

    public static void main(String[] args) {

    }
}
