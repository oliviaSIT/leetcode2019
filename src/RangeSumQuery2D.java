/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
medium
solution dp similar as 221
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-304-range-sum-query-2d-immutable/
 */

public class RangeSumQuery2D {
    class NumMatrix {
        int[][] matrix;
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return;

            this.sums = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int m = this.matrix.length, n = this.matrix[0].length;
            if (m * n == 0)
                return 0;

            int res = sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1] - sums[row1][col2 + 1] + sums[row1][col1];

            return res;
        }
    }
}
