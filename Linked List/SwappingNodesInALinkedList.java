/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Inutition:
    ---------
    1. Let's use two more pointers first and second, denoting the nodes for swapping
    2. Put slow at head, and put fast k-1 nodes after slow.
    3. first = fast.
    4. If fast isn't already at the last node, move slow and fast one node further until fast.next == null
    5. second = slow
    6. Swap the values of first and second
	
	Problem Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        // finding the first node
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        
        ListNode first = fast;
        
        // finding the second node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode second = slow;
        
        // swapping the first and second node values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}
