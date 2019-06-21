/*
https://leetcode.com/problems/couples-holding-hands/submissions/
hard
solution: greedy or union find http://www.cnblogs.com/grandyang/p/8716597.html
tricky: 1 row[i + 1] == (row[i] ^ 1)  2 == has priority to ^
 */

//greedy
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) {
            return -1;
        }

        int res = 0;

        for (int i = 0; i < row.length - 1; i += 2) {
            if (row[i + 1] == (row[i] ^ 1)) {
                continue;
            }

            res++;

            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    int t = row[j];
                    row[j] = row[i + 1];
                    row[i + 1] = t;
                }
            }
        }

        return res;
    }
}

/*
union find
class Solution {
public:
    int minSwapsCouples(vector<int>& row) {
        int res = 0, n = row.size(), cnt = n / 2;
        vector<int> root(n, 0);
        for (int i = 0; i < n; ++i) root[i] = i;
        for (int i = 0; i < n; i += 2) {
            int x = find(root, row[i] / 2);
            int y = find(root, row[i + 1] / 2);
            if (x != y) {
                root[x] = y;
                --cnt;
            }
        }
        return n / 2 - cnt;
    }
    int find(vector<int>& root, int i) {
        return (i == root[i]) ? i : find(root, root[i]);
    }
};
 */