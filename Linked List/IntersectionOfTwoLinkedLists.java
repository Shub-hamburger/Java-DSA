/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
	Solution using difference of lengths
	------------------------------------
    Time complexity: O(N)
    Space complexity: O(1)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        int len1 = 0;
        int len2 = 0;
        
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }
        
        // move headA and headB to the same start point
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }
        while (len1 < len2) {
            headB = headB.next;
            len2--;
        }
        
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
