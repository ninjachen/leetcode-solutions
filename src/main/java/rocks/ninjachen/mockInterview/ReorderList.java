package rocks.ninjachen.mockInterview;


public class ReorderList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public void reorderList(ListNode head) {
        // return if len <= 2
        if (head.next == null || head.next.next == null) {
            return;
        }
        // reserve second half
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // now slow node is the middle of the chain
        // a -> b -> c => a <- b -> c
        ListNode pre = null;
        ListNode cur = slow.next;
        ListNode next = slow.next.next;
        slow.next = null;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        ListNode tail = cur;
        cur = head;
        head = head.next;
        while (head != null && tail != null) {
            ListNode headN = head.next;
            ListNode tailN = tail.next;
            cur.next = tail;
            cur.next.next = head;
            cur = cur.next.next;
            head = headN;
            tail = tailN;
        }
        while (head != null) {
            cur.next = head;
            head = head.next;
            cur = cur.next;
        }
        while (tail != null) {
            cur.next = tail;
            tail = tail.next;
            cur = cur.next;
        }
    }
}
