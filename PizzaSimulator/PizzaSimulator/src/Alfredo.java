
public class Alfredo extends Base {
	private Money cost;
	private int calories;
	private String description;

	public Alfredo() {
		super(new Money(0, 99), 30, "");
		cost = new Money(0, 99);
		cost.setDollars(0);
		cost.setCents(99);
		calories = 30;
		description = "Alfredo Sauce";
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
