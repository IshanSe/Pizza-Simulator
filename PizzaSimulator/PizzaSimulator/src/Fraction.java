
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;

public class Fraction {
	// instance variables
	private int numerator;
	private int denominator;

	// constructors
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
	}

	public Fraction(int num, int den) {
		this.numerator = Math.abs(num);
		if (den != 0) {
			this.denominator = Math.abs(den);
		}
		if (num < 0 && den < 0) {
			this.numerator = Math.abs(num);
			num = Math.abs(num);
			this.denominator = Math.abs(den);
			den = Math.abs(den);
		}
	}

	public Fraction(Fraction other) {
		// set the num and denom accordingly
		numerator = other.numerator;
		denominator = other.denominator;

	}

	// checks if two instances of fraction class are true
	public boolean equals(Fraction object) {
		if (this.numerator == object.getNumerator() && this.denominator == object.getDenominator()) {
			return true;
		}
		return false;
	}

	public double decimal() {
		return (getNumerator() / getDenominator());
	}

	public int gcdReduce(int n, int d) {
		int gcd = (d == 0 ? n : gcdReduce(d, n % d));
		return gcd;
	}

	public Fraction remove(Fraction amount) {
		// TODO Auto-generated method stub
		int n, d = 0;

		if (getDenominator() == amount.getDenominator()) {
			n = (getNumerator() - amount.getNumerator());
			d = getDenominator();
			return new Fraction(n, d);
		} else {
			n = (getNumerator() * amount.getDenominator()) - (amount.getNumerator() * getDenominator());
			d = getDenominator() * amount.getDenominator();
			return new Fraction(n, d);
		}
	}

	// makes composition of fraction
	public String toString() {

		return this.numerator + "/" + this.denominator;
	}

	public double getDecimal() {
		return this.numerator / this.denominator;
	}

	protected int getNumerator() {
		return numerator;
	}

	protected int getDenominator() {
		return denominator;
	}

	protected void setNumerator(int num) {
		this.numerator = num;
	}

	protected void setDenominator(int den) {
		this.denominator = den;
	}

}
