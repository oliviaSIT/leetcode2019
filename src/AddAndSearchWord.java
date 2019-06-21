/*
https://leetcode.com/problems/add-and-search-word-data-structure-design/
medium
solution: trie dfs
 */

public class AddAndSearchWord {
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
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;

        for (char w: word.toCharArray()) {
            int index = w -'a';

            if (p.children[index] == null)
                p.children[index] = new TrieNode();

            p = p.children[index];
        }

        p.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchWord(word, root, 0);
    }

    private boolean searchWord(String word, TrieNode root, int i) {
        if (i == word.length())
            return root.isWord;

        if (word.charAt(i) == '.') {
            for (TrieNode p: root.children) {
                if (p != null && searchWord(word, p, i + 1))
                    return true;
            }

            return false;
        } else return root.children[word.charAt(i) - 'a'] != null && searchWord(word, root.children[word.charAt(i) - 'a'], i + 1);
    }
}
