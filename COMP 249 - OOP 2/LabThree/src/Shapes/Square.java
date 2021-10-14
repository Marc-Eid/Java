package Shapes;

public class Square extends Shape{

	
	public Square() {
		super();
	}
	
	public Square(int h, int w) {
		super(h, w);
	}
	
	
	
	
	
	
	
	public void setHeight(int h) {
		this.setHeight(h);
		this.setWidth(h);
	}
	
	public void setWidth(int w) {
		this.setWidth(w);
		this.setHeight(w);
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
