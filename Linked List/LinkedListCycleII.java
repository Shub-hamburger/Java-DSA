/*
    Time complexity: O(N)
    Space complexity: O(1)
	
	Idea: Hare & tortoise algorithm
    
    Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        while (hasCycle && head != slow) {
            head = head.next;
            slow = slow.next;
        }
        
        return hasCycle ? slow : null;
    }
}
