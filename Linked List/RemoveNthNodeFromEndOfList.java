/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        dummy.next = head;
        
        // Move fast pointer n + 1 nodes ahead of slow
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
            
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
            
        slow.next = slow.next.next;
        return dummy.next;
    }
}
