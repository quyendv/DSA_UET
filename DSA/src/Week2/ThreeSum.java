package Week2;

import edu.princeton.cs.algs4.In;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In("D:\\CTDLGT\\DSA\\lib\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        for (int i = 0; i < a.length - 2; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < a.length - 1; j++) {
                if (s.contains(-a[i] - a[j])) {
                    System.out.println(a[i] + " + " + a[j] + " + " + (-a[i] - a[j]) + " = 0");
                } else s.add(a[j]);
            }
        }
    }
}
