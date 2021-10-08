package Week5;

import java.util.Arrays;
import java.util.Stack;

public class Balanced_Brackets {
    public static String isBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(')');
            } else if (c == '{') {
                stk.push('}');
            } else if (c == '[') {
                stk.push(']');
            } else if (stk.empty() || c != stk.pop()) {
                return "NO";
            }
        }
        return stk.empty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("()[[{()}]]()"));
    }
}
