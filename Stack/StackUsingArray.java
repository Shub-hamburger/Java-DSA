
public class StackUsingArray {
	private int data[];
	private int topIndex;
	
	// Default constructor
	public StackUsingArray() {
		data = new int[10];
		topIndex = -1;
	}
	
	// Parameterized constructor
	public StackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}
	
	// Double the stack capacity
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2 * temp.length];
		
		for(int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
	}
	
	// O(1) time
	public int size() {
		return topIndex + 1;
	}
	
	// O(1) time
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	// O(1) time
	public void push(int elem) {
		// If stack is full
		if (topIndex == data.length - 1) doubleCapacity();
		data[++topIndex] = elem;
	}
	
	// O(1) time
	public int top() throws StackEmptyException {
		// If stack is empty
		if (topIndex == -1) throw new StackEmptyException();
		return data[topIndex];
	}
	
	// O(1) time
	public int pop() throws StackEmptyException {
		// If stack is empty
		if (topIndex == -1) throw new StackEmptyException();
		int temp = data[topIndex];
		topIndex--;
		return temp;
	}
}
