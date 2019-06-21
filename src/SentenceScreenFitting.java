/*
https://leetcode.com/problems/sentence-screen-fitting
medium
solution: similar as jump game
https://leetcode.com/problems/sentence-screen-fitting/discuss/90874/12ms-Java-solution-using-DP
 */

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int[] nextRow = new int[n]; // nextRwo[i] means if current row starts with the ith string, then next row will start with the nextRow[i]th string

        for (int i = 0, prev = 0, len = 0; i < n; i++) { // prev: st    , len: the length of string of current row
            if (i != 0 && len > 0)
                len -= sentence[i - 1].length() + 1;

            while (len + sentence[prev % n].length() <= cols)
                len += sentence[prev++ % n].length() + 1;

            nextRow[i] = prev;
        }

        int count = 0;

        for (int i = 0, st = 0; i < rows; i++) {
            count += nextRow[st] - st;
            st = nextRow[st] % n;
        }

        return count / n;
    }
}
