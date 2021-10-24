package Week7;

import java.util.List;

public class Quicksort1_Partition {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int pivot = arr.get(0);
        int i = 0, j = arr.size();
        while (true) {
            while (arr.get(++i) < pivot)
                if (i == arr.size() - 1) break;
            while (arr.get(--j) > pivot)
                if (j == 0) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, 0, j);
        return arr;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
