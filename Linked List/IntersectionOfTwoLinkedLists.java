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
    Solution without using difference of lengths
    --------------------------------------------
    Time complexity: O(M + N)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            // for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }

        return a;
    }
}


/*
    Solution using difference of lengths
    ------------------------------------
    Time complexity: O(M + N)
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
