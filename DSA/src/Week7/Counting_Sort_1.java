package Week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Counting_Sort_1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here

        // List<Integer> frequency = new ArrayList<>();
        // for (int i = 0; i < 100; i++) frequency.add(0);
        List<Integer> frequency = new ArrayList<>(Arrays.asList(new Integer[100]));
        for (int i = 0; i < 100; i++) frequency.set(i, 0);
        for (int i : arr) {
            int curFre = frequency.get(i);
            frequency.set(i, curFre + 1);
        }
        return frequency;
    }
}
