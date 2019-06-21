/*
https://leetcode.com/problems/word-ladder/
medium
solution: bfs
 */

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();

        for (String str: wordList) {
            dict.add(str);
        }

        if (!dict.contains(endWord)) {
            return 0;
        }

        return bfs(beginWord, endWord, dict);
    }

    private int bfs(String beginWord, String endWord, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        Set<String> v = new HashSet<>();

        int dist = 1;

        if (beginWord.equals(endWord)) {
            return 1;
        }

        q.offer(beginWord);
        v.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            dist++;

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (int k = 0; k < cur.length(); k++) {
                    char[] cs = cur.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        cs[k] = c;

                        String newStr = String.valueOf(cs);

                        if (newStr.equals(endWord)) {
                            return dist;
                        }

                        if (!v.contains(newStr) && dict.contains(newStr)) {
                            q.offer(newStr);
                            v.add(newStr);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
