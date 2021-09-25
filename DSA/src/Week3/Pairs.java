package Week3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), count = 0;
        int[] a = new int[n];

//        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        Arrays.sort(a);
//
//        int i = 0, j = 1; // same 2 for
//        while (j < n) {
//            int diff = a[j] - a[i];
//            if (diff > k) i++;
//            else if (diff < k) j++;
//            else {
//                count++;
//                j++;
//            }
//        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            s.add(a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (s.contains(a[i] + k)) count++;
        }
        System.out.println(count);
    }
}
