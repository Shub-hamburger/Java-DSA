/*
    Iterative solution
    ------------------
    Time complexity: O(N)
    Space complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/swap-nodes-in-pairs/
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy; 
        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            prev = curr;
            curr = next;
        }
        
        prev.next = curr;
        return dummy.next;
    }
}

/*
    Recursive solution
    ------------------
    Time complexity: O(N)
    Space complexity: O(N) -> stack space
*/

class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        
        // Hypothesis
        ListNode newHead = head.next;
        ListNode swappedNode = swapPairs(head.next.next);
        
        // Induction
        head.next = swappedNode;
        newHead.next = head;
        
        return newHead;
    }
}
