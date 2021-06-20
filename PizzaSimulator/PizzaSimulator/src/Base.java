
public class Base extends Ingredient {
	private Money cost;
	private int calories;
	private String description;

	public Base(Money price, int calories, String description) {
		super(price, calories, description);
		cost = price;
		this.calories = calories;
		this.description = description;
	}
}