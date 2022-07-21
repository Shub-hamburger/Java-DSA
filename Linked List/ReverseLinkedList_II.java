/*
    Time complexity: O(N)
    Space complexity: O(1)
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        if (left == right)
            return head;
        
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode prevNode = dummy;
        
        // Finding the node prev to the left position
        for(int i = 0; i < left - 1; i++)
            prevNode = prevNode.next;
        // Node at the left position
        ListNode tail = prevNode.next;
        
        ListNode prev2 = prevNode;
        ListNode tail2 = tail;
        ListNode nextNode = null;
        
        // Reversing the required LL portion
        for(int i = left; i <= right; i++) {
            nextNode = tail2.next;
            tail2.next = prev2;
            prev2 = tail2;
            tail2 = nextNode;
        }
        
        // Connecting the reversed LL portion to the correct nodes
        prevNode.next = prev2;
        tail.next = tail2;
        
        return dummy.next;
    }
}
