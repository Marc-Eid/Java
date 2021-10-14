package Shapes;

public class Shape {

	private int height =0;
	private int width = 0;
	private char pattern = '*';
	
	
	//contructors
	public Shape()
	{
	}
	
	public Shape(int h, int w) {
		this.height = h;
		this.width = w; 
	}
	
	//setters
	public void setHeight(int h)
	{
		this.height = h;
	}
	
	public void setWidth(int w)
	{
		this.width = w;
	}
	
	public void setPattern(char c)
	{
		this.pattern = c;
	}
	
	//getters
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public char getPattern() {
		return this.pattern;
	}
	
	public String toString() {
		return getClass() + " => Height: " + getHeight() + " Width: " + getWidth();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
