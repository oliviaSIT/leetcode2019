/*
https://leetcode.com/problems/01-matrix/
medium
sol: bfs, 0 in matrix is the start
     dp, min dis from current pos to 0 pos in 4 directions  min (...+1)
 */

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dis = new int[m][n];

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                    qx.offer(i);
                    qy.offer(j);
                } else
                    dis[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!qx.isEmpty()) {
            int size = qx.size();

            for (int i = 0; i < size; i++) {
                int x = qx.poll(), y = qy.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || dis[nx][ny] <= dis[x][y] + 1)
                        continue;

                    dis[nx][ny] = dis[x][y] + 1;
                    qx.offer(nx);
                    qy.offer(ny);
                }

            }
        }

        return dis;
    }

    /*
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    dis[i][j] = 0;
                else {
                    int upCell = (i > 0) ? dis[i - 1][j] : m * n;
                    int leftCell = (j > 0) ? dis[i][j - 1] : m * n;
                    dis[i][j] = Math.min(upCell, leftCell) + 1;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0)
                    dis[i][j] = 0;
                else {
                    int downCell = (i < m - 1) ? dis[i + 1][j] : m * n;
                    int rightCell = (j < n - 1) ? dis[i][j + 1] : m * n;
                    dis[i][j] = Math.min(Math.min(downCell, rightCell) + 1, dis[i][j]);
                }
            }
        }

        return dis;
    }
     */
}
