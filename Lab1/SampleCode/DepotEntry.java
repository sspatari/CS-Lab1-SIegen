public class DepotEntry
{
	private String name;
	private int    num;
	private double value;
	
	public DepotEntry(String name, int num, double value) {
		this.name = name;
		this.num = num;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public int getQuantity() {
		return num;
	}
	public double getValue() {
		return value;
	}
	public String toString() {
		if (num > 0)
			return name + ", " + num + ": " + value;
		return name + ": " + value;
	}
}
