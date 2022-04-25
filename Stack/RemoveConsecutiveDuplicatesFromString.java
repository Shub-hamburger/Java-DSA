/*
	Time Complexity: O(N)
  	Space Complexity: O(N)
  
  	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376565
*/
import java.util.*;
public class Solution {
    public static String removeConsecutive(StringBuilder str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (st.isEmpty())
				st.push(ch);
			else if (st.peek() == ch)
				continue;
			else
				st.push(ch);
		}
		
		//pop character from stack and build answer string from back
		while(!st.isEmpty()){
			sb.insert(0, st.pop());
		}
		return sb.toString();
    }
}
