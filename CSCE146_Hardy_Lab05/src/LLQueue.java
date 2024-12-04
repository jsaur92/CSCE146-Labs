//Written by Joe Hardy
public class LLQueue<Type> implements QueueI<Type> {
	
	private Node head;
	private Node tail;
	
    //Enqueue: This method returns nothing and takes in some generic data that is added to the end of the queue.
	public void enqueue(Type thing) {
		if (head == null) {
			head = new Node(thing);
			tail = head;
		}
		else {
			tail.next = new Node(thing);
			tail = tail.next;
		}
	}
	
    //Dequeue: This method removes and returns the first element’s data of the queue as long as the head is not null.
	public Type dequeue() {
		Type ret = head.thing;
		head = head.next;
		return ret;
	}
	
    //Peek: Returns the first element’s data but doesn’t remove the element.
	public Type peek() {
		return head.thing;
	}
	
    //Print: Prints out the entire queue.
	public void print() {
		Node cur = head;
		while (cur != null) {
			System.out.println(cur.thing);
			cur = cur.next;
		}
	}
	
	class Node {
		Type thing;
		Node next;
		public Node(Type thing) {
			this.thing = thing;
		}
	}
	
}
