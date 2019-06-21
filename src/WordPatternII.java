/*
https://leetcode.com/problems/word-pattern-ii/
hard
solution: dfs
 */

import java.util.Map;
import java.util.HashMap;

public class WordPatternII {
    private Map<Character, String> m;
    public boolean wordPatternMatch(String pattern, String str) {
        m = new HashMap<>();
        return help(pattern, 0, str, 0);
    }

    private boolean help(String pattern, int p, String str, int r) {
        if (p == pattern.length() && r == str.length())
            return true;

        if (p == pattern.length() || r == str.length())
            return false;

        char cur = pattern.charAt(p);
        for (int i = r; i < str.length(); i++) {
            String s = str.substring(r, i + 1);

            if (m.containsKey(cur) && m.get(cur).equals(s)) {
                if (help(pattern, p + 1, str, i + 1))
                    return true;
            } else if (!m.containsKey(cur)) {
                if (!m.containsValue(s)) {
                    m.put(cur, s);
                    if (help(pattern, p + 1, str, i + 1))
                        return true;

                    m.remove(cur);
                }
            }
        }

        return false;
    }
}
