package Week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) input.add(sc.next());

        input.sort(String::compareTo); // NlogN

        // System.out.println(input);


        // O(n)
        int frequency = 0;
        for (int i = 0; i < n - 1; i++) {
            if (input.get(i).equals(input.get(i + 1))) frequency++;
            else {
                System.out.println(input.get(i) + " " + ++frequency);
                frequency = 0;
            }
        }
        if (input.get(n - 1).equals(input.get(n - 2))) {
            frequency++;
            System.out.println(input.get(n - 1) + " " + frequency);
        } else System.out.println(input.get(n - 1) + " " + 1);

        // nếu k dùng Map thì độ phức tạp là O(NlogN)
    }
}
