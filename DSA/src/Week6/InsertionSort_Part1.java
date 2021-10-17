package Week6;

import java.util.List;

public class InsertionSort_Part1 {
    public static void printArr(List<Integer> arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static void insertionSort1(int n, List<Integer> arr) {
        int last = arr.get(n - 1);
        int j = n - 1;
        while (j > 0 && last < arr.get(j - 1)) {
            arr.set(j, arr.get(j - 1));
            printArr(arr);
            j--;
        }
        arr.set(j, last);
        printArr(arr);
    }
}
