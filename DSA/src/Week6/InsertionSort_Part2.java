package Week6;

import java.util.List;

public class InsertionSort_Part2 {
    public static void printArr(List<Integer> a) {
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int ai = arr.get(i), j = i;
            while (j > 0 && ai < arr.get(j - 1)) {
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, ai);
            printArr(arr);
        }
    }
}
