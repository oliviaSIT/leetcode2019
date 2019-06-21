/*
https://leetcode.com/problems/integer-break/
medium
solution: n = 4 >= 2 * 2 > 1 * 3 5 => 2 * 3 所有数拆解到4，没有必要继续拆解
http://www.cnblogs.com/grandyang/p/5411919.html
 */

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }

        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }

        res *= n;
        return res;
    }
}
