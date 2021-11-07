// https://www.hackerrank.com/challenges/phone-book/problem

package Week9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> people = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int phoneNumber = sc.nextInt();
            sc.nextLine();
            people.put(name, phoneNumber);
        }
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            if (people.containsKey(name)) System.out.println(name + "=" + people.get(name));
            else System.out.println("Not found");
        }
    }
}
