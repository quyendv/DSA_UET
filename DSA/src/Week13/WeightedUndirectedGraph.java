// BT thầy Cát: adjacency list
// Cài đặt đồ thị vô hướng có trọng số bằng danh sách kề

package Week13;

import java.util.ArrayList;

public class WeightedUndirectedGraph {
    static class EdgeTo {
        int w;
        int weight;

        public EdgeTo(int w, int weight) {
            this.w = w;
            this.weight = weight;
        }

        public String toString() {
            return String.format("w: %d - weight: %d", w, weight);
        }
    }

    ArrayList<ArrayList<EdgeTo>> graph;

    public WeightedUndirectedGraph(int V) {
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
    }

    public void addEdge(int v1, int v2, int weight) {
        if (v1 < 0 || v1 >= graph.size() || v2 < 0 || v2 >= graph.size()) return;
        graph.get(v1).add(new EdgeTo(v2, weight));  // O(1)
        graph.get(v2).add(new EdgeTo(v1, weight));  // O(1)
    }

    public void removeEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= graph.size() || v2 < 0 || v2 >= graph.size()) return;
        graph.get(v1).removeIf(e -> e.w == v2); // O(degree(v1))
        graph.get(v2).removeIf(e -> e.w == v1); // O(degree(v2))
    }

    public void addVertx(int v) {
        if (v < graph.size()) return;
        graph.add(v, new ArrayList<>()); // arr[] thì phải khởi tạo mảng [V+1] và sao chép lại toàn bộ -> O(V^2)
    }

    public void removeVertex(int v) {
        if (v < 0 || v >= graph.size()) return;
        for (EdgeTo e : graph.get(v)) {
            graph.get(e.w).removeIf(edge -> edge.w == v);
        }
        graph.remove(v);
        // O(V^2)
    }

    public boolean hasEdgeBetween(int v1, int v2) {
        if (v1 < 0 || v1 > graph.size() || v2 < 0 || v2 > graph.size()) return false;
        for (EdgeTo e : graph.get(v1))  // O(degree(v1))  ==> best: O(1), worst: O(V)
            if (e.w == v2) return true;
        return false;
    }

    public EdgeTo[] getAdj(int v) { // O(degree(v))
        if (v < 0 || v > graph.size()) return null;
        EdgeTo[] adj = new EdgeTo[graph.get(v).size()];
        for (int i = 0; i < graph.get(v).size(); i++) {
            adj[i] = graph.get(v).get(i);
        }
        return adj;
    }

    public void printGraph() {
        for (int v = 0; v < graph.size(); v++) {
            System.out.print("vertex " + v + " : ");
            System.out.println(graph.get(v));
        }
    }

    public static void main(String[] args) {
        WeightedUndirectedGraph wug = new WeightedUndirectedGraph(5);
        wug.addEdge(1, 2, 5);
        wug.addEdge(1, 0, 2);
        wug.addEdge(2, 4, 10);
        wug.printGraph();
    }
}
