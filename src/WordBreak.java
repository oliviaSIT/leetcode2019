/*
https://leetcode.com/problems/word-break/submissions/
medium
solution: recursor 记忆化
 */

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> member = new HashMap<>();

        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }

        return help(s, dict, member);
    }

    private boolean help(String s, Set<String> dict, Map<String, Boolean> member) {
        if (member.containsKey(s)) {
            return member.get(s);
        }

        if (dict.contains(s)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());

            if (help(s1, dict, member) && help(s2, dict, member)) {
                member.put(s, true);
                return true;
            }
        }

        member.put(s, false);
        return false;
    }
}
