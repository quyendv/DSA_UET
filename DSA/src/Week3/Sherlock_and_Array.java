package Week3;

import java.util.Scanner;

public class Sherlock_and_Array {

    public static String check(int[] a) {
        int total = 0, left = 0;
        for (int i : a) total += i;
        for (int i : a) {
            if (left * 2 + i == total) return "YES";
            left += i;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(check(a));
        }
    }
}
