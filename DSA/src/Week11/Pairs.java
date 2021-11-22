// https://www.hackerrank.com/challenges/pairs/problem

package Week11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        Set<Integer> set = new HashSet<>(arr);
        for (int i : arr) {
            if (set.contains(i + k)) count++;
        }
        return count;
    }
}
