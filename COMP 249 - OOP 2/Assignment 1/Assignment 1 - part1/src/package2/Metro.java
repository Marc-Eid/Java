// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package2;

import java.util.Arrays;

/**
 * 
 * sub-class of CityBus class.
 *
 */
public class Metro extends CityBus{
		
	//these attributes are private because this class doesnt not have any sudbclasses
	private int numOfVehicles;
	private String cityName;
	
	
	/**
	 * constructs and initializes a Metro object. initializes all primitive data types to 0.
	 */
	public Metro()
	{
		super();
		numOfVehicles = 0;
		cityName = "N/A";
	}
	

	/**
	 * constructs and initializes a Metro object.
	 * @param price metro ticket price
	 * @param stops number of stops
	 * @param route route name
	 * @param year year the metro started operating
	 * @param line line name
	 * @param numVehicles number of vehicles the metro has
	 * @param city city name where the metro operates
	 * @param names drive name(s)
	 */
	public Metro(double price , int stops, long route, int year, String line, int numVehicles, String city,String...names)
	{
		super(price, stops, route, year, line, names);
		numOfVehicles = numVehicles;
		cityName = city;
	}
	
	
	/**
	 * constructs and initializes a Metro object that is a copy of the passed object  
	 * @param other an object of type Metro, will be copied.
	 */
	public Metro(Metro other)
	{
		super(other.ticketPrice, other.nbOfStops, other.routeNumber, other.beginOperationYear, other.lineName, other.name);
		numOfVehicles = other.numOfVehicles;
		cityName = other.cityName;
	}
	
	
	/**
	 * 
	 * @return number of vehicles the metro has
	 */
	public int getNumOfVehicles()
	{
		return numOfVehicles;
	}
	
	
	/**
	 * 
	 * @return city name of the metro
	 */
	public String getCityName()
	{
		return cityName;
	}
	
	
	/**
	 * 
	 * @param vehicles new number of vehicles
	 */
	public void setNumOfVehicles(int vehicles)
	{
		numOfVehicles = vehicles;
	}
	
	
	/**
	 * 
	 * @param city metro city name to set
	 */
	public void setCityName(String city)
	{
		cityName = city;
	}
	
	
	/**
	 * displays the description of the object of class Metro
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
		
		
		return ("This metro has " + nbOfStops + " stops, " + numOfVehicles + " vehicles, and costs " + ticketPrice + "$." +
	     " Its route number is " + routeNumber + ". It began operating in year " +beginOperationYear +", in " + cityName+ ", having the line name " + lineName + 
	      ". Finally, its driver(s) is/are: " + result);
	
	}
	
	
	/**
	 * tests whether the passed object is null, of a different class of the calling object, and finally if the two objects have the same content
	 * @param otherObject The object to compare the calling object against
	 * @return true if the given object represents an object equivalent to the calling object, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if(otherObject == null) //this only checks if the objects is null. this happens if an object is initialized to null. otherwise it doesnt serve any purpose
			return false;
		else if(this.getClass() != otherObject.getClass())
			return false;

		else
		{
			Metro otherMetro = (Metro) otherObject;
			return (ticketPrice == otherMetro.ticketPrice && this.nbOfStops == otherMetro.nbOfStops 
					&& routeNumber == otherMetro.routeNumber
					&& beginOperationYear == otherMetro.beginOperationYear && lineName.equals(otherMetro.lineName) 
					&& Arrays.equals(name, otherMetro.name) 
					&& numOfVehicles == otherMetro.numOfVehicles && cityName.equals(otherMetro.cityName));
		}
		
	}
	
	
	
	
	
	
	
}
