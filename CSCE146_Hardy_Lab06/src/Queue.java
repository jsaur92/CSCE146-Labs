//Written by Joe Hardy
public class Queue<T> {
	
	private Node head;
	private Node tail;
	private int size;
	
	public Queue() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(T data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		}
		else {
			tail.next = new Node(data);
			tail = tail.next;
		}
		size += 1;
	}
	
	public T dequeue() {
		T ret = head.data;
		head = head.next;
		size -= 1;
		return ret;
	}
	
	public int size() {
		return size;
	}
	
	class Node {
		T data;
		Node next;
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
}
