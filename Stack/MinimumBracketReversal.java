/*
 * Question
 * --------
 * For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to make the expression balanced. 
 * The expression will only contain curly brackets.
 * If the expression can't be balanced, return -1.
 */

import java.util.Stack;

public class MinimumBracketReversal {
	public static int countBracketReversals(String input) {
		//Your code goes here
        int n = input.length();
        int count = 0;
        
        char open = '{';
        char close = '}';
        
        char ch1;
        char ch2;
        
        Stack<Character> stack = new Stack<>();
        
        if (n == 0) return 0;
        if (n % 2 != 0) return -1;
        
        for(int i = 0; i < n; i++) {
            char ch = input.charAt(i);
            
            if (ch == open) stack.push(ch);
            else {
                if(stack.isEmpty()) stack.push(ch);
                else {
                    if (stack.peek() == open) stack.pop();
                    else stack.push(ch);
                }
            }
        }
        while (!stack.isEmpty()) {
            ch1 = stack.pop();
            ch2 = stack.pop();
            
            if (ch1 == ch2) count++;
            else if (ch1 == open && ch2 == close) count += 2;
        }
        
        return count;
	}
}
