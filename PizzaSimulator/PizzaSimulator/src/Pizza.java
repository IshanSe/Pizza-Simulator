import java.awt.Color;
import java.util.Calendar;
import java.util.Random;

public class Pizza implements PizzaComparable {
	// Instance Variables
	private int calories = 0;
	private Fraction remainingPizza = new Fraction(1, 1);
	private Money cost = new Money(5, 0);
	private Shape shape;
	private ArrayList<Ingredient> ingredientList = new ArrayList<>();
	private int numIngredients;

	// Constructor for random pizza
	public Pizza() {
		// TODO: this one makes a random pizza as far as ingredients and shape & size go
		Random rand = new Random();
		// new random

		if (rand.nextInt(2) == 1) {
			shape = new Square(5, 5);
		} else {
			shape = new Circle(5, 5);
		}
		// set shape
		setShape(shape);

		Ingredient sauce;
		if (rand.nextInt(2) == 1) {
			sauce = new Marinara();
		} else {
			sauce = new Alfredo();
		}
		addIngredient(sauce);// add the sauce

		// choose between cheese by random
		Ingredient cheese;
		if (rand.nextInt(2) == 1) {
			cheese = new Goat();
		} else {
			cheese = new Mozzarella();
		}
		addIngredient(cheese); // add the cheese


		Ingredient meat;
		if (rand.nextInt(2) == 1) {
			meat = new Sausage();
		} else {
			meat = new Pepperoni();
		}
		addIngredient(meat);
		Ingredient veggies;

		// choose between veggies by random
		if (rand.nextInt(2) == 1) {
			veggies = new Olive();
		} else {
			veggies = new Pepper();
		}
		addIngredient(veggies);
	}

	public void addIngredient(Ingredient ing) {
		if (ing == null) { // null check, if null throw excp
			throw new PizzaException("Ingredient doesn't exist");
		}

		calories += ing.getCalories(); 
		cost.add(ing.getCost()); 
		ingredientList.insert(ing, numIngredients); 
		numIngredients++; 
	}

	public int getCalories() {
		return this.calories;
	}

	public Money getPrice() {
		return new Money(this.cost);
	}

	public void setShape(Shape s) {
		shape = s;
	}

	public String toString() {
		return "Pizza has a price: " + getPrice() + " and calories: " + getCalories()
				+ ", Fraction remaining: " + getRemaining();
	}

	public void eatPizza(Fraction amount) {
		Fraction rem = new Fraction(remainingPizza.remove(amount));
		remainingPizza = rem;
	}

	public Fraction getRemaining() {
		// TODO Auto-generated method stub
		return new Fraction(remainingPizza);

	}

	public double getRemainingPizza() {
		return (getRemaining().decimal());

	}

	public int compareTo(Object o) {
		if (o == null || getClass() != o.getClass()) {
			System.out.println("Illegal parameters passed.");
			System.out.println("Returning -2: ");
			return -2;
		} else {
			Pizza obj = (Pizza) o;

			return this.getPrice().compareTo(obj.getPrice());
		}
	}

	public int compareToByCalories(Object o) {
		if (o == null || getClass() != o.getClass()) {
			System.out.println("Illegal parameters passed.");
			System.out.println("Returning -2: ");
			return -2;
		} else {
			Pizza obj = (Pizza) o;

			int thisCal = this.getCalories();
			int thatCal = obj.getCalories();

			if (thisCal < thatCal)
				return -1;
			else if (thisCal > thatCal)
				return 1;
			else
				return 0;
		}
	}

	public int compareToBySize(Object o) {
		if (o == null || getClass() != o.getClass()) {
			System.out.println("Illegal parameters passed.");
			System.out.println("Returning -2: ");
			return -2;
		} else {
			Pizza obj = (Pizza) o;

			Fraction ThisSize = this.getRemaining();
			Fraction ThatSize = obj.getRemaining();

			return -1;
		}
	}
}