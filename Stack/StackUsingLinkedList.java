/* 
 * To make all the functionalities of stack O(1) we'll insert nodes
 * at the start than at the end! (Food for thought)
*/

public class StackUsingLinkedList <T> {
	private Node<T> head;
	private int size;
	
	public StackUsingLinkedList() {
		head = null;
		size = 0;
	}
	
	// O(1) time
	public int size() {
		return size;
	}
	
	// O(1) time
	public boolean isEmpty() {
		return size == 0;
	}
	
	// O(1) time
	public void push(T elem) {
		Node<T> currNode = new Node<>(elem); 
		currNode.next = head;
		head = currNode;
		size++;
	}
	
	// O(1) time
	public T top() throws StackEmptyException {
		if (size == 0) throw new StackEmptyException();
		return head.data;
	}
	
	// O(1) time
	public T pop() throws StackEmptyException {
		if (size == 0) throw new StackEmptyException();
		Node<T> currNode = head;
		head = head.next;
		size--;
		return currNode.data;
	}
	
}
