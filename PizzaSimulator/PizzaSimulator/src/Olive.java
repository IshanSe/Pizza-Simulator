import java.awt.*;

public class Olive extends Vegetable {
	private Money cost;
	private int calories;
	private String description;

	public Olive() {
		super(Color.black, new Money(0, 30), 30, "");
		cost = new Money(2, 99);
		cost.setDollars(0);
		cost.setCents(30);
		calories = 30;
		description = "Olive";
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