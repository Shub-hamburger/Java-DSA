/*
    Time Complexity : O(N * N * M), where M is the number of rows and N is the number of columns in the given matrix.
    Space Complexity : O(N)
*/

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length + 1;
        int[][] cumSum = new int[row][col];
        
        // calculating prefix sum matrix
        for(int i = 0; i < row; i++) {
            for(int j = 1; j < col; j++) {
                cumSum[i][j] = cumSum[i][j - 1] + matrix[i][j - 1];
            }
        }
        
        // Two for loops for two columns of submatrix
        for(int start = 0; start < col; start++) {
            for(int end = start + 1; end < col; end++) {
                /*
                    The value of "subMatrixSum" exceeds the desired "target" by subMatrixSum – target. If this value is removed
                    from currsum then the desired "target" can be obtained. 
                    From the map, find the number of subarrays previously found having sum  equal to subMatrixSum - target. 
                */
                int subMatrixSum = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                
                map.put(0, 1);
                // Traversing the matrix row-wise to find the subarrays that sum = target 
                for(int currRow = 0; currRow < row; currRow++) {
                    // Using the prefix sum of each row to calculate the matrix sum between the "start" column and "end" column.
                    subMatrixSum += cumSum[currRow][end] - cumSum[currRow][start];
                    int diff = subMatrixSum - target;
                    
                    if (map.containsKey(diff))
                        count += map.get(diff);
                    
                    map.put(subMatrixSum, map.getOrDefault(subMatrixSum, 0) + 1);
                }
            }
        }
        
        return count;
    }
}
