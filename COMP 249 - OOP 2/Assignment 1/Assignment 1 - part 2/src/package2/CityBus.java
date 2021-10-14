// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package2;
import java.util.Arrays;

import package1.PublicTransportation;

/**
 * this is a sub-class of the PublicTransportation class and the parent class of the Tram and Metro classes.
 *
 */
public class CityBus extends PublicTransportation{
	
	//setting the attributes to private makes it more complicated to reference them in the subclasses, but it improves security (respects encapsulation). they can be accessed using the accessor methods
	private long routeNumber;
	private int beginOperationYear;
	private String lineName;
	private String[] name = new String[5];

	
	/**
	 * constructs and initializes a CityBus object. initializes all primitive data types to 0.
	 */
	public CityBus()
	{ // all these,except lineName could have been omitted since java automatically calls the super constructor and automatically initializes primitive data types to the 0 of their type 
		super();
		routeNumber = 0;
		beginOperationYear = 0;
		lineName = "N/A";
	}
	
	
	/**
	 * constructs and initializes a CityBus object
	 * @param price price of the ticket
	 * @param stops number of stops
	 * @param route route name
	 * @param year	year the bus started operating
	 * @param line  line name
	 * @param names driver name(s)
	 */
	public CityBus(double price , int stops, long route, int year, String line, String... names  )
	{
		super(price, stops); //calling the parent constructor
		routeNumber = route;
		beginOperationYear = year;
		lineName = line;
		this.name = names;
	}

	
	/**
	 * constructs and initializes a CityBus object that is a copy of the passed object  
	 * @param other an object of type CityBus, will be copied.
	 */
	public CityBus(CityBus other)
	{
		super(other.getTicketPrice(), other.getNbOfStops());
		routeNumber = other.routeNumber;
		beginOperationYear = other.beginOperationYear;
		lineName = other.lineName;
		this.name = other.name;
	}
	
	
	/**
	 * 
	 * @return route number of the bus
	 */
	public long getRouteNumber()
	{
		return routeNumber;
	}

	
	/**
	 * 
	 * @return year the bus started operating
	 */
	public int getBeginOperationYear()
	{
		return beginOperationYear;
	}
	
	
	/**
	 * 
	 * @return bus line name
	 */
	public String getLineName()
	{
		return lineName;
	}

	
	/**
	 * 
	 * @return driver name(s)
	 */
	public String[] getName()
	{
		String[] copy = Arrays.copyOf(name, name.length); //avoiding privacy leak, return a deep copy
		return copy;
	}

	
	/**
	 * 
	 * @param route new bus route number
	 */
	public void setRouteNumber(long route)
	{
		routeNumber = route;
	}
	
	
	/**
	 * 
	 * @param year begin operation year of bus to set
	 */
	public void setBeginOperationYear(int year)
	{
		beginOperationYear = year;
	}
	
	
	/**
	 * 
	 * @param line new bus line name
	 */
	public void setLineName(String line)
	{
		lineName = line;
	}
	
	
	/**
	 * 
	 * @param names name(s) of the bus driver(s) to set
	 */
	public void setName(String... names)
	{
		name = names;
	}

	
	/**
	 * 
	 * displays the description of the object of class CityBus
	 */
	public String toString()
	{// the result variable is to store the driver names. the conditions below are to add commas(,) and (and) if there is more than one driver 
		String result = "";
		String[] copy1 = getName();
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
		
		
		return ("This city bus has " + getNbOfStops() + " stops, and costs " + getTicketPrice() +
	     "$. Its route number is " + getRouteNumber() + ". It began operating in year " + getBeginOperationYear() + ", having the line name " + getLineName() + 
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

		else //we use the accessor methods to access the attributes that are in the parent class because they are set to private
		{
			CityBus otherBus = (CityBus) otherObject;
			return (getTicketPrice() == otherBus.getTicketPrice() && this.getNbOfStops() == otherBus.getNbOfStops() && routeNumber == otherBus.routeNumber
					&& beginOperationYear == otherBus.beginOperationYear && lineName.equals(otherBus.lineName) && Arrays.equals(name, otherBus.name));
		}
		
	}









}

