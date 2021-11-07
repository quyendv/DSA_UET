// Bài tập thầy Cát: Implement MaxHeap by Array

package Week9;

public class MaxHeapByArray<T extends Comparable<T>> {
    T[] arr;
    int size;

    public MaxHeapByArray(int capacity) {
        arr = (T[]) new Comparable[capacity + 1];
        size = 0;
    }

    public void add(T elem) {
        arr[++size] = elem;
        swim(size);
    }

    public T removeMax() {
        T max = arr[1];
        swap(1, size--);
        sink(1);
        arr[size + 1] = null;
        return max;
    }

    public T getMax() {
        return arr[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void sink(int parent) {
        while (2 * parent <= size) {
            int child = 2 * parent;
            if (child + 1 <= size && less(child, child + 1)) child++;
            if (!less(parent, child)) break;
            swap(parent, child);
            parent = child;
        }
    }

    private void swim(int k) {
        while (k / 2 > 0 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void swap(int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
