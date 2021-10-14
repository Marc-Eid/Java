// ----------------------------------------------------------------------------------------
// Assignment #2 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Wednesday, August 04, 2021
//-----------------------------------------------------------------------------------------


/**
 * 
 * this class extends the Exception class
 *
 */
public class DuplicateSerialNumberException extends Exception{

	/**
	 * constructs and initializes an object of type DUplicateSerialNumberException
	 */
	DuplicateSerialNumberException(){
		super("Duplicate Serial Number Error.");
	}

	/**
	 * constructs and initializes an object of type DUplicateSerialNumberException
	 * @param message message to display when this exception is thrown and caught.
	 */
	DuplicateSerialNumberException(String message){
		super(message);
	}

	
}
