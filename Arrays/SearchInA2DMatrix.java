// Approach 1

/*
  Time complexity: O(MlogN)
  Space complexity: O(1)
  
  Where, M is the #rows and N is the #cols
  
  Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution {
    public int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = arr[mid];
            
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end--;
            else 
                start++;
        }
        
        return -1;
        
    } 
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++) {
            if (binarySearch(matrix[i], target) != -1)
                return true;
        }
        
        return false;
    }
} 
