package Week5;

import java.util.Scanner;
import java.util.Stack;

public class Simple_Text_Editor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        StringBuilder s = new StringBuilder();
        Stack<String> stk = new Stack<>();

        while (q-- > 0) {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    String tmp = sc.next();
                    stk.push(s.toString());
                    s.append(tmp);
                    break;
                case 2:
                    stk.push(s.toString());
                    s.delete(s.length() - sc.nextInt(), s.length());
                    break;
                case 3:
                    System.out.println(s.charAt(sc.nextInt() - 1));
                    break;
                case 4:
                    if (!stk.empty()) s = new StringBuilder(stk.pop());
                    break;
                default:
                    break;
            }
//            System.out.println(q + ": " + s.toString());
        }
    }
}
