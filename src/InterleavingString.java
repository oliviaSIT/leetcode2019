public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return s2.compareTo(s3) == 0;
        }

        if (s2.length() == 0) {
            return s1.compareTo(s3) == 0;
        }

        int l1 = s1.length(), l2 =  s2.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1]; //dp[i][j] means if first i characters of s1 and first j characters of s2 can form first i + j characters of s3
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }

        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }

        return dp[l1][l2];
    }
}
