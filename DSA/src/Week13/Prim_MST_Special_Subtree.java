// https://www.hackerrank.com/challenges/primsmstsub/problem

package Week13;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_MST_Special_Subtree {
    static class Cost implements Comparable<Cost> {
        private int w;
        private int weight;

        public Cost(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        public int other() {
            return w;
        }

        public int weight() {
            return weight;
        }

        @Override
        public int compareTo(Cost other) {
            return Integer.compare(weight, other.weight);
        }
    }

    static boolean[] marked;
    static int weightMST;
    static int edgesOfMST; // number of edges
    static PriorityQueue<Cost> pq;

    static void Prim(ArrayList<ArrayList<Cost>> graph, int start) {
        visit(graph, start);
        while (!pq.isEmpty() && edgesOfMST < graph.size() - 2) {
            Cost c = pq.poll();
            int w = c.other();
            if (marked[w]) continue;
            weightMST += c.weight();
            edgesOfMST++;
            visit(graph, w);
        }
    }

    static void visit(ArrayList<ArrayList<Cost>> graph, int v) {
        marked[v] = true;
        for (Cost edge : graph.get(v)) {
            if (!marked[edge.other()]) {
                pq.offer(edge);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();

        // init graph
        ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Cost>()); // init adj(v) empty. adj(0) dismiss, vertex [1, V]
        }
        marked = new boolean[V + 1];
        pq = new PriorityQueue<>();

        // add edge
        for (int i = 0; i < E; i++) {
            int v = sc.nextInt(), w = sc.nextInt(), weight = sc.nextInt();
            graph.get(v).add(new Cost(w, weight));
            graph.get(w).add(new Cost(v, weight));
        }
        // startVertex
        int start = sc.nextInt();

        Prim(graph, start);
        System.out.println(weightMST);
    }
}
