//Written by Joe Hardy
public class Fruit implements Comparable<Fruit> {
	private String type;
	private double weight;
	
	public Fruit() {
		setType("apple");
		setWeight(1.0);
	}
	
	public Fruit(String type, double weight) {
		setType(type);
		setWeight(weight);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		if (type != null)
			this.type = type;
		else {
			this.type = "apple";
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		if (weight > 0.0)
			this.weight = weight;
		else
			this.weight = 1.0;
	}
	
	public String toString() {
		return "Type: " + this.type + " Weight: " + this.weight;
	}
	
	//Returns an integer value based on how this fruit's weight and type compares to those of another.
	public int compareTo(Fruit other) {
		if (other != null) {
			double diff = this.getWeight() - other.getWeight();
			if ( diff == 0.0 ) {
				return this.getType().compareTo(other.getType());
			}
			else {
				if (diff > 0) return 1;
				else return -1;
			}
		}
		else {
			return -1;
		}
	}
}
