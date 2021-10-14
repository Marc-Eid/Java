// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 1
// Written by: Marc Eid
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package2;

import java.util.Arrays;

/**
 * sub-class of the CityBus class.
 *
 */
public class Tram extends CityBus {
	
	//this attribute is private because this class does not have any subclasses
	private int maxSpeed;
	
	
	/**
	 * constructs and initializes a Tram object. initializes all primitive data types to 0.
	 */
	public Tram()
	{
		super();
		maxSpeed = 0;
	}
	
	
	/**
	 * constructs and initializes a Tram object.
	 * @param price tram ticket price
	 * @param stops number of stops
	 * @param route route name
	 * @param year year the tram started operating
	 * @param line line name
	 * @param speed maximum speed of the tram
	 * @param names driver name(s)
	 */
	public Tram(double price , int stops, long route, int year, String line, int speed, String... names)
	{
		super(price, stops, route, year, line, names); //parent constructor
		maxSpeed = speed;
	}
	
	
	/**
	 * constructs and initializes a Tram object that is a copy of the passed object  
	 * @param other an object of type Tram, will be copied.
	 */
	public Tram(Tram other)
	{
		super(other.ticketPrice, other.nbOfStops, other.routeNumber, other.beginOperationYear, other.lineName, other.name);
		maxSpeed = other.maxSpeed;
	}
	
	
	/**
	 * 
	 * @return the maximum speed of the tram
	 */
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
	
	/**
	 * 
	 * @param speed set the maximum speed of the tram
	 */
	public void setMaxSpeed(int speed)
	{
		maxSpeed = speed;
	}
	
	
	/**
	 * displays the description of the object of class Tram
	 */
	public String toString()
	{
		String result = "";
		String[] copy1 = name;
		for(int i = 0; i < copy1.length; i++)
		{
			if(copy1.length > 1)
			{
				if(i == copy1.length - 2  )
					result += copy1[i] + ", and ";
				
				else if(i == copy1.length-1)
					result += copy1[i] + ".";
					else
						result += " " + copy1[i] + ", ";
			}	
			
			else
				result =copy1[i] + ".";
		}
		
		
		return ("This tram has " + nbOfStops + " stops, and costs " + ticketPrice + "$. Its maximum speed is " + maxSpeed + "km/h." +
	     " Its route number is " + routeNumber + ". It began operating in year " + beginOperationYear + ", having the line name " + lineName + 
	      ". Finally, its driver(s) is/are: " + result);
				
	}
	
	
	/**
	 * tests whether the passed object is null, of a different class of the calling object, and finally if the two objects have the same content
	 * @param otherObject The object to compare the calling object against
	 * @return true if the given object represents an object equivalent to the calling object, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if(otherObject == null || this == null) //this only checks if the objects is null. this happens if an object is initialized to null. otherwise it doesnt serve any purpose
			return false;
		else if(this.getClass() != otherObject.getClass())
			return false;

		else
		{
			Tram otherTram = (Tram) otherObject;
			return (ticketPrice == otherTram.ticketPrice && this.nbOfStops == otherTram.nbOfStops && routeNumber == otherTram.routeNumber
					&& beginOperationYear == otherTram.beginOperationYear && lineName.equals( otherTram.lineName ) 
					&& Arrays.equals(name, otherTram.name) && maxSpeed == otherTram.maxSpeed);
		}
		
	}
	
	
	
	
}