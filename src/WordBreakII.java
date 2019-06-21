/*
https://leetcode.com/problems/word-break-ii/submissions/
hard
solution: separate the string into left and right. Only if right is in the dict, then we deal with the left-->add right to the result of left
 */

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }

        Map<String, List<String>> m = new HashMap<>();

        return help(s, dict, m);
    }

    private List<String> help(String s, Set<String> dict, Map<String, List<String>> m) {
        if (m.containsKey(s)) {
            return m.get(s);
        }

        List<String> res = new ArrayList<>();

        if (dict.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String right = s.substring(i);
            if (!dict.contains(right)) {
                continue;
            }

            String left = s.substring(0, i);
            List<String> left_res = append(help(left, dict, m), right);
            res.addAll(left_res);
        }

        m.put(s, res);
        return res;
    }

    private List<String> append(List<String> list, String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i) + " " + str;
            res.add(s);
        }

        return res;
    }
}
