// https://www.hackerrank.com/challenges/bfsshortreach/problem

package Week12;

import java.util.*;

public class Breadth_First_Search_Shortest_Reach {
    static int[] findShortestReach(ArrayList<ArrayList<Integer>> graph, int start) {
        int[] costs = new int[graph.size()];        // tương tự diskTo[] với diskTo[i] là cạnh thứ i
        int UNIT_COST = 6;
        // for (int i = 0; i < costs.length; ++i) costs[i] = -1;
        Arrays.fill(costs, -1);
        boolean[] visited = new boolean[graph.size()];
        // Arrays.fill(visited, false);

        // Write your code here
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        costs[start] = 0;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int neighborV : graph.get(v)) {
                if (!visited[neighborV]) {
                    visited[neighborV] = true;
                    queue.offer(neighborV);
                    costs[neighborV] = costs[v] + UNIT_COST;
                }
            }
        }
        return costs;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; ++q) {
            int N, M, start;
            N = scanner.nextInt();
            M = scanner.nextInt();
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= N; ++i) {
                graph.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < M; ++i) {
                int n1, n2;
                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            start = scanner.nextInt();
            /*
            for (int i = 0; i < N; ++i) {
                Collections.sort(graph.get(i));
            }
            for (int i = 1; i <= N; ++i) {
                System.out.println("Node: " + i);
                System.out.println(graph.get(i).toString());
            }
            System.out.println("Start: " + start);
            */
            int[] costs = findShortestReach(graph, start);
            for (int i = 1; i < costs.length; ++i) {
                if (i == start) continue;
                System.out.print(costs[i] + " ");
            }
            System.out.println();
        }
    }
}
