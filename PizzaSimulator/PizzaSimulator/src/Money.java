import java.io.Serializable;

public class Money implements Comparable, Cloneable, Serializable
{
	private int cents;
	private int dollars;
	

	// Constructor initializes the instance variables
	public Money(int dol, int cent) {
		if(cent >= 0 && cent < 100) {
			this.cents = cent;
		}
		else if(cent < 0 || cent > 99) {
			System.out.println("invalid input for dollars or cents");
		}
		
		if(dol >= 0) {
			this.dollars = dol;
		}
		else if(dol < 0) {
			System.out.println("invalid input for dollars");
		}
	}
	// Constructor initializes the instance variables
	public Money(Money other) {
		this.cents = other.getCents();
		this.dollars = other.getDollars();
	}

	// Creates clone of Money class
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	// Compares two Money objects
	public int compareTo(Object temp)
	{
		Money other = (Money) temp;

		if(getDollars() > other.getDollars())
		{
			if (getCents() > other.getCents())
			{
				return 1;
			}
		}

		else if (getDollars() < other.getDollars())
		{
			if (getCents() < other.getCents())
			{
				return -1;
			}
		}

		return 0;
	}
	// Returns total money
	public double getMoney(){
		double retVal = getDollars() + (getCents()*0.01);
		return retVal;

	}
	// Sets the money variables
	public void setMoney(int dol, int cent) {
		this.dollars = dol;
		this.cents = cent;
	}
        // Returns cents
	public int getCents() {
		return cents;
	}
        // Sets cents based on input
	public void setCents(int cents) {
		if(cents >= 0 && cents < 100) {
			this.cents = cents;
		}
		else System.out.println("Please keep input between 0 and 99. Use setDollar method if you want to increase dollars.");
	}
        // Returns dollars
	public int getDollars() {
		return dollars;
	}
        // Sets dollars based on input
	public void setDollars(int dollars) {
		if(dollars >= 0) {
			this.dollars = dollars;
		}
		else System.out.println("invalid input for dollars");
	}
	// Adds more dollars and cents
	public void add(int addDol, int addCent) {
		this.dollars += addDol;
		this.cents += addCent;
	}
	// Adds dollars
	public void add(int addDol) {
		this.dollars += addDol;
	}
	// Adds more dollars and cents
	public void add(Money other) {
		this.dollars = other.getDollars();
		this.cents = other.getCents();
	}
	// Comapres two objects
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Money)) {
			return false;
		}
		else {
			if(other instanceof Money) {
				return ((Money) other).getDollars() == this.dollars && (((Money) other).getCents() == this.cents);
			}
		}
		return false;
		
	}
	// String representation of money
	public String toString() {
		return "$" + getDollars() + "." + getCents();
	}
}