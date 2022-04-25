/*
    Time complexity: O(M)
    Space complexity: O(1)

    where 'M' is number of characters in string 'str2'. 
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376572
*/

public class Solution {

	public static String isSubsequence(String str1, String str2) {
		int idx = 0;
		int n = str1.length();
		int m = str2.length();

		// Iterate all characters of 'str2'.
		for (int i = 0; i < m; i++) {

			if (str2.charAt(i) == str1.charAt(idx)) {
				idx += 1;
			}

			// All the characters of 'str1' iterated.
			if (idx == n) {
				break;
			}
		}

		// If all characters of 'str1' are present in 'str2' in same order.
		if (idx == n) {
			return "True";
		} else {
			return "False";
		}
	}

}
