/*
https://www.lintcode.com/problem/trapping-rain-water-ii/description?_from=ladder&&fromId=46
hard
sol: use minheap to record edge
 */

import java.util.*;

public class TrappingRainWaterII {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        int res = 0;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new CellComparator());
        int m = heights.length, n = heights[0].length;
        boolean[][] v = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heights[i][0]));
            minHeap.offer(new Cell(i, n - 1, heights[i][n - 1]));
            v[i][0] = true;
            v[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heights[0][j]));
            minHeap.offer(new Cell(m - 1, j, heights[m - 1][j]));
            v[0][j] = true;
            v[m - 1][j] = true;
        }

        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cell.x + dx[k], ny = cell.y + dy[k];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || v[nx][ny])
                    continue;

                v[nx][ny] = true;
                minHeap.offer(new Cell(nx, ny, Math.max(cell.h, heights[nx][ny])));
                res += Math.max(0, cell.h - heights[nx][ny]);
            }
        }

        return res;
    }
}

class Cell {
    int x, y, h;

    Cell(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class CellComparator implements Comparator<Cell> {
    @Override
    public int compare (Cell a, Cell b) {
        return a.h - b.h;
    }
}
