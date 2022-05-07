/*
    Time complexity: O(N)
    Space complexity: O(N)
    
    Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // map to keep the last index of a character encountered in string 's'
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int n = s.length();
        
        int start = 0;
        for(int end = 0; end < n; end++) {
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
            len = Math.max(len, end - start + 1);
        }
        
        return len;
    }
}
