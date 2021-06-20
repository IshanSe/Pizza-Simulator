
public class Goat extends Cheese {
	private Money cost;
	private int calories;
	private String description;

	public Goat() {
		super(new Money(0, 75), 70, "");
		cost = new Money(0, 75);
		cost.setDollars(0);
		cost.setCents(75);
		calories = 70;
		description = "Goat Cheese";
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
