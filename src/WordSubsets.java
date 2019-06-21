/*
https://leetcode.com/problems/word-subsets/
medium
solution: int[] uni restore the max count of char
hash, string
 */

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] uni = new int[26];// dict of B
        int[] tmp;

        for (String b: B) {
            tmp = count(b);

            for (int i = 0; i < 26; i++) {
                uni[i] = Math.max(uni[i], tmp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for (String a: A) {
            tmp = count(a);// dict for current ele in A:a
            int i;
            for (i = 0; i < 26; i++) {
                if (tmp[i] < uni[i])
                    break;
            }

            if (i == 26)
                res.add(a);
        }

        return res;
    }

    private int[] count(String str) {
        int[] res = new int[26];

        for (char c: str.toCharArray()) {
            res[c - 'a']++;
        }

        return res;
    }
}

/*
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();

        for (String strA: A) {
            boolean isSub = true;
            for (String strB: B) {
                isSub = isSub && help(strA, strB);
                if (isSub == false)
                    break;
            }

            if (isSub)
                res.add(strA);
        }

        return res;
    }

    private boolean help(String A, String B) {
        if (A.length() < B.length())
            return false;

        int la = A.length(), lb = B.length();
        int[] v = new int[26];
        for (int i = 0; i < lb; i++) {
            v[B.charAt(i) - 'a']++;
        }

        for (int j = 0; j < la; j++) {
            v[A.charAt(j) - 'a']--;
        }

        for (int count: v) {
            if (count > 0)
                return false;
        }

        return true;
    }
}
 */