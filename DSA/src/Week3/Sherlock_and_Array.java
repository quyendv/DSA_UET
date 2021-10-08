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

    public static String check1(int[] a) {
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < a.length; i++) {
            leftSum += i > 0 ? a[i - 1] : 0;
            rightSum = 0;
            for (int j = a.length - 1; j > i; j--) {
                rightSum += a[j];
            }
            if (leftSum == rightSum) return "YES";
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
            System.out.println(check1(a));
        }
    }
}
