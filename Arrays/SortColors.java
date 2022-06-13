/*
    Time complexity: O(N)
    Space complexity: O(1)
*/
class Solution {
    public void swap(int[] arr, int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    } 
    public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            int val = nums[mid];
            if (val == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            }
            else if (val == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }
}
