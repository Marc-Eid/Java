// ----------------------------------------------------------------------------------------
// Assignment #3 - COMP 249
// Part 2
// Written by: Marc Eid
// Due Date: Thursday 19 August
//-----------------------------------------------------------------------------------------
import java.util.NoSuchElementException;


/**
 * The Class CellList.
 *
 * @author Marc Eid
 */
public class CellList {

	/** The head node of the list. */
	private CellNode head;
	
	/** The size of the list. */
	private int size = 0; //should increase every time an new node is added. and decrease if a node is removed
	
	
	/**
	 * Instantiates a new cell list.
	 */
	public CellList() {
		head = null;
	}
	
	/**
	 * Copy constructor. Instantiates a new cell list that is a copy of the passed list. 
	 *
	 * @param other the CellList to be copied.
	 */
	public CellList(CellList other) {
		if(other == null)
			throw new NullPointerException();
		if(other.head == null) {
			head = null;
			size = 0;
		}
		else {
			head = copyOf(other.head);
			this.size = other.size;
		}
	
	}
	/**
	 * Clone method that return a deep copy. 
	 */
	public CellList clone() {
		try {
			CellList copy = (CellList)super.clone();
			if(head == null) {
				copy.head = null;
				copy.size = 0;
			}	
			else {
				copy.head = copyOf(head);
				copy.size = this.size;
			}
			
			return copy;
		}
		catch(CloneNotSupportedException e) {
			return null;
		}

	
	
	}
	
	
	
	
	
	/**
	 * Adds a new CellNode the to start of the list.
	 *
	 * @param phone the CellPhone object that will be put in the new node.
	 */
	public void addToStart(CellPhone phone) {

		head = new CellNode(phone, head);
		size++;
	}
	
	/**
	 * Insert new node at specified index.
	 *
	 * @param phone the CellPhone object that will be in the new node.
	 * @param n the index of the new node. 
	 */
	public void insertAtIndex(CellPhone phone, int n) {
		CellNode temp = head;

		try {
			if( n < 0 || n >= size) 
				throw new NoSuchElementException();
			while(temp.link != null) {
				if(temp.phone.getSerialNum() == phone.getSerialNum()) {
					System.out.println("duplicate serial number\n");
					return;
				}
				temp = temp.link;
			}

		}catch(NoSuchElementException e) {
			System.exit(0);
		}
		temp = head;
		if(n == 0)
			addToStart(phone);
//		else if(n == (size-1)){
//			while(temp.link != null)
//				temp = temp.link;
//			temp.link = new CellNode(phone, null);
//		}
		else {
			for(int i = 0 ; i < n-1 ; i++)
				temp = temp.link;
			CellNode t = temp.link;
			temp.link = new CellNode(phone, t);
		}
		size++;
	}

	/**
	 * Delete at index.
	 *
	 * @param n the index of the node that will be deleted
	 */
	public void deleteAtIndex(int n) {
		CellNode temp = head;

		try {
			if( n < 0 || n >= size) 
				throw new NoSuchElementException();
		}catch(NoSuchElementException e) {
			System.exit(0);
		}
		if( n ==0 )
			head = head.link;
		if(n == (size-1)) {
			for(int i = 0 ; i < n-1 ; i++)
				temp = temp.link;
			temp.link = null;
		}
		else {
			for(int i = 0 ; i < n-1 ; i++)
				temp = temp.link;
			temp.link = temp.link.link;
		}
		size--;
	}
	
	/**
	 * Delete from start.
	 *
	 * @return true, if successful
	 */
	public boolean deleteFromStart() {
		if(head != null)
		{
			head = head.link;
			size--;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Replace at index.
	 *
	 * @param phone the phone object that will be put.
	 * @param n the index of the phone that will be replaced.
	 */
	public void replaceAtIndex(CellPhone phone, int n) {
		CellNode temp = head;

		
		if( n < 0 || n >= size) 
			return;

		while(temp.link != null) {
			if(temp.phone.getSerialNum() == phone.getSerialNum()) {
				System.out.println("duplicate serial number\n");
				return;
			}
			temp = temp.link;
		}
		temp = head;
		if(n == 0)
			temp = new CellNode(phone, temp.link); 
		else {
			for(int i = 0 ; i < n-1 ; i++)
				temp = temp.link;
			temp.link = new CellNode(phone, temp.link.link);
		}
		
	}
	
	/**
	 * Find.
	 *
	 * @param SerialNumber the serial number
	 * @return the cell node, if found. 
	 */
	public CellNode find(long SerialNumber) {
		CellNode position = head;
		while(position.link !=null) {
			 if(position.phone.getSerialNum() == SerialNumber)
				 return position;
			position = position.link;
		}
		return null;
	}
	
	/** The special count keeps track of the number of iterations took to find the phone that has the passed serial number. */
	public static int specialCount = 0;
	
	/**
	 * test whether the list contains the phone with the specified serial number.
	 *
	 * @param SerialNumber the serial number
	 * @return true, if the list contained the phone with the passed serial number. 
	 */
	public boolean contains(long SerialNumber) {
		CellNode position = head;
		specialCount = 0;
		while(position !=null) {
			
			if(position.phone.getSerialNum() == SerialNumber)
				 return true;
			position = position.link;
			specialCount++;
		}
		return false;
	}

	/**
	 * Show contents of the list pf phones.
	 */
	public void showContents( )
	{
		int count = 0;
		CellNode position = head;
		while (position != null)
		{
			System.out.print("[" + position.phone.getSerialNum() + ": " + position.phone.getBrand() + " " + position.phone.getPrice() + "$ " + 
					position.phone.getYear() + "] --->");
			count++;
			if(count % 3 == 0)
				System.out.println();
			position = position.getLink( );
		}
		if(position == null)
			System.out.println("X");
	} 
	
	
	/**
	 * Equals.
	 *
	 * @param otherObject the other object of type CellList. 
	 * @return true, if both lists have the same phones.
	 */
	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
			return false;
		else if (getClass( ) != otherObject.getClass( ))
			return false;
		else
		{
			CellList otherList = (CellList)otherObject;
			if (size!= otherList.size)
				return false;
			CellNode position = head;
			CellNode otherPosition = otherList.head;
			while (position.link != null)
			{
				if (!(position.phone.equals(otherPosition.phone)))
					return false;
				position = position.link;
				otherPosition = otherPosition.link;
			}
			return true; 
		}
	}
	
	

	/**
	 * Copy of.
	 *
	 * @param otherHead the CellNode to be copied.
	 * @return the new cell node.
	 */
	private CellNode copyOf(CellNode otherHead) {
		
		CellNode position = otherHead; //moves down other's list.
		CellNode newHead; //will point to head of the copy list.
		CellNode end = null; //positioned at end of new growing list.
		//Create first node:
		
		newHead = new CellNode(position.phone, null);
		
		end = newHead;
		
		position = position.link;
		while (position != null)
		{//copy node at position to end of new list.
			end.link =
					new CellNode(position.phone, null);
			end = end.link;
			position = position.link;
		}
		return newHead;
	}


	
	/**
	 * Gets the size of the list.
	 *
	 * @return the size of the list. 
	 */
	public int getSize() {
		return size;
	}
	
	
	
	
	
	/**
	 * The Inner Class CellNode.
	 */
	private class CellNode implements Cloneable{
	
		/** The phone. */
		private CellPhone phone;
		
		/** The link to the next node. */
		private CellNode link;
		
		/**
		 * Instantiates a new cell node.
		 */
		public CellNode() {
			phone = null;
			link = null;
		}
		
		
		/**
		 * Instantiates a new cell node.
		 *
		 * @param phone the phone
		 * @param link the link of the next phone. 
		 */
		public CellNode(CellPhone phone, CellNode link) {
			this.phone = phone;
			this.link = link;
		}
		
		/**
		 * Instantiates a new deep copy cell node.
		 *
		 * @param other the CellNode to be copied. 
		 */
		public CellNode(CellNode other) {
			phone = other.phone.clone(other.phone.getSerialNum());
			link = other.link;
		}
		
		/**
		 * Clone the passed CellNode.
		 *
		 * @return the cloned CellNode object.
		 */
		public Object clone() { //using the cloneable interface

			try {
				CellNode copy = (CellNode)super.clone();
				copy.phone = (CellPhone)phone.clone(this.phone.getSerialNum());
				return copy;
			}
			catch(CloneNotSupportedException e) {
				return null;
			}
		}
		
		/**
		 * Sets the phone.
		 *
		 * @param serialNumber the serial number
		 * @param brand the brand
		 * @param year the year
		 * @param price the price
		 */
		public void setPhone(long serialNumber, String brand, int year, double price) {
			CellPhone newOne = new CellPhone(serialNumber, brand, year, price);
			this.phone = newOne;
		}
		
		/**
		 * Sets the link.
		 *
		 * @param newLink the new link
		 */
		public void setLink(CellNode newLink) {
			this.link = newLink;
		}
		
		
		/**
		 * Gets the phone.
		 *
		 * @return the phone
		 */
		public String getPhone() {
			return phone.toString();
		}
		
		/**
		 * Gets the link.
		 *
		 * @return the link
		 */
		public CellNode getLink() {
			return link;
		}
		
		
	}
	
}
