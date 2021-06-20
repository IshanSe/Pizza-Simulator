import java.util.Scanner;

/**
 * PizzaManager Skeleton File CSS 162, Final Project
 * 
 * This class is a starting point for your final project and is incomplete. Note
 * that if there are any inconsistencies between this skeleton and the
 * assignment description, the assignment description controls.
 * 
 * Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
	/*
	 * TODO: Data definitions here.
	 *
	 */
	ArrayList<Pizza> list = new ArrayList<>();
	private int numOfPizzas = 0;

	/**
	 * The console interface is defined in the start method You can exit or extend
	 * the code below to accomplish all of the outcomes defined in the homework
	 * document
	 */
	public void start() {

		Scanner foo = new Scanner(System.in);

		while (true) {
			displayAllPizzas();
			displayInstructions();
			char selection = foo.next().charAt(0);

			// foo.nextChar() doesn't exist, so now what?

			switch (selection) {
			case 'A':
			case 'a':
				System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
				// todo:
				addRandomPizza();
				break;
			case 'H':
			case 'h':
				System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
				// todo:
				for (int i = 0; i < 99; i++) {
					addRandomPizza();
				}
				break;
			case 'E':
			case 'e':
				System.out.println("Eating a fraction of a pizza. How much? (a/b)");
				// todo:pizza eating code here
				eatSomePizza();
				break;
			case 'P':
			case 'p':
				System.out.println("Sorting pizzas by (P)rice");
				// todo:
				SortThePrice();
				break;
			case 'S':
			case 's':
				System.out.println("Sorting pizzas by (S)ize");
				// todo:
				SortTheSize();
				break;
			case 'C':
			case 'c':
				System.out.println("Sorting pizzas by (C)alories");
				SortTheCalories();
				break;
			case 'B':
			case 'b':
				System.out.println(
						"(B)inary search over pizzas by calories(int).  Sorting first.  What calorie count are you looking for?");
				// todo:
				int input = foo.nextInt();
				binarySearch(input);
			case 'Q':
			case 'q':
				System.out.println("(Q)uitting!");
				// todo:
				System.exit(0);
				// break;
			default:
				System.out.println("Unrecognized input - try again");
			}
		}

	}

	private void eatSomePizza() {
		// scanner object
		Scanner in = new Scanner(System.in);

		// prompt user input
		System.out.println("Eating a fraction of a pizza. How much? (a/b)");
		String fraction = in.next(); // catch user input as string

		// ask what index they want to eat
		System.out.println("At which index?");
		int index = in.nextInt(); // catch next input int

		// user parse int to get numerator and denominator from string and make fraction
		String[] splitNum = fraction.split("/");
		int n = Integer.parseInt(splitNum[0]);
		int d = Integer.parseInt(splitNum[1]);

		Pizza temp = null;

		// try-catch
		try {
			// set pizza temp to the objectat index specified
			temp = (Pizza) list.objectAt(index);

			// remove fraction that was specified by user
			temp.eatPizza(new Fraction(n, d));
			System.out.println("Eat " + fraction + " of the pizza.");
			// print action

			if (temp.getRemaining().getNumerator() == 0) {
				// if the remaining num is 0, remove the pizza from list
				System.out.println("Pizza is all gone!");
				list.remove(index);
				numOfPizzas--;
			} else {
				System.out.println("The remaining fraction of pizza is " + temp.getRemaining());
				// print the remaining fraction
				System.out.println();
			}

		} catch (PizzaException e) { // if didn't work
			throw new PizzaException();
			// throw exception error and break
		}
	}

	private void addRandomPizza() {
		// new random pizza
		Pizza pizza = new Pizza();
		// add it to the pizzalist
		list.insert(pizza, numOfPizzas);
		// increment numpizzas
		numOfPizzas++;
		System.out.println(pizza.toString());
	}

	private void displayAllPizzas() {
		System.out.println(list.toString());
	}

	private void SortThePrice() {
		PriceAlgorithm(0, list.size() - 1);
		System.out.println(list.toString());
	}

	/*
	 * second part of the recursive quicksort.
	 *
	 * @param double, double
	 */
	private void PriceAlgorithm(double start, double end) {

		double pivot = searchMiddlePrice(start, end); // pick a pivot using a getMiddle()

		// check the relationship between start and pivot
		if (start < pivot - 1) {
			// quicksort
			PriceAlgorithm(start, pivot - 1);
		}

		if (end > pivot) {
			// quicksort
			PriceAlgorithm(pivot, end);
		}

	}

	public double searchMiddlePrice(double low, double high) {
		// find the middle of the array
		double middle = ((Pizza) list.objectAt((int) low)).getPrice().getMoney(), // get the cost and get the Money obj that is equivalent
				first = low, last = high;

		// check cases
		while (first <= last) {

			// check another case
			while (((Pizza) list.objectAt((int) first)).getPrice().getMoney() < middle) {
				first++; 
			}

			// check another case
			while (((Pizza) list.objectAt((int) last)).getPrice().getMoney() > middle) {
				last--; 
			}

			// check another case
			if (first <= last) {
				list.swap((int) first, (int) last);
				// swap in the pizzalist

				first++; 
				last--; 
			}
		}
		return first;
	}

	protected void SortTheSize() {
		SizeAlgorithm(0, list.size() - 1);
		System.out.println(list.toString());
	}

	
	public void SizeAlgorithm(double low, double high) {
		// choose middle pivot
		double middle = SearchMiddleSize(low, high);

		if (low < middle - 1) {
			// recursive call
			SizeAlgorithm(low, middle - 1);
		}
		if (high > middle) { 
			// recursive call
			SizeAlgorithm(middle, high);
		}
	}

	public double SearchMiddleSize(double low, double high) {
		double middle = ((Pizza) list.objectAt((int) low)).getRemainingPizza(), first = low, last = high;


		// check case
		while (first <= last) {

			while (((Pizza) list.objectAt((int) first)).getRemainingPizza() < middle) {
				first++;
				
			}

			// check case
			while (((Pizza) list.objectAt((int) last)).getRemainingPizza() > middle) {
				last--;
				// decrement last
			}
			if (first <= last) {
				// check case
				list.swap((int) first, (int) last);

				// swap objects in pizzalist
				first++;
				last--;
			}
		}
		return first;

	}

	public double SearchMiddleCalorie(double low, double high) {
		double middle = ((Pizza) list.objectAt((int) low)).getCalories(), start = low, end = high;
		// initialize start and end

		// check relationships
		while (start <= end) {
			while (((Pizza) list.objectAt((int) start)).getCalories() < middle - 1) {
				start++;
			}

			// check relationships
			while (((Pizza) list.objectAt((int) end)).getCalories() > middle) {
				end--;
			}
			// check relationship
			if (start <= end) {
				list.swap((int) start, (int) end);

				// swap pizzalist objects
				start++;
				end--;
			}
		}
		return start; // return the starting point
	}

	public void CalorieAlgorithm(double low, double high) {
		// pick pivot using the other method
		double middle = SearchMiddleCalorie(low, high);

		// check case
		if (low < middle - 1) {
			CalorieAlgorithm(low, middle - 1);
		}

		// check case
		if (high > middle) {
			CalorieAlgorithm(middle, high);
		}
	}

	protected void SortTheCalories() {
		CalorieAlgorithm(0, list.size() - 1);
		System.out.println(list.toString());
		// call other method
	}

	private int binarySearch(int cals) {
		SortTheCalories(); // call quicksort to sort array first

		int low = 0;
		int hi = list.size() - 1;

		int middle;

		// check relationship
		while (low <= hi) {
			middle = (low + hi) / 2;
			// check relationships
			if (cals < (((Pizza) list.objectAt(middle)).getCalories())) {
				hi = (middle - 1); // reset hi
			}

			// check relationships
			else if (cals == (((Pizza) list.objectAt(middle)).getCalories())) {
				return middle;
				// return the middle if equal
			}

			// check relationships
			else if (cals > (((Pizza) list.objectAt(middle)).getCalories())) {
				// reset low
				low = (middle + 1);
			}
		}
		throw new PizzaException("Sorry, we don't have a pizza with " + cals + " many calories!");

	}

	/**
	 * No need to edit functions below this line, unless extending the menu or
	 * changing the instructions
	 */
	private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

	private void displayInstructions() {
		System.out.println(instructions);
	}

	/*
	 * Notice the one-line main function.
	 */
	public static void main(String[] args) {
		new PizzaManager().start();
	}
}