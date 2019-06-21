/*
https://leetcode.com/problems/minimum-cost-for-tickets/
medium
sol:dp
 */

import java.util.HashSet;
import java.util.Set;

public class MinimunCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[31]; // dp[i] means the total cost of day i in this year
        Set<Integer> d = new HashSet<>();

        for (int day: days)
            d.add(day);

        for (int i = 1; i < 366; i++) {
            if (!d.contains(i))
                dp[i % 31] = dp[(i - 1) % 31];
            else if (i >= 30)
                dp[i % 31] = Math.min(dp[(i - 1) % 31] + costs[0], Math.min(dp[(i - 7) % 31] + costs[1], dp[(i - 30) % 31] + costs[2]));
            else if (i >= 7)
                dp[i % 31] = Math.min(dp[(i - 1) % 31] + costs[0], Math.min(dp[(i - 7) % 31] + costs[1], costs[2]));
            else
                dp[i % 31] = Math.min(dp[(i - 1) % 31] + costs[0], Math.min(costs[1], costs[2]));
        }

        return dp[365 % 31];
    }
}
