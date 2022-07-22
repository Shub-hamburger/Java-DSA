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
    Time complexity: O(N)
    Space complexity: O(1)
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Stores the head of the list having values < x
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        // Stores the head of the list having values >= x
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;
        
        while (head != null) {
            // if curr value < x, then add curr node to small list
            if (head.val < x) {
                small.next = head;
                small = small.next;
            }
            // if curr value >= x, then add curr node to small list
            else {
                large.next = head;
                large = large.next;
            }
            
            head = head.next;
        }
        
        // set next ptr of large list's last node to null as this node is the last node of the new list also
        large.next = null;
        // join the small list to the large list
        small.next = largeHead.next;
        
        return smallHead.next;
    }
}
