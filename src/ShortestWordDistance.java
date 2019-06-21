/*
https://leetcode.com/problems/shortest-word-distance/
easy
solution: p1 the position of word1, p2 the position of word2
 */

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = - 1, res = words.length  - 1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;

                if (p2 >= 0)
                    res = Math.min(res, p1 - p2);
            }

            if (words[i].equals(word2)) {
                p2 = i;

                if (p1 >= 0)
                    res = Math.min(res, p2 - p1);
            }

        }

        return res;
    }
}
