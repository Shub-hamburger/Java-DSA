/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/next-permutation/
*/
class Solution {
    public void swap(int[] nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }
    public void reverse(int[] nums, int first, int second) {
        while(first < second) 
            swap(nums, first++, second--);
    }
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1)
            return;
         
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; 
        if(i >= 0) {                           
            int j = nums.length - 1;              
            while(nums[j] <= nums[i]) j--;      
            swap(nums, i, j);                     
        }
        
        // reverse numbers from peak to get the smallest permutation
        reverse(nums, i + 1, nums.length - 1); 
    }
}
