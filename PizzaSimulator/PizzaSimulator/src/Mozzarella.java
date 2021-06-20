
public class Mozzarella extends Cheese {
	private Money cost;
	private int calories;
	private String description;

	public Mozzarella() {
		super(new Money(0, 89), 90, "");
		cost = new Money(0, 89);
		cost.setDollars(0);
		cost.setCents(89);
		calories = 90;
		description = "Mozzarella Cheese";
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
