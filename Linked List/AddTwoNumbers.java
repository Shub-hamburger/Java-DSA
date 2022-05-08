/*
    Time complexity: O(Max(M, N))
    Space complexity: O(Max(M, N))
	
	Problem Link: https://leetcode.com/problems/add-two-numbers/submissions/
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode dummy = curr;
        int sumVal = 0;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            sumVal = carry;
            if (l1 != null)
                sumVal += l1.val;
            if (l2 != null)
                sumVal += l2.val;
            
            carry = sumVal / 10;
            curr.next = new ListNode(sumVal % 10);
            curr = curr.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        
        if (carry > 0)
            curr.next = new ListNode(carry);
        
        return dummy.next;
    }
}
