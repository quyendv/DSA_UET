package Week5;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Simple_Text_Editor {

    public static void main(String[] args) {
        MyTextEditor mte = new MyTextEditor();
        StringBuilder output = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            switch (sc.nextInt()) {
                case 1 -> mte.insert(sc.next());
                case 2 -> mte.delete(sc.nextInt());
                case 3 -> {
                    output.append(mte.getAtIndex(sc.nextInt()));
                    output.append('\n');
                }
                case 4 -> mte.undo();
            }
        }
        System.out.println(output);
    }

    static class MyTextEditor {
        StringBuilder S = new StringBuilder();
        Stack<Object> historyStk = new Stack<Object>();

        public void insert(String str) {
            historyStk.push(str.length());
            S.append(str);
        }

        public void delete(int k) {
            historyStk.push(S.substring(S.length() - k));
            S.delete(S.length() - k, S.length());
        }

        public char getAtIndex(int idx) {
            return S.charAt(idx - 1);
        }

        public void undo() {
            Object tmp = historyStk.pop();
            if (tmp instanceof Integer) {
                S.delete(S.length() - (Integer) tmp, S.length());
            } else {
                S.append((String)tmp);
            }
        }
    }

    static class MyTextEditor1 {
        Stack<Character> S = new Stack<>();
        Stack<Object> historyStk = new Stack<>();

        public void insert(String str) {
            historyStk.push(str.length());
            for (char c : str.toCharArray()) S.push(c);
        }

        public void delete(int k) {
            Stack<Character> reverseDeletedStr = new Stack<>();
            for (int i = 0; i < k; i++)
                reverseDeletedStr.push(S.pop());
            historyStk.push(reverseDeletedStr);
        }

        public char getAtIndex(int idx) {
            return S.get(idx - 1);
        }

        public void undo() {
            Object tmp = historyStk.pop();
            if (tmp instanceof Integer) {
                for (int i = 0; i < (Integer) tmp; i++)
                    S.pop();
            } else {
                Stack<Character> reverseDeletedStr = (Stack<Character>) tmp;
                while (!reverseDeletedStr.empty())
                    S.push(reverseDeletedStr.pop());
            }
        }
    }
}
