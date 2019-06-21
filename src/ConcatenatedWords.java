/*
https://leetcode.com/problems/concatenated-words/description/
hard
solution: similar as word break
 */

import java.util.*;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> s = new HashSet<>();

        for (String word: words) {
            s.add(word);
        }

        Map<String, Boolean> map = new HashMap<>();

        for (String word: words) {
            if (help(word,s, map, false)){
                res.add(word);
            }
        }

        return res;
    }

    private boolean help(String word, Set<String> s, Map<String, Boolean> map, boolean isPart) {
        if (isPart && s.contains(word)) {
            return true;
        }

        if (map.containsKey(word)) {
            return map.get(word);
        }

        for (int i = 1; i < word.length(); i++) {
            String right = word.substring(i);
            if (!s.contains(right)) {
                continue;
            }

            String left = word.substring(0, i);
            if (help(left, s, map, true)) {
                map.put(word, true);
                return true;
            }
        }

        map.put(word, false);


        return false;
    }
}
