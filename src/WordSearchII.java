/*
https://leetcode.com/problems/word-search-ii/
hard
solution: trie dfs
 */

import java.util.List;
import java.util.ArrayList;

public class WordSearchII {
    class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private void insert(String word) {
            TrieNode node = root;

            for (char w: word.toCharArray()) {
                int index = w - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.isWord = true;
        }
    }

    private Trie dict;
    private boolean[][] v;
    private List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();

        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return res;

        dict = new Trie();

        for (String word: words)
            dict.insert(word);

        v = new boolean[board.length][board[0].length];

        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int index = board[i][j] - 'a';

                if (dict.root.children[index] != null && !v[i][j]) {
                    v[i][j] = true;
                    dfs(board, i, j, dict.root.children[index], str + board[i][j]);
                    v[i][j] = false;
                }

            }
        }

        return res;
    }

    private void dfs(char[][] board, int x, int y, TrieNode p, String str) {
        if (p.isWord) {
            res.add(str);
            p.isWord = false;
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !v[nx][ny]) {
                int index = board[nx][ny] - 'a';
                v[nx][ny] = true;
                if (p.children[index] != null)
                    dfs(board, nx, ny, p.children[index], str + board[nx][ny]);

                v[nx][ny] = false;
            }
        }
    }
}
