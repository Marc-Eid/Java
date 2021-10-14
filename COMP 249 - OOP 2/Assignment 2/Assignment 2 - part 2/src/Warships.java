// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 2
// Written by: Marc Eid 40153034
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------




/**
 * 
 * @author Marc Eid
 *
 */
public class Warships {

	//these are the attributes of the ships
	private long serialNumber;
	private String name; //use _ to separate words use replaceAll() method
	private int creationYear;
	private String ownerCountry; // use _ to separate words
	private double price;
	private int speed;
	
	
	/**
	 * constructs and initializes an object of type Warship
	 * @param serialNum the serial number of the ship
	 * @param name the name of the ship
	 * @param year the year the ship was created
	 * @param country the country that owns the ship
	 * @param price the price the ship
	 * @param speed the speed of the ship
	 */
	public Warships(long serialNum , String name, int year, String country, double price, int speed) {
		serialNumber = serialNum;
		this.name = name;
		creationYear = year;
		ownerCountry = country;
		this.price = price;
		this.speed = speed;
	}
	
	
	
	/**
	 * when invoked it replaces the space characters with an underscore
	 */
	public void normalize() { //use after every object creation to replace the space with underscore
		
		name = this.name.replaceAll(" ", "_");
		ownerCountry = this.ownerCountry.replaceAll(" " , "_");
	}
	
	/**
	 * 
	 * @return returns the serial number of the ship.
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * sets the new serial number of the ship to the passed value
	 * @param num new serial number
	 */
	public void setSerialNumber(long num) {
		serialNumber = num;
	}
	
	/**
	 * 
	 * @return returns the name of the ship
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return returns the year the ship was created
	 */
	public int getCreationYear() {
		return creationYear;
	}
	
	/**
	 * 
	 * @return returns the name of the country that owns the ship
	 */
	public String getOwnerCountry() {
		return ownerCountry;
	}
	/**
	 * 
	 * @return returns the price of the ship
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @return returns the speed of the ship
	 */
	public int getSpeed() {
		return speed;
	}
	
}
