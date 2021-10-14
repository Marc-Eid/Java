package Shapes;

public class Triangle extends Shape{

	private int degree = 90;
	
	
	public Triangle() {
		super();
	}
	
	public Triangle(int h, int w) {
		super(h, w);
	}
	
	
	
	
	public String toString() {
			return getClass() + " => Height: " + getHeight() + " Width: " + getWidth() + " Angle: " + degree + " degrees.";
	}

	
	
	public void draw() {

		
		for (int i = 0; i < getHeight(); i++) {
			for (int k = i; k < getHeight(); k++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	
	
	
	
	
}
