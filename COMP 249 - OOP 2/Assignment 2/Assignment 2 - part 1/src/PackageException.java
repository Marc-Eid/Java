// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------


/**
 * 
 * a child class of the Exception class
 *
 */
public class PackageException extends Exception {

	/**
	 * constructs and initializes an object of the PackageExcetion
	 */
	public PackageException() {
		super("Package Exception");
	}

	/**
	 * constructs and initializes an object of the PackageExcetion
	 * @param message message to be displayed when this exception is caught
	 */
	public PackageException(String message) {
		super(message);
	}	

	

}
