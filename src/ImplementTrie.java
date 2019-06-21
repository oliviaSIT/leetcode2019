/*
https://leetcode.com/problems/implement-trie-prefix-tree/
medium

 */

public class ImplementTrie {
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;

        for (char w: word.toCharArray()) {
            int index = w -'a';
            if (p.children[index] == null)
                p.children[index] = new TrieNode();

            p = p.children[index];
        }

        p.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = find(word);
        return p != null && p.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = find(prefix);
        return p != null;
    }

    private TrieNode find(String word) {
        TrieNode res = root;

        for (char w: word.toCharArray()) {
            int index = w - 'a';

            if (res.children[index] == null)
                return null;

            res = res.children[index];
        }

        return res;
    }
}
