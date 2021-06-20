
public class Ingredient implements Comparable {
	private Money cost;
	private int calories;
	private String description;

	public Ingredient(Money price, int calories, String description) {
		cost = price;
		this.calories = calories;
		this.description = description;
	}

	public Ingredient() {

	}

	public void setCost(Money m) {
		cost = m;
	}

	public Money getCost() {
		return cost;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int c) {
		calories = c;
	}

	public int compareTo(Object o) {
		if (o instanceof Ingredient) {
			return cost.compareTo(o);
		}
		return -2;
	}

	public String toString() {
		return "Description: " + this.description + " Cost: " + this.cost + "Number of calories: " + this.calories;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

}
