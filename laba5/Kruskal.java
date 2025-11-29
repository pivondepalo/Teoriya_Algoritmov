import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 2, 5, 1, 0, 0, 7, 0},
                {2, 0, 0, 3, 5, 0, 0, 0},
                {5, 0, 0, 0, 2, 4, 4, 0},
                {1, 3, 0, 0, 5, 4, 9, 0},
                {0, 5, 2, 5, 0, 3, 0, 0},
                {0, 0, 4, 4, 3, 0, 0, 1},
                {7, 0, 4, 9, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 1, 6, 0}
        };

        int V = graph.length;
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        Collections.sort(edges);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        int totalWeight = 0;

        for (Edge e : edges) {
            if (find(parent, e.u) != find(parent, e.v)) {
                System.out.println((e.u + 1) + " - " + (e.v + 1) + " : " + e.w);
                totalWeight += e.w;
                union(parent, e.u, e.v);
            }
        }

        System.out.println("Загальна вага МКД (Крускал) = " + totalWeight);
    }
}
