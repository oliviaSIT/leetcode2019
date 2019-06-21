/*
https://leetcode.com/problems/redundant-connection-ii/
hard
solution:https://zxi.mytechroad.com/blog/graph/leetcode-685-redundant-connection-ii/ union find
 */

public class ReduntantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] roots = new int[edges.length + 1];
        int[] sizes = new int[edges.length + 1];
        for (int i = 0 ; i < sizes.length; i++) {
            sizes[i] = 1;
        }

        int[] res1 = new int[2];
        int[] res2 = new int[2];

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            //A node has 2 parents
            if (parents[v] > 0) {
                res1[0] = parents[v];
                res1[1] = v;
                res2[0] = edge[0];
                res2[1] = edge[1];

                edge[0] = -1;
                edge[1] = -1;
            }

            parents[v] = u;
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            //Invalid edge (we deleted in step1
            if (u < 0 || v < 0) {
                continue;
            }

            if (roots[u] == 0) {
                roots[u] = u;
            }

            if (roots[v] == 0) {
                roots[v] = v;
            }

            int pu = find(u, roots);
            int pv = find(v, roots);
            //both u and v are already in the tree
            if (pu == pv) {
                return res1[1] == 0 ? edge : res1;//case 1: the same as I case 2: one has 2 parents and circle
            }

            //Unoin, always merge smaller set (pv) to larger set (pu)
            if (sizes[pu] < sizes[pv]) {
                int t = pu;
                pu = pv;
                pv = t;
            }

            roots[pv] = pu;
            sizes[pu] += sizes[pv];
        }

        return res2;
    }

    private int find(int node, int[] roots) {
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }

        return node;
    }
}

