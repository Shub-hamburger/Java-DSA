/*
	Time Complexity: O(N ^ 2)
	Space Complexity: O(1)
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376554
*/

public class Solution {
	public static int longestMountain(int arr[], int n){
		int longest = 0;
        
        if(n < 3) {
			return longest;
        }
		
        int i = 0;
        while(i < n) {
			int start = i;
			
			// ascend towards the peak
			while (i + 1 < n && arr[i] < arr[i + 1]) {
				i++;
			}
			
			// flat 
			if (i == start) {
				i++;
				continue;
			}
			int peak = i;
			
			// descend from the peak
			while (i + 1 < n && arr[i] > arr[i + 1]) {
				i++;
			}
			
			// flat 
			if (i == peak) {
				i++;
				continue;
			}
			int end = i;
			
			longest = Math.max(longest, end - start + 1);
		}
		return longest;
	}
}
