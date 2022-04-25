/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    where 'N' is the length of the string.
	
	Problem Link: https://www.codingninjas.com/codestudio/guided-paths/data-structures-algorithms/content/118509/offering/1376553
 */
public class Solution {
	public static boolean checkValidString(String s) {
		char open = '(';
		char star = '*';
		char close = ')';
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			if (ch == close)
				count--;
			else
				count++;
			
			if (count < 0)
				return false;
		}
		if (count == 0)
			return true;
		
		count = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			int ch = s.charAt(i);
			if (ch == open)
				count--;
			else
				count++;
			
			if (count < 0)
				return false;
		}
		return true;
	}
}
