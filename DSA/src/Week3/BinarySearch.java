package Week3;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySerach(int[] a, int key) {
        int l = 0, r = a.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) return mid;
            if (key < a[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 100;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 201) - 100; // [-100, 100]
        }
        Arrays.sort(a);
        System.out.println(binarySerach(a, 45));
    }
}
