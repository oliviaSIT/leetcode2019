/*
https://www.lintcode.com/problem/k-edit-distance/description?_from=ladder&&fromId=46
hard
sol: build a trie  use dp
 */

import java.util.*;

public class KEditDistance {
    public class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        private String word;

        private TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    public class Trie {
        private TrieNode root;

        private Trie() {
            root = new TrieNode();
        }

        private void add(String str) {
            TrieNode n = root;

            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';

                if (n.children[index] == null)
                    n.children[index] = new TrieNode();

                n = n.children[index];
            }

            n.isWord = true;
            n.word = str;

            System.out.println(n.word);
        }
    }

    private List<String> res;

    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        res = new ArrayList<>();

        Trie t = new Trie();

        for (String word: words) {
            t.add(word);
        }

        int[] dp = new int[target.length() + 1];// dp[i] means the min dis between prefix which is composed from root to current node of t and the i characters of target

        for (int i = 0; i < dp.length; i++)
            dp[i] = i;

        find(t.root, k, target, dp);

        return res;
    }

    private void find(TrieNode n, int k, String target, int[] dp) {
        if (n.isWord && dp[target.length()] <= k) {
            res.add(n.word);
        }

        int[] next = new int[dp.length];

        for (int i = 0; i < 26; i++) {
            if (n.children[i] != null) {
                next[0] = dp[0] + 1;

                for (int j = 1; j < dp.length; j++) {
                    if (target.charAt(j - 1) - 'a' == i)
                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1], dp[j]) + 1);
                    else next[j] = Math.min(dp[j - 1], Math.min(next[j - 1], dp[j])) + 1;
                }

                find(n.children[i], k, target, next);
            }
        }
    }
}
