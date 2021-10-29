package Week8;

// https://www.hackerrank.com/challenges/java-string-reverse

import java.util.Scanner;

public class Java_String_Reverse {
    public static String checkPalindrome(String A) {
//        int n = A.length();
//        for (int i = 0; i < n / 2; i++) {
//            if (A.charAt(i) != A.charAt(n - i - 1)) return "No";
//        }
//        return "Yes";

        boolean b = new StringBuilder(A).reverse().toString().equals(A);
        return b ?  "Yes" : "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        System.out.println(checkPalindrome(A));
    }
}
