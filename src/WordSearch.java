/*
https://leetcode.com/problems/word-search/
medium
solution: dfs 如果将res作为全局变量，那么即使已经找到，还是会进行递归，会超时
 */

public class WordSearch {
    private boolean[][] v;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        v = new boolean[board.length][board[0].length];
        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    v[i][j] = true;
                    if (dfs(board, word, i, j, str+board[i][j]))
                        return true;

                    v[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, String str) {
        if (str.length() == word.length()) {
            return true;
        }


        int l = str.length();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !v[x][y] && board[x][y] == word.charAt(l)) {
                v[x][y] = true;
                if (dfs(board, word, x, y, str+board[x][y]))
                    return true;

                v[x][y] = false;
            }
        }

        return false;
    }
}
 /*
 class Solution {
    private boolean[][] v;
    private boolean res;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        res = false;
        v = new boolean[board.length][board[0].length];
        String str = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    v[i][j] = true;
                    dfs(board, word, i, j, str+board[i][j]);
                    if (res == true)
                        return true;

                    v[i][j] = false;
                }
            }
        }

        return false;
    }

    private void dfs(char[][] board, String word, int i, int j, String str) {
        if (str.length() == word.length()) {
            if (str.equals(word))
                res = true;

            return;
        }

        int l = str.length();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !v[x][y] && board[x][y] == word.charAt(l)) {
                v[x][y] = true;
                dfs(board, word, x, y, str+board[x][y]);
                v[x][y] = false;
            }
        }
    }
}
  */