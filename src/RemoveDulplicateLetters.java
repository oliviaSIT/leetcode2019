/*
https://leetcode.com/problems/remove-duplicate-letters/
hard
solution:如果一个字母c，小于前面的某个字母d，并且d在c后面还有，那么d应当被删除
 */

import java.util.Stack;

public class RemoveDulplicateLetters {
    public String removeDuplicateLetters(String s) {
        // write your code here
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();// st: abc

        for (char c: s.toCharArray()) {
            if (stack.contains(c)) { // cdc
                counts[c - 'a']--;
                continue;
            }
            while (!stack.isEmpty() && counts[stack.peek() - 'a'] > 1 && stack.peek() > c) {
                char top = stack.pop();
                counts[top - 'a']--;
            }
            stack.push(c);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
/*
    public static void main(String[] args) {
        RemoveDulplicateLetters sol = new RemoveDulplicateLetters();
        sol.removeDuplicateLetters("cbacdcbc");
    }
*/
    /*
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2)
            return s;

        Map<Character, Integer> m = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (stack.size() > 0 && c > s.charAt(stack.peek())) {
                stack.pop();
            }

            if (i == 0 || !m.containsKey(c) || (stack.size() > 0 && c != s.charAt(stack.peek())))
                m.put(c, i);

            stack.push(i);

        }

        char[] temp = new char[s.length()];
        for (int i = 0; i < temp.length; i++)
            temp[i] = '*';

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            char c = entry.getKey();
            int index = entry.getValue();
            temp[index] = c;
        }

        String res = "";
        for (char c: temp) {
            if (c != '*')
                res += c;
        }

        return res;
    }
     */
}
