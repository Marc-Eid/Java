// ----------------------------------------------------------------------------------------
// Assignment #1 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Sunday, July 18, 2021
//-----------------------------------------------------------------------------------------


package package4;
import package1.PublicTransportation;
import package4.AirCraft.ClassType;
import package4.AirCraft.MaintanenceType;

/**
 * 
 * sub-class of PublicTransportation class.
 *
 */
public class AirCraft extends PublicTransportation {
	
	enum ClassType{HELICOPTER, AIRLINE, GLIDER, BALLOON};
	enum MaintanenceType {WEEKLY, MONTHLY, YEARLY};
	
	private ClassType airCraft;
	private MaintanenceType maintanencePeriod;
	
	/**
	 * constructs and initializes AirCraft object
	 */
	public AirCraft()
	{
		//super() will be automatically called
		airCraft = ClassType.AIRLINE;
		maintanencePeriod = MaintanenceType.WEEKLY;
	}
	
	
	/**
	 * constructs and initializes AirCraft object
	 * @param price Aircraft ticket price
	 * @param stops number of stops
	 * @param planeType the type of aircraft
	 * @param maintPeriod maintancence period of the aircraft
	 */
	public AirCraft(double price , int stops, String planeType, String maintPeriod )
	{
		super(price, stops);
		airCraft = ClassType.valueOf(planeType);
		maintanencePeriod = MaintanenceType.valueOf(maintPeriod);
	}
	
	
	/**
	 * constructs and initializes a AirCraft object that is a copy of the passed object  
	 * @param other an object of type AirCraft, will be copied.
	 */
	public AirCraft(AirCraft other)
	{
		super(other.getTicketPrice(), other.getNbOfStops());
		airCraft = other.airCraft;
		maintanencePeriod = other.maintanencePeriod;
	}
	
	
	/**
	 * displays the description of the object of class AirCraft
	 */
	public String toString()
	{	
		String period = maintanencePeriod.toString();
		period = period.toLowerCase();
		
		String type = airCraft.toString();
		type = type.toLowerCase();
		
		
		return ("This Aircraft has " + getNbOfStops() + " stop(s) and costs " + getTicketPrice() +
	     "$." + " The aircraft is a " + type + " and it is maintained on a " + period + " basis."); 
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
			AirCraft otherAirCraft = (AirCraft) otherObject;
			return (getTicketPrice() == otherAirCraft.getTicketPrice() && this.getNbOfStops() == otherAirCraft.getNbOfStops() && this.airCraft == otherAirCraft.airCraft 
					&&this.maintanencePeriod == otherAirCraft.maintanencePeriod);
		}
		
	}
	
	
	
	
	
	
	
}
