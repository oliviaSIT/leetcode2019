/*
https://leetcode.com/problems/different-ways-to-add-parentheses/
medium
solution:在+-*处将字符串分为两部分，分别计算每一部分的结果，再将两组结果进行组合
         divide and conqor  记忆化递归
 */

import java.util.*;

public class DifferentWaysToAddParentheses {
    private Map<String, List<Integer>> m;

    public List<Integer> diffWaysToCompute(String input)  {
        m = new HashMap<>();
        return way(input);
    }

    private List<Integer> way(String input) {
        if (m.containsKey(input)) {
            return m.get(input);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String left = input.substring(0, i);
                String right = input.substring(i + 1);
                List<Integer> l = way(left);
                List<Integer> r = way(right);

                for (int a : l) {
                    for (int b : r) {
                        if (input.charAt(i) == '+')
                            res.add(a + b);

                        if (input.charAt(i) == '-')
                            res.add(a - b);

                        if (input.charAt(i) == '*')
                            res.add(a * b);
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }

        m.put(input, res);

        return res;
    }
}
