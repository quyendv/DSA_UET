// https://www.hackerrank.com/challenges/missing-numbers/problem

package Week11;

import java.util.*;

public class MissingNumbers {
    // O(n2.log(n2)), n2 = brr.size()
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {
        // Map<Integer, Integer> mapA = new TreeMap<>() {{
        //     for (int i : brr) {
        //         if (!containsKey(i)) put(i, 1);
        //         else put(i, get(i) + 1);
        //     }
        // }};

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : brr) {
            // map.compute(i, (k, v) -> v == null ? 1 : v + 1);
            map.put(i, map.getOrDefault(i, 0) + 1);     // O(n2.log(n2))
        }

        for (int i : arr) {                                        // O(n1)
            if (map.containsKey(i)) {       // chỉ xét phần tử có trong B
                if (map.get(i) > 1) map.put(i, map.get(i) - 1);
                else map.remove(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) ans.add(i.getKey());
        return ans;
    }

    // O(n1 + n2)
    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        int[] frequency = new int[10001];
        for (int i : arr) frequency[i]--;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : brr) {
            frequency[i]++;
            if (i < min) min = i;
            if (i > max) max = i;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (frequency[i] >= 1) ans.add(i);
        }
        return ans;
    }

//    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {
//        int[] frequencyA = new int[10001];
//        int[] frequencyB = new int[10001];
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//        for (int i : arr) frequencyA[i]++;
//        for (int i : brr) {
//            frequencyB[i]++;
//            if (i < min) min = i;
//            if (i > max) max = i;
//        }
//        List<Integer> ans = new ArrayList<>();
//        for (int i = min; i <= max; i++) {
//            if (frequencyB[i] > frequencyA[i]) ans.add(i);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len1; i++) arr.add(sc.nextInt());

        int len2 = sc.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int i = 0; i < len2; i++) brr.add(sc.nextInt());

        List<Integer> result = missingNumbers1(arr, brr);
        for (int i : result) System.out.print(i + " ");
    }
}
