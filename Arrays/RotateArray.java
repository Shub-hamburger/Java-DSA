/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/rotate-array/
*/
class Solution {
    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        
        // Reverse first and second parts respectively
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        
        // Reverse the whole array
        reverse(nums, 0, n - 1);
    }
}
