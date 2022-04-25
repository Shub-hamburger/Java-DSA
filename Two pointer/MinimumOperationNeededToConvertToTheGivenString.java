/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376571
*/

public class Solution {
	public static int minCostToGivenString(String str1, String str2) {
		int i = 0, j = 0, m = str1.length(), n = str2.length();
		int count = 0;
		
		if (m != n)
			return -1;
		
		while (i < m && j < n) {
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
				count++;
			}
			else {
				i++;
			}
		}
		
		return m - count;
	}
}
