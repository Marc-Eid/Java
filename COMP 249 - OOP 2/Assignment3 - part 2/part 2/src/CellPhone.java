// ----------------------------------------------------------------------------------------
// Assignment #3 - COMP 249
// Part 2
// Written by: Marc Eid 40153034
// Due Date: Thursday 19 August
//-----------------------------------------------------------------------------------------

/**
 * The Class CellPhone.
 */
public class CellPhone implements Cloneable{

	/** The serial number of the phone. */
	private long serialNum; //no two phones have the saem serial number
	
	/** The brand. */
	private String brand; //single word
	
	/** The manufacturing year. */
	private int year;
	
	/** The price. */
	private double price;
	
	
	
	/**
	 * Instantiates a new cell phone.
	 *
	 * @param serialNumber the serial number of the phone
	 * @param brandName the brand name
	 * @param manufacturingYear the manufacturing year
	 * @param price the price
	 */
	public CellPhone(long serialNumber, String brandName, int manufacturingYear, double price) {
		serialNum = serialNumber;
		brand = brandName;
		year = manufacturingYear;
		this.price = price;
	}
	
	
	/**
	 * Copy constructor; Instantiates a new cell phone that has the same description as the passed phone, with a new serial number.
	 *
	 * @param other the phone object to be copied
	 * @param serialNumber the new serial number of the phone. 
	 */
	public CellPhone(CellPhone other, long serialNumber) {
		serialNum = serialNumber;
		brand = other.brand;
		year = other.year;
		price = other.price;
	}
	
	/**
	 * Clone method to clone a phone object. It returns a deep copy.
	 *
	 * @param serialNumber the new serial number of the clone.
	 * @return the newly created cellPhone object.
	 */
	public CellPhone clone(long serialNumber) { //simple method using copy constructor
		
		return new CellPhone(serialNumber, this.brand, this.year, this.price);
	}
	
//	public Object clone(long serialNumber) { //using the cloneable interface
//
//		try {
//			CellPhone copy = (CellPhone)super.clone();
//			copy.serialNum = serialNumber;
//			return copy;
//		}
//		catch(CloneNotSupportedException e) {
//			return null;
//		}
//	}
	
	
	/**
 * To string.
 *
 * @return the string
 */
public String toString() {
		return ("Brand: " + brand + ". Serial number: " + serialNum + ". Manufacturing year: " + year + ". Price: " + price);
	}
	
	/**
	 * Equals.
	 *
	 * @param other CellPhone object to be compared. 
	 * @return true, if the two CellPhone pjects are the same. excluding the serial number, which is unique to every obect.
	 */
	public boolean equals(CellPhone other) {
		return (this.brand.equals(other.brand) && this.year == other.year && this.price == other.price);
	}
	
	
	
	
	//mutators.
	
	/**
	 * Sets the serial num.
	 *
	 * @param num the new serial num
	 */
	public void setSerialNum(long num) {
		serialNum = num;
	}
	
	/**
	 * Sets the brand.
	 *
	 * @param name the new brand
	 */
	public void setBrand(String name){
		brand = name;
	}
	
	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	//accessors
	
	/**
	 * Gets the serial num.
	 *
	 * @return the serial num
	 */
	public long getSerialNum() {
		return serialNum;
	}
	
	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand(){
		return brand;
	}
	
	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	
	
	
	
	
	
	
	
}
