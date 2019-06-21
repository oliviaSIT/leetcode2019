/*
https://leetcode.com/problems/reconstruct-itinerary/submissions/
medium
solution: dfs-->hierholzer 欧拉路径
https://www.youtube.com/watch?v=LKSdX31pXjY
 */

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();

        if (tickets == null || tickets.length == 0) {
            return res;
        }

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<>());
            }

            map.get(tickets[i][0]).offer(tickets[i][1]);
        }

        dfs("JFK", map, res);

        return res;
    }

    private void dfs(String st, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> q = map.get(st);

        while (q != null && !q.isEmpty()) {
            String cur = q.poll();

            dfs(cur, map, res);
        }

        res.addFirst(st);
    }
}
