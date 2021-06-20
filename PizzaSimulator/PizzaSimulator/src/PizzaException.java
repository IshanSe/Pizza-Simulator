
public class PizzaException extends RuntimeException {

	/*
	 * passes the string to super constructor
	 *
	 * @param String
	 */
	public PizzaException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/*
	 * no-arg constructor
	 */
	public PizzaException() {
		super("Error");
		// uses super constructor with this string
	}
}