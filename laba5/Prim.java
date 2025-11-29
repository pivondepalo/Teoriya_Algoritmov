import java.util.Arrays;

public class Prim {
    static final int INF = 1000000;

    static int[][] graph = {
            {0, 2, 5, 1, 0, 0, 7, 0},
            {2, 0, 0, 3, 5, 0, 0, 0},
            {5, 0, 0, 0, 2, 4, 4, 0},
            {1, 3, 0, 0, 5, 4, 9, 0},
            {0, 5, 2, 5, 0, 3, 0, 0},
            {0, 0, 4, 4, 3, 0, 0, 1},
            {7, 0, 4, 9, 0, 0, 0, 6},
            {0, 0, 0, 0, 0, 1, 6, 0}
    };

    public static void main(String[] args) {
        int V = graph.length;

        boolean[] selected = new boolean[V];
        int[] minEdge = new int[V];
        int[] parent = new int[V];

        Arrays.fill(minEdge, INF);
        Arrays.fill(parent, -1);
        minEdge[0] = 0;

        int totalWeight = 0;

        for (int i = 0; i < V; i++) {
            int v = -1;

            for (int j = 0; j < V; j++) {
                if (!selected[j] && (v == -1 || minEdge[j] < minEdge[v])) {
                    v = j;
                }
            }

            selected[v] = true;

            if (parent[v] != -1) {
                System.out.println((parent[v] + 1) + " - " + (v + 1) + " : " + minEdge[v]);
                totalWeight += minEdge[v];
            }

            for (int to = 0; to < V; to++) {
                int weight = graph[v][to];
                if (weight != 0 && !selected[to] && weight < minEdge[to]) {
                    minEdge[to] = weight;
                    parent[to] = v;
                }
            }
        }

        System.out.println("Загальна вага МКД (Прім) = " + totalWeight);
    }
}
