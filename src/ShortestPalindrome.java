/*
https://leetcode.com/problems/shortest-palindrome/
hard
solution: KMP
找到s从头开始的最长回文串，在s前逐个加需要的字符 http://www.cnblogs.com/grandyang/p/4523624.html
找回文串的方法用到了KMP https://blog.csdn.net/v_july_v/article/details/7041827
KMP:String s, String p(pattern)
next[j]: before p[j], the length of same pre and post
when p[j] != s[i] let j = next[j]
when p[j] == s[i] i++, j++
if j == p.length(), p is in s
*/

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String r = new StringBuffer(s).reverse().toString();
        String t = s + "#" + r;
        int[] next = new int[t.length()];//t[0]--t[i]前后缀相同的长度

        for (int i = 1; i < t.length(); i++) {
            int j = next[i - 1];

            while (j > 0 && t.charAt(i) != t.charAt(j))
                j = next[j - 1];

            j += (t.charAt(i) == t.charAt(j)) ? 1 : 0;
            next[i] = j;
        }

        return r.substring(0, s.length() - next[t.length() - 1]) + s;
    }
}
