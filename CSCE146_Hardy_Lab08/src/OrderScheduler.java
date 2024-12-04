//Written by Joe Hardy
//Comments from https://cse.sc.edu/~shephejj/csce146/Labs/Lab08FoodOrderSimulatorHeap.html
public class OrderScheduler {
	
	private MinHeap<Order> orders;
	private Order currentOrder;
	private int currentMinute;
	private int totalOrders;
	private int summedWaitingTimes;
	
	public MinHeap<Order> getOrders() {
		return orders;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public int getCurrentMinute() {
		return currentMinute;
	}

	public int getTotalOrders() {
		return totalOrders;
	}

	public int getSummedWaitingTimes() {
		return summedWaitingTimes;
	}
	
	public OrderScheduler() {
		orders = new MinHeap<Order>();
		currentOrder = null;
		currentMinute = 0;
		totalOrders = 0;
		summedWaitingTimes = 0;
	}
	
	//addOrder: This method takes in an instance of an order, and if the current order is null then the newly added order is assigned to it. Otherwise, it adds the new order to the heap of orders. In either case the total orders is increased by one.
    public void addOrder(Order order) {
    	if (currentOrder == null)
    		currentOrder = order;
    	else
    		orders.add(order);
    	totalOrders++;
    }
	
	//advanceOneMinute: This method adds one to the current minute counter, and then cooks the current order for one minute. If the order is now done, then calculate its waiting time by taking the difference from the current minute and the current order’s arrival time. This value should be added to the summed waiting times. Next replace the current order with the order on top of the heap.
    public void advanceOneMinute() {
    	currentMinute++;
    	if (currentOrder != null) {
    		currentOrder.cookForOneMinute();
    		if (currentOrder.isDone()) {
    			int waitingTime = currentMinute - currentOrder.getArrivalTime();
    			summedWaitingTimes += waitingTime;
    			currentOrder = orders.remove();
    		}
    	}
    }
	
	//isDone: This method returns true or false based on if the current order is null
    public boolean isDone() {
    	return (currentOrder == null);
    }
	
	//getAverageWaitingTime: This returns a decimal value corresponding to the division of the summed waiting times by the total orders.
    public double getAverageWaitingTime() {
    	return summedWaitingTimes / totalOrders;
    }
	
}
