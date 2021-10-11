/*
 Question
 --------
 For a given a string expression containing only round brackets or parentheses, check if they are balanced or not. Brackets are said to be balanced if the bracket which opens last, closes first.
 
 Example
 -------
 Expression: (()())
 Since all the opening brackets have their corresponding closing brackets, we say it is balanced and hence the output will be, 'true'.
 You need to return a boolean value indicating whether the expression is balanced or not.
 */

import java.util.Stack;

public class BalancedBrackets {
	public static boolean isBalanced(String expression) {
        char open = '(';
        char close = ')';
        
        Stack<Character> sc = new Stack<>();
        
        for(int i = 0; i < expression.length(); i++) {
            char curr = expression.charAt(i);
            if (curr == open) sc.add(curr);
            else {
                if (!sc.isEmpty()) {
                    char poppedChar = sc.pop();
                    if(poppedChar == open) continue;
                }
                else return false;
            }
        }
        return sc.size() == 0;
    }
}
