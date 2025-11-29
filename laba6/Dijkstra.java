public class Dijkstra {

    static final int INF = 1_000_000;

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
        int n = graph.length;
        int start = 0;

        int[] dist = new int[n];
        int[] pred = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            pred[i] = -1;
        }
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (v == -1 || dist[j] < dist[v])) {
                    v = j;
                }
            }
            if (v == -1) break;
            used[v] = true;

            for (int to = 0; to < n; to++) {
                int w = graph[v][to];
                if (w != 0 && dist[v] + w < dist[to]) {
                    dist[to] = dist[v] + w;
                    pred[to] = v;
                }
            }
        }

        System.out.println("Dijkstra result (distances):");
        for (int i = 0; i < n; i++) {
            System.out.println("1 -> " + (i + 1) + " = " + dist[i]);
        }
    }
}
