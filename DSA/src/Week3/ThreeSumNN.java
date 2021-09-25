package Week3;

import edu.princeton.cs.algs4.In;

import java.util.Scanner;

public class ThreeSumNN {
    public static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(a, lo, hi);
            quickSort(a, lo, pi - 1);
            quickSort(a, pi + 1, hi);
        }
    }

    public static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                i++;
                a[i] += a[j] - (a[j] = a[i]); // swap a[i], a[j]
            }
        }
        a[i + 1] += a[hi] - (a[hi] = a[i + 1]); // swap: i + 1, hi
        return i + 1; // cur high
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int n = a.length;

        quickSort(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            int left = i + 1, right = n - 1, sum = -a[i];
            while (left < right) {
                if (a[left] + a[right] == sum) {
                    System.out.println(a[i] + " + " + a[left] + " + " + a[right] + " = 0");
                    left++; right--;
                } else if (a[left] + a[right] < sum) left++;
                else right--;
            }
        }
    }
}
