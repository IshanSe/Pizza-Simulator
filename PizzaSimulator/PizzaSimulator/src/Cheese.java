
public class Cheese extends Ingredient {
	private Money cost;
	private int calories;
	private String description;

	public Cheese(Money price, int calories, String description) {
		super(price, calories, description);
		cost = price;
		this.calories = calories;
		this.description = description;
	}
}
