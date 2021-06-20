
public class Pepperoni extends Meat {
	private Money cost;
	private int calories;
	private String description;

	public Pepperoni() {
		super(new Money(1, 99), 50, "");
		cost = new Money(2, 99);
		cost.setDollars(1);
		cost.setCents(99);
		calories = 50;
		description = "Pepperoni";
	}

	@Override
	public int getCalories() {
		return calories;
	}

	@Override
	public Money getCost() {
		return cost;
	}

	public String getDescription() {
		return description;
	}
}