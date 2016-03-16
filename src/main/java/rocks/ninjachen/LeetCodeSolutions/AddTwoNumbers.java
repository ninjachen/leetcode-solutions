package rocks.ninjachen.LeetCodeSolutions;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] arg){
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new ListNode(3);
        ListNode l11 = new ListNode(7);
        l1.next=l11;
        ListNode l2 = new ListNode(9);
        ListNode l22 = new ListNode(2);
        l2.next =l22;
        ListNode sum = solution.addTwoNumbers(l1, l2);
        System.out.println(sum.val);
        while (sum.next != null){
            sum = sum.next;
            System.out.println(sum.val);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up=0;
        int sum = l1.val + l2.val;
        if(sum > 9){
            up=1;
            sum -= 10;
        }
        ListNode curNode = new ListNode(sum);
        ListNode headNode = curNode;
        while (l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            sum = l1.val + l2.val + up;
            up=0;
            if(sum > 9){
                up=1;
                sum -= 10;
            }
            ListNode nextSum = new ListNode(sum);
            curNode.next = nextSum;
            //move to next
            curNode = nextSum;
        }
        ListNode rest = null;
        if(l1.next == null){
            rest = l2.next;
        }
        if(l2.next == null){
            rest = l1.next;
        }
        while(rest != null){
            sum = rest.val + up;
            up = 0;
            if(sum>9){
                sum -= 10;
                up = 1;
            }
            ListNode nextSum = new ListNode(sum);
            nextSum.val = sum;
            curNode.next = nextSum;
            curNode = nextSum;
            rest = rest.next;
        }
        if(up >0){
            ListNode upNode = new ListNode(up);
            curNode.next = upNode;
            curNode= upNode;
        }
        return headNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
