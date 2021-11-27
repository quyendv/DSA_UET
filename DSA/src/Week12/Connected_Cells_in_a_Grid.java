// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem

package Week12;

import java.util.Scanner;

public class Connected_Cells_in_a_Grid {

    static int[][] grid;  // matrix N * M
    static boolean[][] visited;
    static int N, M;      // N: numRows, M: numCols

    // helper:
    static int[] _x = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] _y = {-1, -1, -1, 0, 1, 1, 1, 0};

    static boolean checkPos(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }

    static int count_connected(int row, int col) {      // dfs
        int cnt = 0;
        // Write your code here

        visited[row][col] = true;
        cnt++;
        for (int i = 0; i < 8; i++) {
            int x = row + _x[i];
            int y = col + _y[i];
            if (checkPos(x, y) && grid[x][y] == 1 && !visited[x][y]) {
                cnt += count_connected(x, y);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);
    }
}