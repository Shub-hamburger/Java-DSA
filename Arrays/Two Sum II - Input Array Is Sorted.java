/*
    Time complexity: O(N)
    Space complexity: O(1)
	
	Problem Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        
        int idx1 = -1;
        int idx2 = -1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                idx1 = start;
                idx2 = end;
                break;
            }
            else if (sum > target)
                end--;
            else
                start++;
        }
        
        return new int[]{idx1 + 1, idx2 + 1};
    }
}
