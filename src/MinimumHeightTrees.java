/*
https://leetcode.com/problems/minimum-height-trees/
medium
solution : bfs(ex time) indgree(better)
 */

import java.util.*;

//solution1: bfs
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if (edges == null || edges.length != n - 1) {
            return res;
        }

        Map<Integer, List<Integer>> neighbor = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbor.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
        }

        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = bfs(i, neighbor, n);
        }

        int min = Integer.MAX_VALUE;
        for (int ht: h){
            min = Math.min(min, ht);
        }

        for (int i = 0; i < n; i++) {
            if (h[i] == min) {
                res.add(i);
            }
        }

        return res;
    }

    private int bfs(int node, Map<Integer, List<Integer>> neighbor, int n) {
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        v[node] = true;
        q.offer(node);

        while (!q.isEmpty()) {
            int size = q.size();
            res++;

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                List<Integer> nb = neighbor.get(cur);
                for (int j = 0; j < nb.size(); j++) {
                    if (!v[nb.get(j)]) {
                        q.offer(nb.get(j));
                        v[nb.get(j)] = true;
                    }
                }
            }
        }

        return res;
    }
}
/*
solution2: indgree similar as course schedule
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        //记录每个点的入度
        int[] degree = new int[n];
        for (int i = 0;i < n;i++ ) {
            map.add(new ArrayList<Integer>());
        }
        for (int i = 0;i< edges.length;i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0;i < n;i++ ) {
            if(degree[i] == 0) {
                return res;
            } else if(degree[i] == 1) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = q.size();
            for (int i = 0;i < count ;i++ ) {
                int cur = q.poll();
                res.add(cur);
                degree[cur]--;
                for (int k = 0;k < map.get(cur).size() ;k++ ) {
                    int next = map.get(cur).get(k);
                    degree[next]--;
                    if(degree[next] == 0) continue;
                    if(degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }
}
 */