/*
https://leetcode.com/problems/largest-number/
medium
solution: int=>string, sort b+a compare with a+b
 */

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        String res = "";

        for (String str: strs) {
            if(res.length() == 0 && str.equals("0")) {
                continue;
            }

            res += str;

        }

        if (res.length() == 0) {
            return "0";
        }

        return res;
    }
}
