/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
    Time complexity: O(N)
    Space complexity: O(1)
	
	Idea: We just need to follow the strategy above - make a slower pointer and a faster pointer. Then we loop and loop again:
		1. If the fast pointer catch up with slow pointer, then it's a circular linked list
		2. If the fast pointer get to the end, then it's not a circular linked list
	
	Problem Link: https://leetcode.com/problems/linked-list-cycle/
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast)
                return true;
        }
        return false;
    }
}
