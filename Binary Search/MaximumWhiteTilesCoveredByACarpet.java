/*
    Time complexity: O(NlogN)
    Space complexity: O(N)
    
    Intuition:
    ---------
    1. Sort array to make sequence monotonic increasing order
    2. Calculate Prefix sum of white tiles, where prefix sum at ith location denote that (prefix sum till i-1) + Total tiles in ith
    location. This will help us to find total white tiles in range [i, j] in O(1) time
    3. Now Run a loop for each tiles, and do following
        (i) Take start of carpet location as tiles[i][0]
        (ii) end location of carpet be start + length of carpet
        (iii) Search maximum end location in tiles that carpet can cover using binary search
        (iv) Now, find total white tiles present between start idx and end idx using prefix sum array
        (v) Update ans with maximum total white tiles
*/

class Solution {
    public int binarySearch(int[][] tiles, int carpetLen, int low, int high){
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(tiles[mid][1] >= carpetLen) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
        
        int maxTiles = 0;
        int n = tiles.length;
        int[] prefixSum = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            int[] tile = tiles[i];
            prefixSum[i + 1] = prefixSum[i] + (tile[1] - tile[0] + 1);
        }
           
        for(int i = 1; i <= tiles.length; i++) {
            // get the index, from where the ith index can reach
            int idx = binarySearch(tiles, tiles[i - 1][0] + carpetLen, i - 1, tiles.length - 1);
            
            // calculate the sum till the idx index
            int prefix = (prefixSum[idx] - prefixSum[i - 1]);
            
            // taking into account the ith index, and calculate if more area can be covered in idx or not.
            int extra = Math.min(carpetLen - (tiles[idx][0] - tiles[i - 1][0]), prefixSum[idx + 1] - prefixSum[idx]);
            
            // this is the total possible units that can be covered from ith index
            int totalTiles = prefix + (Math.max(0, extra));
                        
            maxTiles = Math.max(maxTiles, totalTiles);
        }
        
        return maxTiles;
    }
}
