public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
		System.out.println("Stack using Array");

		StackUsingArray stack = new StackUsingArray(2);
		int arr[] = {5, 6, 7, 1, 9};
		
		for(int num: arr) {
			stack.push(num);
		}
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println();
		System.out.println("Stack using Linked List");
		 
		StackUsingLinkedList<Integer> stackLL = new StackUsingLinkedList<>();
		int arr2[] = {10, 11, 12, 13, 14};
		
		for(int num: arr2) {
			stackLL.push(num);
		}
		
		while (!stackLL.isEmpty()) {
			System.out.println(stackLL.pop());
		}
		
	}

}
