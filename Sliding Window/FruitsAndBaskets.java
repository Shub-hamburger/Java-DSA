/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376582
*/
import java.util.*;
public class Solution {
	public static int findMaxFruits(String str, int n) {
		HashMap<Character, Integer> map = new HashMap<>();
		int maxFruits = Integer.MIN_VALUE;
		int k = 2;
		
		int start = 0;
		for(int end = 0; end < str.length(); end++) {
			char ch = str.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			while (map.size() > k) {
				char leftChar = str.charAt(start);
				map.put(leftChar, map.get(leftChar) - 1);
				if (map.get(leftChar) == 0) {
					map.remove(leftChar);
				}
				start++;
			}
			maxFruits = Math.max(maxFruits, end - start + 1);
		}
		
		return maxFruits;
	}
}
