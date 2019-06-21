/*
https://leetcode.com/problems/knight-probability-in-chessboard/
medium
solution:dp[][][] first calculate all ways of (i,j) when the kth step, then divide into pow(8,K)
 */

public class KnightProbablityInChaseboard {
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[2][N][N];
        dp[0][r][c] = 1.0;
        int[][] direct = {{1, 2}, {-1, -2}, {1, -2}, {-1, 2},
                {2, 1}, {-2, -1}, {2, -1}, {-2, 1}};

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[k % 2][i][j] = 0.0;// be careful not to ignore
                    for (int t = 0; t < 8; t++) {
                        int x = i + direct[t][0], y = j + direct[t][1];
                        if (x < 0 || x >= N || y < 0 || y >= N)
                            continue;

                        dp[k % 2][i][j] += dp[(k - 1) % 2][x][y];
                    }
                }
            }
        }

        double res = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K % 2][i][j];
            }
        }

        return (double)res / Math.pow(8, K-1);
    }
/*
    public static void main(String[] args) {
        KnightProbablityInChaseboard sol = new KnightProbablityInChaseboard();
        sol.knightProbability(3,2,0,0);
    }
*/
}
