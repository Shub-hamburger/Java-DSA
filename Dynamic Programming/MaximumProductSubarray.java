/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/maximum-product-subarray/
*/
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int res = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int prevMaxProd = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(prevMaxProd * nums[i], minProd * nums[i]));
            res = Math.max(res, maxProd);
        }
        
        return res;
    }
}
