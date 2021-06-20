import java.awt.*;

public class Pepper extends Vegetable {
	private Money cost;
	private int calories;
	private String description;

	public Pepper() {
		super(Color.green, new Money(0, 25), 5, "");
		cost = new Money(2, 99);
		cost.setDollars(0);
		cost.setCents(25);
		calories = 5;
		description = "Pepper";
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