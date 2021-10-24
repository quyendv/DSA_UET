package Week7;

import java.util.List;

public class Intro_to_Tutorial_Challenges {
    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here
        // int lo = 0, hi = arr.size() - 1;
        // while (lo <= hi) {
        //     int mid = lo + (hi - lo) / 2;
        //     if (arr.get(mid) == V) return mid;
        //     if (arr.get(mid) > V) hi = mid - 1;
        //     else lo = mid + 1;
        // }
        // return -1;
        return binarySearch(V, arr, 0, arr.size() - 1);
    }

    public static int binarySearch(int V, List<Integer> arr, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr.get(mid) == V) return mid;
        if (arr.get(mid) > V) return binarySearch(V, arr, lo, mid - 1);
        return binarySearch(V, arr, mid + 1, hi);
    }
}
