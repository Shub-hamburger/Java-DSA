/*
	Solution 2
	---------
    Time Complexity: O(Min(M, N))
    Space Complexity: O(1)
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode();
        ListNode dummy = curr;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        curr.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}


/*
	Solution 1
	----------
    Time Complexity: O(N + M)
    Space Complexity: O(N + M)
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode();
        ListNode dummy = curr;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            }
        }
        
        while (list1 != null) {
            curr.next = new ListNode(list1.val);
            curr = curr.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            curr.next = new ListNode(list2.val);
            curr = curr.next;
            list2 = list2.next;
        }
        
        return dummy.next;
    }
}
