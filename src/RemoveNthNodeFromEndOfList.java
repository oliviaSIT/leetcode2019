/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
medium
tag: linked list
solution: 2 pointors
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i = 0;
        while (fast != null && i < n) {
            i++;
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        fast = fast.next;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
