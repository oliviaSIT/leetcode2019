/*
https://leetcode.com/problems/find-the-closest-palindrome/
hard
solution: 原则改低位， 如果本来就是回文数，更改中间的数
 */

import java.util.Set;
import java.util.HashSet;

public class FindTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n), res = 0, diff = Long.MAX_VALUE;
        int len = n.length();
        Set<Long> s = new HashSet<>();
        s.add((long)Math.pow(10, len) + 1);
        s.add((long)Math.pow(10, len - 1) - 1);
        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = -1; i <= 1; i++) {
            String pre = String.valueOf(prefix + i);
            StringBuilder b = new StringBuilder(pre);
            String t = new String();
            if (len % 2 == 0)
                t = b.reverse().toString();
            else t = b.reverse().toString().substring(1, pre.length());
            String str = pre + t;
            s.add(Long.parseLong(str));
        }

        s.remove(num);

        for (long ele: s) {
            long cur = Math.abs(ele - num);
            if (cur < diff) {
                diff = cur;
                res = ele;
            } else if (cur == diff) {
                res = Math.min(res, ele);
            }
        }

        return String.valueOf(res);
    }
}
