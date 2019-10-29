package rocks.ninjachen.mockInterview;


import java.util.*;

public class IsPalindrome {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null)
            return true;
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int i, j;
        if (list.size() % 2 == 0) {
            i = list.size() / 2 - 1;
            j = list.size() / 2;
        } else {
            i = list.size() / 2;
            j = i;
        }
        for (; i >= 0; i--, j++) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
}
