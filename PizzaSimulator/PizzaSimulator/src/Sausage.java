
public class Sausage extends Meat {
	private Money cost;
	private int calories;
	private String description;

	public Sausage() {
		super(new Money(2, 99), 240, "");
		cost = new Money(2, 99);
		cost.setDollars(2);
		cost.setCents(99);
		calories = 240;
		description = "Sausage";
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
