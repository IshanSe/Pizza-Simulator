
import java.awt.Color;

public class Vegetable extends Ingredient {
	private Color myColor;
	private Money cost;
	private int calories;
	private String description;

	public Vegetable(Color color, Money price, int calories, String description) {
		super(price, calories, description);
		myColor = color;
		cost = price;
		this.calories = calories;
		this.description = description;
	}

	public Color getMyColor() {
		return myColor;
	}

	public void setMyColor(Color color) {
		myColor = color;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

}
