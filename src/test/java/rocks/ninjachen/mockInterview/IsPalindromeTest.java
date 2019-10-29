package rocks.ninjachen.mockInterview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsPalindromeTest {
    IsPalindrome solution;

    @Before
    public void setUp() throws Exception {
        solution = new IsPalindrome();
    }

    @Test
    public void isPalindrome() {
        IsPalindrome.ListNode head = new IsPalindrome.ListNode(-129);
        IsPalindrome.ListNode next = new IsPalindrome.ListNode(-129);
        head.next = next;
        Assert.assertEquals(true, solution.isPalindrome(head));
    }
}