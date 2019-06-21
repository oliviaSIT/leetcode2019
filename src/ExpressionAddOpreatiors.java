/*
https://leetcode.com/problems/expression-add-operators/
hard
solutuion:https://zxi.mytechroad.com/blog/searching/leetcode-282-expression-add-operators/
 */

import java.util.List;
import java.util.ArrayList;

public class ExpressionAddOpreatiors {
    private List<String> res;
    private char[] num;
    private char[] exp;
    private int target;

    public List<String> addOperators(String num, int target) {
        this.num = num.toCharArray();
        this.res = new ArrayList<>();
        this.exp = new char[num.length() * 2];
        this.target = target;

        dfs(0, 0, 0, 0);

        return res;
    }

    private void dfs(int pos, int len, long pre, long cur) {
        if (pos == num.length) {
            if (cur == target)
                res.add(new String(exp, 0, len));

            return;
        }

        int s = pos, l = len;
        if (s != 0)
            len++;// if not the first, add operator

        long n = 0;
        while (pos < num.length) {
            if (num[s] == '0' && pos - s > 0) //case '0x'
                break;

            n = n * 10 + (num[pos] - '0');
            if (n > Integer.MAX_VALUE)
                break;

            exp[len++] = num[pos++]; // copy exp
            if (s == 0) {
                dfs(pos, len, n,n);
                continue;
            }

            exp[l] = '+';
            dfs(pos, len, n, cur + n);

            exp[l] = '-';
            dfs(pos, len,  -n, cur - n);

            exp[l] = '*';
            dfs(pos, len, pre * n, cur - pre + pre * n);
        }
    }
}
