package Week8;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Key val) {
        pq[n++] = val;
    }

    public Key delMax() {
        int maxIndex = 0;
        for (int i = 1; i < n; i++)
            if (less(maxIndex, i)) maxIndex = i;
        exch(maxIndex, n - 1);
        return pq[--n];
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
