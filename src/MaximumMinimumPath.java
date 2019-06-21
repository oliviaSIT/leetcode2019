public class MaximumMinimumPath {
    public int maxMinPath(int[][] a) {
        int[][] dp = new int[a.length][a[0].length];
        dp[0][0] = a[0][0];
        for (int i = 1; i < a.length; i++) {
            dp[0][i] = Math.min(dp[0][i - 1], a[0][i]);
        }

        for (int i = 1; i < a[0].length; i++) {

        }

        return 0;
    }
}
