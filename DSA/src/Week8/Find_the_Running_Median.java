package Week8;

import java.util.*;

public class Find_the_Running_Median {

    // O(NlogN
    public static List<Double> runningMedian(List<Integer> a) {
        // maxHeap - minHeap
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());  // maxHeapSize >= minHeapSize
        Queue<Integer> minHeap = new PriorityQueue<>();

        List<Double> ans = new ArrayList<>();
        for (int val : a) {  // N *
            // add to heap: logN
            if (maxHeap.size() <= minHeap.size()) maxHeap.offer(val);
            else minHeap.offer(val);

            // validate: logN
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }

            // add to ans: O(1)
            if (maxHeap.size() > minHeap.size()) ans.add(maxHeap.peek() * 1.0);
            else if (!maxHeap.isEmpty()) ans.add((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) a.add(sc.nextInt());
        System.out.println(runningMedian(a));
    }
}
