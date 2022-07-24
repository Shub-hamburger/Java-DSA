/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
    Time complexity: O(n)
    Space complexity: O(1)
    
    Inutition:
    ----------
    1. Find the middle node
    2. Reverse the second half
    3. Iterate over both the halves and make the relevant connections
*/
class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public void reorderList(ListNode head) {
        ListNode dummy = head;
        ListNode slow = head;
        ListNode fast = head;
        
        // Finding the middle element
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reversing the second half
        ListNode reversedSecondHalfLL = reverse(slow);
        ListNode dummySecond = reversedSecondHalfLL;
        
        // iterating over the two halves and making relevant connections
        while (dummy.next != null && dummySecond.next != null) {
            ListNode temp = dummy.next;
            dummy.next = dummySecond;
            dummySecond = dummySecond.next;
            dummy.next.next = temp;
            dummy = dummy.next.next;
        }
    }
}
