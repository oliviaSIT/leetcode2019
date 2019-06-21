/*
https://leetcode.com/problems/the-maze-ii/
medium
sol: bfs use dists to record the dist from start to maze[i][j]
 */

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dists = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dists[i][j] = Integer.MAX_VALUE;
            }
        }

        dists[start[0]][start[1]] = 0;

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(start[0]);
        qy.offer(start[1]);

        while (!qx.isEmpty()) {
            int x = qx.poll(), y = qy.poll();

            for (int k = 0; k < 4; k++) {
                int nx = x, ny = y, dist = dists[nx][ny];

                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dir[k][0];
                    ny += dir[k][1];
                    dist++;
                }

                nx -= dir[k][0];
                ny -= dir[k][1];
                dist--;

                if (dists[nx][ny] > dist) {
                    dists[nx][ny] = dist;

                    if (nx != destination[0] || ny != destination[1]) {
                        qx.offer(nx);
                        qy.offer(ny);
                    }
                }
            }

        }

        int res = dists[destination[0]][destination[1]];

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}
