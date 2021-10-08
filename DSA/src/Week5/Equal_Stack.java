package Week5;

import java.util.*;

public class Equal_Stack {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> sum1 = new Stack<>();
        Stack<Integer> sum2 = new Stack<>();
        Stack<Integer> sum3 = new Stack<>();
        for (int i = h1.size() - 1; i >= 0; i--)
            if (sum1.empty()) sum1.push(h1.get(i));
            else sum1.push(sum1.peek() + h1.get(i));

        for (int i = h2.size() - 1; i >= 0; i--)
            if (sum2.empty()) sum2.push(h2.get(i));
            else sum2.push(sum2.peek() + h2.get(i));

        for (int i = h3.size() - 1; i >= 0; i--)
            if (sum3.empty()) sum3.push(h3.get(i));
            else sum3.push(sum3.peek() + h3.get(i));

        while (!sum1.empty() && !sum2.empty() && !sum3.empty()) {
            int a = sum1.peek(), b = sum2.peek(), c = sum3.peek();
            if (a == b && b == c) return a;
            if (a > b || a > c) sum1.pop();
            if (b > a || b > c) sum2.pop();
            if (c > a || c > b) sum3.pop();
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), p = sc.nextInt();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        for (int i = 0; i < m; i++) l1.add(sc.nextInt());
        for (int i = 0; i < n; i++) l2.add(sc.nextInt());
        for (int i = 0; i < p; i++) l3.add(sc.nextInt());
        sc.close();

        System.out.println(equalStacks(l1, l2, l3));
    }
}
