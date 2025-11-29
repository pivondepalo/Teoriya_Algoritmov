public class Floyd {

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
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else if (graph[i][j] != 0) dist[i][j] = graph[i][j];
                else dist[i][j] = INF;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("Floyd result (matrix):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
