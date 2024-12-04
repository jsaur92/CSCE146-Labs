//Written by Joe Hardy
public class GroceryItem {
	
	private String name;
	private double value;
	
	public GroceryItem() {
		setName("none");
		setValue(0);
	}
	
	public GroceryItem(String name, double value) {
		setName(name);
		setValue(value);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null) name = "none";
		this.name = name;
	}
	
	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		if (value < 0) value = 0;
		this.value = value;
	}
	
	public String toString() {
		return "Grocery Item Name: "+getName()+" Value: "+getValue();
	}
	
	public boolean equals(GroceryItem other) {
		return (getName().equals(other.getName()) && getValue() == other.getValue());
	}
	
}
