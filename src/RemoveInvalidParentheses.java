/*
https://leetcode.com/problems/remove-invalid-parentheses/submissions/
hard
solution: dfs https://zxi.mytechroad.com/blog/string/leetcode-301-remove-invalid-parentheses/
1 check whether input is valid
2 compute the min '(' or ')' to remove
3 remove
 */

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0;//the '(' need to remove
        int r = 0;//the ')' need to remove

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }

            if (l == 0) {
                if (s.charAt(i) == ')') {
                    r++;
                }
            } else {
                if (s.charAt(i) == ')') {
                    l--;
                }
            }
        }

        List<String> res = new ArrayList<>();
        dfs(s, 0 , l, r, res);

        return res;
    }

    private boolean isValid(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            }

            if (s.charAt(i) == ')') {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }

        return cnt == 0;
    }

    private String removeChar(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    private void dfs(String s, int st, int l, int r, List<String> res) {
        //Nothing to remove
        if (isValid(s)) {
            res.add(s);
            return;
        }

        if (l == 0 && r == 0) {
            return;
        }

        for (int i = st; i < s.length(); i++) {
            //we only remove the first parentheses if consecutive
            if (i != st && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String cur = removeChar(s, i);

                if (r > 0 && s.charAt(i) == ')') {
                    dfs(cur, i, l, r - 1, res);
                }

                if (l > 0 && s.charAt(i) == '(') {
                    dfs(cur, i, l - 1, r, res);
                }
            }
        }
    }
}
