// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------



/**
 * 
 * a child class of the PackageExpection class
 *
 */
public class PackageNotAuthorized extends PackageException {

	/**
	 * constructs and initializes an object of the PackageNotAuthorized
	 */
	public PackageNotAuthorized() {
		 
		super("package not authorized");
	}
	
	/**
	 * constructs and initializes an object of the PackageNotAuthorized
	 * @param message message to be displayed when this exception is caught
	 */
	public PackageNotAuthorized(String message) {
		super(message);
	}
	
	
}
