package Shapes;

public class Rectangle extends Shape{

	
	public Rectangle() {
		super();
	}
	
	public Rectangle(int h, int w) {
		super(h, w);
	}
	
	
	public void draw() {

		for(int i = 0; i<this.getHeight(); i++)
		{
			for(int j=0; j<this.getWidth(); j++)
			{
				System.out.print(getPattern());
			}
			System.out.println();
		}
		
	}
}
