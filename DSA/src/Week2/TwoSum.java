package Week2;

import edu.princeton.cs.algs4.In;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {
        In in = new In("D:\\CTDLGT\\DSA\\lib\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        Set<Integer> s = new HashSet<>();
        for (int i : a) {
            if (s.contains(-i)) {
                System.out.println(i + " + " + -i + " = 0") ;
            } else s.add(i);
        }
    }
}

