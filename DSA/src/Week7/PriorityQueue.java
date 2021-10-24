package Week7;

public class PriorityQueue {
    int[] a;
    int size;

    PriorityQueue(int maxSize) {
        a = new int[maxSize];
        size = 0;
    }

    public void insert(int val) {
        if (size >= a.length) return;
        a[size++] = val;
    }

    public int deleteMin() {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (a[i] < a[minIndex]) minIndex = i;
        }
        swap(minIndex, size - 1);
        return a[--size];
    }

    public void swap(int i, int j) {
        int temp = a[i];
        a[j] = a[i];
        a[i] = temp;
    }
}
