//Written by Joe Hardy
public class Order implements Comparable<Order> {
	private String customer;
	private String foodOrder;
	private int cookingTime;
	private int arrivalTime;
	private int cookingTimeLeft;

	public Order() {
		setCustomer("none");
		setFoodOrder("none");
		setCookingTime(1);
		setArrivalTime(0);
		setCookingTimeLeft(1);
	}
	
	public Order(String customer, String foodOrder, int cookingTime, int arrivalTime) {
		setCustomer(customer);
		setFoodOrder(foodOrder);
		setCookingTime(cookingTime);
		setArrivalTime(arrivalTime);
		setCookingTimeLeft(cookingTime);
	}
	
	public String getCustomer() {
		return customer;
	}
	
	public void setCustomer(String customer) {
		if (customer != null)
			this.customer = customer;
		else
			this.customer = "none";
	}
	
	public String getFoodOrder() {
		return foodOrder;
	}
	
	public void setFoodOrder(String foodOrder) {
		if (foodOrder != null)
			this.foodOrder = foodOrder;
		else
			this.foodOrder = "none";
	}
	
	public int getCookingTime() {
		return cookingTime;
	}
	
	public void setCookingTime(int cookingTime) {
		if (cookingTime < 0)
			cookingTime = 1;
		this.cookingTime = cookingTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(int arrivalTime) {
		if (arrivalTime < 0)
			arrivalTime = 0;
		this.arrivalTime = arrivalTime;
	}
	
	public int getCookingTimeLeft() {
		return cookingTimeLeft;
	}
	
	public void setCookingTimeLeft(int cookingTimeLeft) {
		if (cookingTimeLeft < 0)
			cookingTimeLeft = 1;
		this.cookingTimeLeft = cookingTimeLeft;
	}
	
	public String toString() {
		return "Customer: " + getCustomer() + ", Order: " + getFoodOrder() + ", Cooking Time Left: " + getCookingTimeLeft();
	}
	
	public int compareTo(Order other) {
		return this.getCookingTime() - other.getCookingTime();
	}
	
	public void cookForOneMinute() {
		this.cookingTimeLeft--;
	}
	
	public boolean isDone() {
		return (this.cookingTimeLeft <= 0);
	}
	
}
