/*
    Time complexity: O(n * log(k)), where k is difference between maximum and minimum values in our matrix.
    Space complexity: O(1)
    
    Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
*/
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length; 
        
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1] + 1;
        
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            int count = 0,  j = n - 1;
            for(int i = 0; i < m; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            
            if(count < k) 
                lo = mid + 1;
            else 
                hi = mid;
        }
        
        return lo;
    }
}
