/*
    Approach 1
    ----------
    Time complexity: O(M + N)
    Space complexity: O(1)
    
    Where, M is the #rows and N is the #cols
    
    Intuition:
    ----------
    We start search the matrix from top right corner, initialize the current position to top right corner, if the target is
    greater than the value in current position, then the target can not be in entire row of current position because the
    row is sorted, if the target is less than the value in current position, then the target can not in the entire column
    because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
	
	Problem Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}

/*
    Approach 2
    ----------
    Time complexity: O(MlogN)
    Space complexity: O(1)
    
    Where, M is the #rows and N is the #cols
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
