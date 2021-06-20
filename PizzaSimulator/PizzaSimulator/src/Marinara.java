
public class Marinara extends Base {
	private Money cost;
	private int calories;
	private String description;

	public Marinara() {
		super(new Money(0, 99), 15, "");
		cost = new Money(0, 99);
		cost.setDollars(0);
		cost.setCents(99);
		calories = 15;
		description = "Marinara Sauce";
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
