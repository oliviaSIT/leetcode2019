/*
https://leetcode.com/problems/palindrome-partitioning-ii/
hard
solution: dp https://zhengyang2015.gitbooks.io/lintcode/palindrome_partitioning_ii_108.html
 */

public class PlindromePartitioningII {
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        boolean[][] p = isP(s);

        int[] cut = new int[s.length() + 1]; //即前i个字符最少要切几次才能将字符串切为回文串
        for(int i = 0; i <= s.length(); i++){
            cut[i] = i - 1;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (p[j][i - 1]) {
                    cut[i] = Math.min(cut[i], cut[j] + 1);
                }
            }
        }

        return cut[s.length()];
    }

    private boolean[][] isP(String s) {
        int l = s.length();
        boolean[][] res = new boolean[l][l];

        for (int i = 0; i < l; i++) {
            res[i][i] = true;
        }

        for (int i = 0; i < l - 1; i++) {
            res[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int j = 2; j < l; j++) {
            for (int i = 0; i < j - 1; i++) {
                if (s.charAt(i) == s.charAt(j) && res[i + 1][j - 1]) {
                    res[i][j] = true;
                } else {
                    res[i][j] = false;
                }
            }
        }

        return res;
    }
}
