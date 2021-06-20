import java.awt.*;

public class Circle extends Shape {
	private double radius;
	private int x;
	private int y;

	/*
	 * Constructors initializes the circle class with the x, and y parameters
	 */
	public Circle(int a, int b) {
		super(a, b);
		x = a;
		y = b;
	}
	
	public Circle(int a, int b, int rad) {
		super(a, b);
		x = a;
		y = b;
		radius = rad;
	}

	/*
	 * This method returns the area of the circle
	 */
	public double getArea() {
		double area = Math.PI * (radius * radius);
		return area;
	}

	/*
	 * This method returns the radius of the circle
	 */
	public double getRadius() {
		return radius;
	}

	
	 
	public void setRadius(double input) {//This method sets the radius of the method
		radius = input;
	}

	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		int width = (int) getRadius();
		int height = (int) getRadius();
		g.drawOval(x, y, width, height);
	}
}
