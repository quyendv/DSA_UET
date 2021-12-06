// https://www.hackerrank.com/challenges/dijkstrashortreach/problem

package Week13;

import java.io.IOException;
import java.util.*;

public class Dijkstra_Shortest_Reach_2 {

    static class Cost implements Comparable<Cost> {
        int w;      // vertex
        int weight; // distance

        public Cost(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        public int vertex() {
            return w;
        }

        public int weight() {
            return weight;
        }

        @Override
        public int compareTo(Cost that) {
            if (weight == that.weight()) {
                return Integer.compare(w, that.w);
            }
            return weight - that.weight;
        }
    }

    static int[] findShortestPath(ArrayList<ArrayList<Cost>> graph, int startVertex) {
        // init
        int[] distance = new int[graph.size()];  // V + 1, [1, V]
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Cost> pq = new PriorityQueue<>();

        // solve
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;
        pq.offer(new Cost(startVertex, 0));
        while (!pq.isEmpty() && set.size() < graph.size() - 1) {
            Cost minDistance = pq.poll();
            int v = minDistance.vertex();
            if (set.contains(minDistance.vertex())) continue;

            // set distance of neighbors
            for (Cost neighbor : graph.get(minDistance.vertex())) {
                if (!set.contains(neighbor.vertex())) {
                    if (distance[v] + neighbor.weight() < distance[neighbor.vertex()]) {
                        distance[neighbor.vertex()] = distance[v] + neighbor.weight();
                        pq.offer(new Cost(neighbor.vertex(), distance[neighbor.vertex()]));
                    }
                }
            }

            // c.vertex() done
            set.add(minDistance.vertex());
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int V = sc.nextInt(), E = sc.nextInt();

            // initialize graph. dismiss graph.get(0)
            ArrayList<ArrayList<Cost>> graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) graph.add(new ArrayList<Cost>());

            // Add edge.
            for (int i = 0; i < E; i++) {
                int v = sc.nextInt(), w = sc.nextInt(), weight = sc.nextInt();
                graph.get(v).add(new Cost(w, weight));
                graph.get(w).add(new Cost(v, weight));
            }
            int startVertex = sc.nextInt();

            // solve
            int[] distance = findShortestPath(graph, startVertex);
            for (int i = 1; i <= V; i++) {
                if (i != startVertex) {
                    System.out.print((distance[i] == Integer.MAX_VALUE ? -1 : distance[i]) + " ");
                }
            }
            System.out.println();
        }

    }
}