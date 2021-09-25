package Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Closest_Numbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            int val = Math.abs(a[i] - a[i-1]);
            if (val > min) continue;
            if (val < min) {
                al.clear();
                min = val;
            }
            al.add(a[i - 1]); al.add(a[i]);
        }
        for (Integer i : al) System.out.print(i + " " );
    }
}
