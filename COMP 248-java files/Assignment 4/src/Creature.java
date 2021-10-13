import java.util.Date;
public class Creature {

	private static final int FOOD2HEATH = 6;     //the first three variables are static meaning they belong to the class only and they are not instance variables.
	private static final int HEALTH2POWER = 4;   
	private static int numStillAlive = 0;
	//the following variables are instance variables and each object will have a copy of them.
	//the dateCreated and dateDied are variables of the Date class (similar to String or Scanner.)
	private String name;		//the name variable is the name given to each object of class Creature.
	private int foodUnits;		//this variable holds the food units of each Creature
	private int healthUnits;	//this variable holds the health units of each Creature
	private int firePowerUnits;	//this variable holds the fire power units of each Creature
	private Date dateCreated; 	//this variable holds the date each object was created
	private Date dateDied;		//this variable holds the date of death of each creature
	
	
	
	
	//this is the constructor method, that creates an object of class Creature and stores the name passed as a parameter to the instance variable name.
	public Creature(String name)
	{
		this.name = name;
		numStillAlive++;
		foodUnits = (int) (Math.random() * (12 - 1 + 1)) + 1;
		healthUnits = (int) (Math.random() * (7 - 1 + 1)) + 1;
		firePowerUnits = (int) (Math.random() * (9 - 1 + 1)) + 1;
		normalizeUnits();
		dateCreated = new Date();
		dateDied = null;
	}
	
	//mutator method to change the name variable
	public void setName(String newName)
	{
		this.name = newName;
	}
	//mutator method to change the health units of objects
	public void setHealthUnit(int n)
	{
		this.healthUnits = n;
	}
	//mutator method to change the food units of objects
	public void setFoodUnit(int n) 
	{
		this.foodUnits = n;
	}
	//mutator method to reduce the fire power units of objects
	public void reduceFirePowerUnits(int n)
	{
		this.firePowerUnits -= n;
	}
	//accessor method, that returns the name of objects
	public String getName()
	{
		return name;
	}
	//accessor method, that returns the number of food units of objects
	public int getFoodUnits()
	{
		return foodUnits;
	}
	//accessor method, that returns the number of health units of objects
	public int getHealthUnits()
	{
		return healthUnits;
	}
	//accessor method, that returns the number of fire power units of objects
	public int getFirePowerUnits()
	{
		return firePowerUnits;
	}
	//accessor method, that returns the date when objects are created
	public Date getDateCreated()
	{
		return dateCreated; // this object is in an immutable class so no need to return a copy
	}
	//accessor method, that returns the date when objects die
	public Date getDateDied()
	{
		return dateDied;
	}
	//static method that can be called using the class name, since it doest belong to any object specifically, it simply counts the number of objects "alive"
	public static int getNumStillAlive()
	{
		return numStillAlive;
	}
	//returns true or false 
	public boolean isAlive()
	{
		return (dateDied == null);
	}
	//this method increases the number of food units of the object that called it by a random number from 0 to 15. it also calculates the number of food units earned.
	public void earnFood()
	{
		int foodUnitsEarned = foodUnits;		//the foodUnitsEarned stores the food units before it gets incremented
		foodUnits += (int) (Math.random() * (15 - 0 + 1)) + 0; //food units gets incremented
		foodUnitsEarned = Math.abs(foodUnitsEarned - foodUnits); //calculated the food units earned before the normalization takes place
		System.out.println(foodUnitsEarned + " food units.");  //print the foodUnits gained. 
		normalizeUnits();
	}
	//method that increases the units of the calling object and decreases the units of the passed object. it also check if the attacked object has 0 food and health units, 
	//if so it decreases the number of objects and it also initializes the dateDied with the current date  
	public void attacking(Creature player)
	{
		//these are the foodUnits and the healthUnits on the left are those of the calling object
		foodUnits += Math.ceil( player.foodUnits * 0.5 );
		healthUnits += Math.ceil( player.healthUnits * 0.5 );
		
		firePowerUnits -= 2;
		
		player.foodUnits -= Math.ceil( player.foodUnits * 0.5 );
		player.healthUnits -= Math.ceil( player.healthUnits * 0.5 );
		normalizeUnits();
		
		if( player.healthFoodUnitsZero())
			numStillAlive--;
	}
	// return true or false based on whether the object has 0 health and food units or not. if so it inializes the dateDied
	public boolean healthFoodUnitsZero()
	{
			
		if (( (healthUnits == 0) && (foodUnits == 0) ) && (dateDied == null))
			died();
		
		return ( (healthUnits == 0) && (foodUnits == 0) );
	}
	//when called it initializes the dateDied
	private void died()
	{
		dateDied = new Date();
	}
	//this method overrides the built-in  toString method, so when we call the Sysout it prints in the new customized way 
	public String toString()
	{
		String timeCreated = "Date Create: " + dateCreated;
		String timeDied;
		if(dateDied == null)
			timeDied= "Date Died: is Still alive";
		else
			timeDied = "Date Died: " + dateDied;
		
		return String.format("%-16d  %-16d  %-22d %-16s \n%s \n%s",  foodUnits , healthUnits, firePowerUnits, name, timeCreated, timeDied); //this is to format the output.
		
		
	
	}
	//this method prints the numbers in each of the variables
	public String showStatus()
	{
		return ("\"" + foodUnits + " food units, " + healthUnits + " health units, " + firePowerUnits + " fire power units\"");
	}
	//this method normalizes the units. each 6 food units are cnverted into 1 health unit. each 4 health units are converted into 1 fire power unit.
	// food and health units cannot be equal to 0, else the object is dead.
	private void normalizeUnits()
	{
		int x = (foodUnits / FOOD2HEATH);
		healthUnits += x;
		foodUnits -= x * FOOD2HEATH;
		
		int y = (healthUnits / HEALTH2POWER);
		
		if(foodUnits == 0)
		{	
			if( (y == 0) || (y == 1) )
				return;
			else
			{
				firePowerUnits += (y - 1) ; 
				healthUnits -= (y-1) * HEALTH2POWER;
			}
		}
		
		else
		{
			firePowerUnits += y;
			healthUnits -= y * HEALTH2POWER;
		}
		
	}
	


	
	
	
	
}
