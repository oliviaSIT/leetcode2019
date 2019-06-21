/*
https://leetcode.com/problems/number-of-islands-ii/
hard
solution: union find initial roots = -1, id -> id
 */

import java.util.List;
import java.util.ArrayList;

public class NumberOfIslandII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int cnt = 0;

        int[] roots = new int[m * n];
        for (int i = 0; i < m * n; i++) {
                roots[i] = -1;
        }

        int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        for (int[] pos: positions) {
            int id = pos[0] * n + pos[1];
            if (roots[id] == -1) {
                roots[id] = id;
                cnt++;
            }

            for (int k = 0; k < 4; k++) {
                int x = pos[0] + dir[k][0], y = pos[1] + dir[k][1];
                int nid = x * n + y;

                if (x < 0 || x >= m || y < 0 || y >= n || roots[nid] == -1)
                    continue;

                int p = find(roots, nid), q = find(roots, id);

                if (p != q) {
                    roots[p] = q;
                    cnt--;
                }
            }

            res.add(cnt);
        }

        return res;
    }

    private int find(int[] roots, int id) {
        return (id == roots[id]) ? id : find(roots, roots[id]);
    }
}
