/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376583
*/

import java.util.*;
public class Solution {
	public static ArrayList<Integer> findAnagramsIndices(String str, String ptr, int n, int m) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Character, Integer> patternMap = new HashMap<>();
		for(int i = 0; i < m; i++) {
			char ch = ptr.charAt(i);
			patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
		}
		
		int start = 0;
		int matched = 0;
		for(int end = 0; end < n; end++) {
			char ch = str.charAt(end);
			if (patternMap.containsKey(ch)) {
				patternMap.put(ch, patternMap.getOrDefault(ch, 0) - 1);
				if (patternMap.get(ch) == 0) 
					matched++;
			}
			if (matched == patternMap.size()) {
				ans.add(start);
			}
			
			if (end >= m - 1) {
				char leftChar = str.charAt(start);
				if (patternMap.containsKey(leftChar)) {
					if (patternMap.get(leftChar) == 0)
						matched--;
					patternMap.put(leftChar, patternMap.getOrDefault(leftChar, 0) + 1);
				}
				start++;
			}
		}
		
		return ans;
	}
}
