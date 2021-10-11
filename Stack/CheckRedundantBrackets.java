/*
 Question
 --------
 For a given expression in the form of a string, find if there exist any redundant brackets or not. 
 It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be balanced.
 A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.
 
 Example
 -------
 Expression: (a+b)+c
 Since there are no needless brackets, hence, the output must be 'false'.
	
 Expression: ((a+b))
 The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'. 
 */

import java.util.Stack;

public class CheckRedundantBrackets {
	public static boolean checkRedundantBrackets(String expression) {
        int n = expression.length();
        if (n == 0) return false;
        
        char open = '(';
        char close = ')';
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            
            if (ch == close) {
                int count = 0;
                while (!stack.isEmpty() && stack.peek() != open) {
                    count++;
                    stack.pop();
                }
                if (count < 2) return true;
                stack.pop();
            }
            else {
                stack.push(ch);
            }
        }
        return false;
	}
}
