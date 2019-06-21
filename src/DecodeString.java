/*
https://leetcode.com/problems/decode-string/
medium
solution: stack dfs
http://www.cnblogs.com/grandyang/p/5849037.html
 */

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        String t = "";
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                cnt = 10 * cnt + s.charAt(i) - '0';
            else if (s.charAt(i) == '[') {
                num.push(cnt);
                str.push(t);
                cnt = 0;
                t = "";
            } else if (s.charAt(i) == ']') {
                int k = num.pop();
                String a = str.peek();
                for (int j = 0; j < k; j++) {
                    a += t;
                }
                t = a;
                str.pop();
            } else t += s.charAt(i);
        }

        return str.isEmpty() ? t : str.peek();
    }
    /*
    public String decodeString(String s) {
        int i = 0;
        return decode(s, i);
    }

    private String decode(String s, int i) {
        String res = "";
        int n = s.length();
        while (i < n && s.charAt(i) !=  ']') {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                res += s.charAt(i++);
            else  { // if is num
                int cnt = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                    cnt += cnt * 10 + s.charAt(i++) - '0';

                // num follows by [
                i++;

                String t = decode(s, i);
                // handle ']'
                i++;
                while (cnt-- > 0)
                    res += t;
            }
        }

        return res;
    }

    */
}
