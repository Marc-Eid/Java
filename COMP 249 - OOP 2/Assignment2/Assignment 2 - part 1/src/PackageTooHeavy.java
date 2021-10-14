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
public class PackageTooHeavy extends PackageException{
	
	/**
	 * constructs and initializes an object of the PackageTooHeavy
	 */
	public PackageTooHeavy() {
		super("package too heavy");
	}
	
	/**
	 * constructs and initializes an object of the PackageTooHeavy
	 * @param message message to be displayed when this exception is caught
	 */
	public PackageTooHeavy(String message) {
		super(message);
	}
	
	
}
