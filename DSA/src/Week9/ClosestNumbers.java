package Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {
    public static void mergeSort(List<Integer> arr) {
        List<Integer> aux = new ArrayList<>(arr);
        sort(aux, arr, 0, arr.size() - 1);
    }

    private static void sort(List<Integer> arr, List<Integer> aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(aux, arr, lo, mid);
        sort(aux, arr, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    private static void merge(List<Integer> arr, List<Integer> aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                        aux.set(k, arr.get(j++));
            else if (j > hi)                    aux.set(k, arr.get(i++));
            else if (arr.get(i) < arr.get(j))   aux.set(k, arr.get(i++));
            else                                aux.set(k, arr.get(j++));
        }
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        mergeSort(arr);
        int min = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = Math.abs(arr.get(i) - arr.get(i + 1));
            if (diff > min) continue;
            if (diff < min) {
                ans.clear();
                min = diff;
            }
            ans.add(arr.get(i));
            ans.add(arr.get(i + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(6, 3, 5, 1, 4, 2);
        mergeSort(test);
        System.out.println(test);
    }
}
