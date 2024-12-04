//Written by Joe Hardy
public class DoubleDoubleLL {
	
	private Node head;
	private Node current;
	
	//Set current to current's next node.
	public void gotoNext() {
		current = current.next;
	}
	
	//Set current to current's previous node.
	public void gotoPrev() {
		current = current.prev;
	}
	
	//Set current to the head of the linked list.
	public void reset() {
		current = head;
	}
	
	//Set current to the end of the linked list.
	public void gotoEnd() {
		current = head;
		while (current.next != null)
			gotoNext();
	}
	
	//Returns true if the 'current' node is not null, false otherwise.
	public boolean hasMore() {
		return current != null;
	}
	
	//Returns the current node.
	public double getCurrent() {
		if (current != null)
			return current.data;
		else
			return -999999;
	}
	
	//Modifies current's data to this method's parameter.
	public void setCurrent(double data) {
		if (current != null)
			current.data = data;
	}
	
	public void add(double data) {
		if (head == null) {
			head = new Node(data);
		}
		else {
			Node last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node(data);
			last.next.prev = last;
		}
	}
	
	public void addAfterCurrent(double data) {
		if (current != null) {
			Node new_node = new Node(data);
			Node after = current.next;
			current.next = new_node;
			new_node.next = after;
			after.prev = new_node;
			new_node.prev = current;
		}
	}
	
	public void remove(double data) {
		Node check = head;
		while (check != null) {
			if (check.data == data) {
				
				if (check.prev != null) check.prev.next = check.next;
				if (check.next != null) check.next.prev = check.prev;
				break;
			}
			check = check.next;
		}
	}
	
	public void removeCurrent() {
		if (current != null) {
			if (head == current) {
				head = current.next;
			}
			
			if (current.prev != null) {
				current.prev.next = current.next;
			}
			if (current.next != null) {
				current.next.prev = current.prev;
			}
			
			current = current.next;
		}
	}
	
	public void print() {
		Node check = head;
		while (check != null) {
			System.out.println(check.data);
			check = check.next;
		}
	}
	
	public boolean contains(double data) {
		boolean ret = false;
		Node check = head;
		while (check != null) {
			if (check.data == data) {
				ret = true;
				break;
			}
			check = check.next;
		}
		return ret;
	}
	
	class Node {
		public double data;
		public Node next;
		public Node prev;
		
		public Node() {
			this.data = 0.0;
			this.next = null;
			this.prev = null;
		}
		
		public Node(double data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
}
