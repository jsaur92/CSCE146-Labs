//Written by Joe Hardy
public class GroceryList {
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	
	public GroceryList() {
		this.head = new ListNode();
		this.current = this.head;
		this.previous = this.head;
	}
	
	//Set the current node to the one after the one that is currently current. (Don't move forward if the current current node does not have a link).
	public void gotoNext() {
		if (current != null && current.link != null)
			previous = current;
			current = current.link;
	}
	
	//Return the data of the current node (but not if its null).
	public GroceryItem getCurrent() {
		return current.data;
	}
	
	//Swaps the data of the current node to the data given in this parameter.
	public void setCurrent(GroceryItem data) {
		current.data = data;
	}
	
	//Make a new ListNode with the given data and add it to the end of the list.
	public void addItem(GroceryItem data) {
		
		if (this.head.data == null) {
			setCurrent(data);
		}
		else {
			ListNode newNode = new ListNode(data, null);
			ListNode end = current;
			while (end.link != null) end = end.link;
			end.link = newNode;
		}
	}
	
	//Make a new ListNode with the given data and put it after the current node. If the parameter is null or current is null, do nothing.
	public void addItemAfterCurrent(GroceryItem data) {
		ListNode newNode = new ListNode(data, current.link);
		current.link = newNode;
	}
	
	//Removes the current node from the list.
	public void removeCurrent() {
		if (head == current) {
			head = current.link;
			current = head;
		}
		else {
			previous.link = current.link;
			current = previous;
		}
	}
	
	//Print out the content of the list.
	public void showList() {
		ListNode n = head;
		while (n != null) {
			System.out.println(n.data);
			n = n.link;
		}
	}
	
	//Checks to see if a given GroceryItem is in the list.
	public boolean contains(GroceryItem data) {
		boolean contains = false;
		ListNode n = head;
		while (n != null) {
			if (n.data.equals(data)) {
				contains = true;
				break;
			}
			n = n.link;
		}
		return contains;
	}
	
	//Total sum of the groceries.
	public double totalCost() {
		double total = 0;
		ListNode n = head;
		while (n != null) {
			total += n.data.getValue();
			n = n.link;
		}
		return total;
	}
	
}

class ListNode {
	public GroceryItem data;
	public ListNode link;
	
	public ListNode() {
		this.data = null;
		this.link = null;
	}
	
	public ListNode(GroceryItem data, ListNode link) {
		this.data = data;
		this.link = link;
	}
	
}