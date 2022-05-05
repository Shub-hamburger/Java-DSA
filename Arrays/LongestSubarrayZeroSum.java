/*
	Time complexity: O(N)
	Space complexity: O(N)
	
	Problem Link: https://www.codingninjas.com/codestudio/problems/longest-subset-zero-sum_920321
*/

import java.util.* ;
public class Solution {
	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.size();
		int maxLen = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += arr.get(i);
			if (sum == 0) {
				maxLen = i + 1;
			}
			else {
				if (map.get(sum) != null) {
					maxLen = Math.max(maxLen, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}
		}
		
		return maxLen;
	}
}
