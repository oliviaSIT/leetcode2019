/*
https://leetcode.com/problems/redundant-connection/
medium:
solution: dfs or union find(better)
 */

import java.util.*;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();// neighbor map

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            Set<Integer> isVisited = new HashSet<>();
            if (hasPath(u, v, isVisited, map)) {
                return edge;
            }

            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }

            map.get(u).add(v);

            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }

            map.get(v).add(u);

        }


        return new int[0];
    }

    private boolean hasPath(int u, int v, Set<Integer> isVisited, Map<Integer, List<Integer>> map) {
        if (u == v) {
            return true;
        }

        isVisited.add(u);

        if (!map.containsKey(u) || !map.containsKey(v)) {
            return false;
        }

        for (int next: map.get(u)) {
            if (!isVisited.contains(next)) {
                if (hasPath(next, v, isVisited, map)) {
                    return true;
                }
            }
        }

        return false;
    }
}

/*
solution2 union find
class Solution {
    class UnionFindSet {
        private int[] parents_;
        private int[] ranks_;//深度

        public UnionFindSet(int n) {
            parents_ = new int[n + 1];
            ranks_ = new int[n + 1];
            for (int i = 0; i < parents_.length; ++i) {
                parents_[i] = i;
                ranks_[i] = 1;
            }
        }

        public boolean Union(int u, int v) {
            int pu = Find(u);
            int pv = Find(v);
            if (pu == pv) return false;

            if (ranks_[pv] > ranks_[pu])
                parents_[pu] = pv;
            else if (ranks_[pu] > ranks_[pv])
                parents_[pv] = pu;
            else {
                parents_[pv] = pu;
                ranks_[pu] += 1;
            }

            return true;
        }

        public int Find(int u) {
            while (parents_[u] != u) {
                parents_[u] = parents_[parents_[u]];
                u = parents_[u];
            }
            return u;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet s = new UnionFindSet(edges.length);
        for (int[] edge : edges)
            if (!s.Union(edge[0], edge[1]))
                return edge;
        return null;
    }


}
 */