/*
https://leetcode.com/problems/strobogrammatic-number-iii/
hard
solution: recursor
递归的长度len从low到high之间遍历，然后我们看当前单词长度有没有达到len，如果达到了，我们首先要去掉开头是0的多位数，然后去掉长度和low相同但小于low的数，和长度和high相同但大于high的数，然后结果自增1，然后分别给当前单词左右加上那五对对称数，继续递归调用
http://www.cnblogs.com/grandyang/p/5203228.html
 */

public class StrobogrammaticNumberIII {
    private int res;
    public int strobogrammaticInRange(String low, String high) {
        res = 0;

        for (int l = low.length(); l <= high.length(); l++) {
            help(low, high, "", l);
            help(low, high, "1", l);
            help(low, high, "8", l);
            help(low, high, "0", l);
        }

        return res;
    }

    private void help(String low, String high, String str, int l) {
        if (str.length() >= l) {
            if (str.length() != l || (str.length() > 1 && str.charAt(0) == '0'))
                return;

            if (l == low.length() && str.compareTo(low) < 0 || (l == high.length() && str.compareTo(high) > 0))
                return;

            res++;
        }

        help(low, high, "1" + str + "1", l);
        help(low, high, "6" + str + "9", l);
        help(low, high, "8" + str + "8", l);
        help(low, high, "9" + str + "6", l);
        help(low, high, "0" + str + "0", l);

    }
}
