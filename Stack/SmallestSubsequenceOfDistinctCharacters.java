/*
  Time Complexity: O(N)
  Space Complexity: O(N)
  
  Problem Link: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
*/
import java.util.*;
public class Solution {
	public static String removeDuplicateLetters(String s) {
		Stack<Character> st = new Stack<>();
		boolean[] present = new boolean[26];
		int[] countOfChar = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i); 
			countOfChar[ch - 'a']++;
		}
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i); 
			int index = c - 'a';
			countOfChar[index]--;
			
			if (present[index])
				continue;
			
			while(!st.isEmpty() && c < st.peek() && countOfChar[st.peek() - 'a'] != 0){ 
            	present[st.pop() - 'a'] = false;
        	}
			
			st.push(c);
			present[index] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		//pop character from stack and build answer string from back
		while(!st.isEmpty()){
			sb.insert(0, st.pop());
		}
		return sb.toString();
	}
}

