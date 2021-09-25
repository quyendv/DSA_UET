package Week3;

import java.util.Scanner;

public class New_Year_Chaos {
    // Cách 1
    public static void solve(int[] a) {
        int ans = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, a[i] - 2); j < i; j++) {
                if (a[j] > a[i]) ans++;
            }
        }
        System.out.println(ans);
    }
    // Cách 2
    public static void solve1(int[] a) {
        int ans = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == i + 1) continue;
            if (i - 1 >= 0 && a[i - 1] == i + 1) {
                a[i - 1] += a[i] - (a[i] = a[i - 1]);
                ans++;
            } else if (i - 2 >= 0 && a[i - 2] == i + 1) {
                a[i - 2] += a[i - 1] - (a[i - 1] = a[i - 2]);
                a[i - 1] += a[i] - (a[i] = a[i - 1]);
                ans += 2;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(ans);
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
            // solve(a);
            solve1(a);
        }
        sc.close();
    }
}