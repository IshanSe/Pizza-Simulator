import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

class Square extends Shape {

	private int sideLengthOne;
	private int sideLengthTwo;

	public Square(int a, int b) {
		super(a, b);
		sideLengthOne = a;
		sideLengthTwo = b;
		// we explicitly call a superclass constructor
		// that takes 2 ints, as in Shape, because we
		// get a compiler error otherwise. However,
		// you should write a constructor that is able
		// to accept more info., such as the sideLength,
		// since you need this info. to draw a square.
	}

	// getSide: Add this getter method
	public int getSideLengthOne() {
		return sideLengthOne;
	}

	public int getSideLengthTwo() {
		return sideLengthTwo;
	}

	// setSide: Add this setter method
	public void setSideLengthOne(int side) {
		sideLengthOne = side;
	}

	public void setSideLengthTwo(int side) {
		sideLengthTwo = side;
	}

	public double getArea() {
		return sideLengthOne * sideLengthTwo;
	}

	public void draw(Graphics g) {
		g.fill3DRect(getX(), getY(), sideLengthOne, sideLengthTwo, false);
	}
}