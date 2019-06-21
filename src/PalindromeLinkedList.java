/*
https://leetcode.com/problems/palindrome-linked-list
easy
solution: find the middle node, reverse the right part of the linkedlist
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        List<Integer> array = new ArrayList<>();

        ListNode n = head;

        while (n != null) {
            array.add(n.val);
            if (n.val + 2 == Integer.MIN_VALUE)
                System.out.println(n.val);

            n = n.next;
        }


        int l = 0, r = array.size() - 1;
        while (l < r) {
            if (array.get(l) != array.get(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
/*
    public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();
        ListNode head = new ListNode(-128);
        head.next = new ListNode(-128);
        boolean res = sol.isPalindrome(head);
    }
*/
}
/*
public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;
        int cnt = 1;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            cnt++;
        }


        ListNode pre = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode t = slow.next;
            slow.next = pre;
            pre = slow;
            slow = t;
        }


        for (int i = 0; i < cnt; i++) {
            if (head.val != pre.val)
                return false;

            head = head.next;
            pre = pre.next;
        }

        return true;
    }
 */