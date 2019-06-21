/*
https://leetcode.com/problems/maximum-product-of-word-lengths/
medium
solution: bit 字母出现，对应位置+1， 两个数没有重复数字，与的结果为0
http://www.cnblogs.com/grandyang/p/5090058.html
 */

public class MaximumProductOfWordsLength {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int res = 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                mask[i] |= (1 << (words[i].charAt(j) - 'a'));
            }

            for (int k = 0; k < i; k++) {
                if ((mask[i] & mask[k]) == 0)
                    res = Math.max(res, words[i].length() * words[k].length());
            }
        }

        return res;
    }
}
