import java.util.Stack;

public class reverseStack {
	
	public static void revStack(Stack<Integer> input, Stack<Integer> extra) {
		// base case
        if (input.size() == 0 || input.size() == 1) return;
        
        int temp = input.pop();
        
        // Hypothesis
        revStack(input, extra);
        
        // Induction
        while (!input.isEmpty()) extra.push(input.pop());
        input.push(temp);
        while (!extra.isEmpty()) input.push(extra.pop());
        return;
	}

	public static void main(String[] args) {
		int arr[] = {5, 6, 7, 1, 9};
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> helper = new Stack<>();
		
		for(int elem: arr) {
			stack.push(elem);
		}
		
		revStack(stack, helper);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
