package Week5;

import java.util.Arrays;

public class Selection_Sort {
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }
            a[i] += a[minIdx] - (a[minIdx] = a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 4, 4, 5, 6, 6, 7, 8, 8, 8, 9, 10, 11, 13, 13, 14, 14, 15, 16, 17, 17, 18, 19, 19, 20, 23, 24, 26, 31, 31, 32, 33, 33, 34, 35, 36, 37, 39, 39, 40, 41, 42, 45, 47, 48, 48, 49, 49, 50};
        int[] b = {8, 1, 39, 26, 49, 42, 19, 13, 9, 33, 41, 13, 33, 19, 35, 50, 11, 23, 24, 31, 15, 6, 18, 8, 31, 36, 8, 7, 39, 40, 32, 4, 1, 37, 17, 49, 14, 48, 17, 16, 6, 47, 10, 34, 5, 45, 20, 4, 48, 14,};

        long begin = System.currentTimeMillis();
        selectionSort(a);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(a));
        System.out.println(begin + " " + end + " " + (end - begin));
    }
}
