/*
	Time Complexity: O(N)
	Space Complexity: O(K) ~ O(1) as we've fixed set of characters in english (26 alphabets)
	
	Where, N is the length of the string & K is the number of distinct characters in the string.
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376581
*/

import java.util.*;
public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		// map to keep the last index of a character encountered in strim=ng 's'
		HashMap<Character, Integer> map = new HashMap<>();
		int length = 0;
		
		int start = 0;
		for(int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			// if the map already contains the 'ch', shrink the window from the beginning so that
    		// we have only one occurrence of 'ch'
			if (map.containsKey(ch)) {
				// if 'start' is already ahead of the last index of 'ch', we'll keep 'start'
				// otherwise we'll shrink window from beginning
				start = Math.max(start, map.get(ch) + 1);
			}
			
			// insert the 'ch' into the map
			map.put(ch, end);
			// length so far
			length = Math.max(length, end - start + 1);
		}
		
		return length;
	}
}
