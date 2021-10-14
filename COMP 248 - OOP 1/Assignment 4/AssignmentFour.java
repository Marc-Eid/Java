// -----------------------------------------------------------------------------------------------------------------------
// Assignment #4 
// Written by: Marc Eid
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
/* The purpose of this program is to write a battle game application
*/
import java.util.Scanner;
public class AssignmentFour {

	public static void main(String[] args) {
		
		//Display the welcome message
		System.out.println("[--------------------------------------]");
		System.out.println("\n[ Welcome to the Battle Game ]");
		System.out.println("\n[--------------------------------------]");

		//declare the scanner object
		Scanner keyIn = new Scanner(System.in);
		
		//declare the numCreatures variable. which will dictate the size of the array of objects of class Creature
		int numCreatures;
		
		
		//prompt the user for the number of creatures, in a do-while loop to validate input
		do
		{
		
			System.out.print("\nHow many creatures would you like to have (minimum 2, maximum 8)? ");
			numCreatures = keyIn.nextInt();
			
			if((numCreatures > 8) || (numCreatures < 2))
				System.out.println("\n*** Illegal number of creatures requested ***");
		
		}while((numCreatures > 8) || (numCreatures < 2));
		
		
		
		
		
		//create the array of objects. size is dictated by the user
		Creature[] players = new Creature[numCreatures];
		
		//ask the user to assign names for the creatures
		String junk = keyIn.nextLine();
		System.out.println();
		
		for(int i = 0 ; i < players.length ; i++)
		{
			System.out.print("What is the name of creature " + (i+1) +"? "); //prompt user for name
			String creatureName = keyIn.nextLine(); //take user input
			System.out.println();
			players[i] = new Creature(creatureName); //create the object
			
			System.out.println("Food units        Health units      Fire power units       units Name"); //print out each player's information
			System.out.println("----------        ------------      ----------             ----------");
			System.out.println(players[i]);
			System.out.println();
		}
		
		
		// creatureTurn is a variable that is randomly assigned to a number between 1 and the number of objects created
		int creatureTurn = (int) (Math.random() * (numCreatures - 1 + 1)) + 1;
		
		
		
		
		// this big do-while loop is to repeat again using another object/creature 
		do 
		{	
		
			
			
			int choice; //this variable holds the user input, choosing an option from the list
		
			
			//this do-while loop is to validate the user input (should be between 1 to 6). in addition it should repeat if the user choice was 1,2,3, or 4. this is to keep the object's turn.
			//if it is 5 or 6, it exits the loop, the number gets incremented and it gets repeated again because of the outer do-while loop
			do
			{
			//display the options when using referring to an object in the array we decrement by 1, because the array indexes start from 0. so the first player (player #1) has an index of 0.
			System.out.println("Creature #" + creatureTurn + ": " + players[creatureTurn - 1].getName() + ", what do you want to do?");
			System.out.println("\t1. How many creatures are alive?");
			System.out.println("\t2. See my status");
			System.out.println("\t3. See status of all players");
			System.out.println("\t4. Change my name");
			System.out.println("\t5. Work for some food");
			System.out.println("\t6. Attack another creature (Warning! may turn against you)");
		
			
		
			
			//prompt user for input and store it in choice
			System.out.print("\nYour Choice please > ");
			choice = keyIn.nextInt();
		
			
			//if-else statements to perform the action that the user wanted
			if(choice == 1)
			{
				System.out.println("\n\tNumber of creatures alive " + Creature.getNumStillAlive());		//the static variable is called using the class name.
				junk = keyIn.nextLine();
			}
			else if(choice == 2)
			{
				System.out.println("Food units        Health units      Fire power units       units Name");
				System.out.println("----------        ------------      ----------             ----------");
				System.out.println(players[creatureTurn - 1]);		//the toString method come to play here. we print only the player/object that called the method
			}
			else if (choice == 3)
			{
				for( int i = 0 ; i < numCreatures ; i++) 
				{
					System.out.println("Food units        Health units      Fire power units       units Name");
					System.out.println("----------        ------------      ----------             ----------");
					System.out.println(players[i]);		//we print the statuf os all the players using the for loop. 
				}
			}
			else if(choice == 4)
			{
				System.out.println("\tYour name is currently \"" + players[creatureTurn-1].getName() + "\"");
				System.out.print("\tWhat is the new name: ");
				junk = keyIn.nextLine();
				String new_name = keyIn.nextLine();		//the String new_name stores the new name of the creature. 
				players[creatureTurn - 1].setName(new_name);
			}
			else if(choice == 5)	
			{
				System.out.println();
				System.out.print("Your status before working for food: " + players[creatureTurn - 1].showStatus() + "... You earned " );
				
				players[creatureTurn - 1].earnFood();

				System.out.println();
				System.out.println("Your status after working for food: " + players[creatureTurn - 1].showStatus());
				System.out.println();
				continue;
			}
			else if(choice == 6)
			{
				int toAttack; //this variable is to store the number of the creature that the user wants to attack
				
				//do-while loop to validate user input. the number of the creature to be attacked cant be the same as the attacking creature, cant be a number of a creature that doesnt exist, 
				//and the creature to be attacked has to be alive
				do
				{
					System.out.print("\nWho do you want to attack? (enter a number from 1 to " + numCreatures + " other than yourself(" + creatureTurn + "): " );
					toAttack = keyIn.nextInt();
					if( toAttack > numCreatures )
						System.out.println("That creature does not exist. Try again...");
					else if( !players[toAttack - 1].isAlive() )
						System.out.println("That creature is already dead. Try again...");
					if(toAttack == creatureTurn)
						System.out.println("Can't attack yourself silly! Try again...");
			
				}while( (toAttack == creatureTurn) || toAttack > numCreatures || !players[toAttack - 1].isAlive());
				
				
				//attackedOrAttacking is to store a random number between 0 and 2. 
				System.out.println();
				int attackedOrAttacking = (int) (Math.random() * (2 - 0 + 1)) + 0;
			
				//if the attacking player has less than 2 fire units and the attacked creature also has less than 2 fire units. then no attack takes place
				if (players[creatureTurn - 1].getFirePowerUnits() < 2 && players[toAttack - 1].getFirePowerUnits() < 2)
				{
					System.out.println("Lucky you, the odds were that the other player attacks you, but " +  players[toAttack - 1].getName() + " doesn't have enough fire power to attack you! So is the statuts quo!!");
					System.out.println();
					continue;
				}
				//if the random number is 0 or the attacking player has less than 2 fire units, then he becomes the attacked player. else normal attack takes place.
				else if(attackedOrAttacking == 0 || players[creatureTurn - 1].getFirePowerUnits() < 2)
				{
				
					if(players[creatureTurn - 1].getFirePowerUnits() < 2)
						System.out.println("That was not a good idea ... you only had " + players[creatureTurn - 1].getFirePowerUnits() + " Fire Power units!!!");
					
					System.out.println("....... oh No!!! You are being attacked by " + players[toAttack - 1].getName() );
					
					System.out.println("Your status qou before being attacked: " + players[creatureTurn - 1].showStatus() );
					players[toAttack - 1].attacking(players[creatureTurn - 1]);
					if(players[creatureTurn - 1].isAlive())
						System.out.println("Your status qou after being attacked: " + players[creatureTurn - 1].showStatus() );
					else
						System.out.println("\n---->" + players[creatureTurn - 1].getName() + " is dead");
					System.out.println();
					
				}	
				else 
				{
					System.out.println("..... Your are attacking " + players[toAttack - 1].getName() + "!");
					System.out.println("Your status qou before attacking: " + players[creatureTurn - 1].showStatus() );
					players[creatureTurn - 1].attacking(players[toAttack - 1]);
					System.out.println("Your status qou after attacking: " + players[creatureTurn - 1].showStatus() );
					if(!players[toAttack - 1].isAlive())
						System.out.println( "\n---->" + players[toAttack - 1].getName() + " is dead");
					System.out.println();
				}
				
				//if the number of players/objects are less than 2 then we exit from the loop
				if(Creature.getNumStillAlive() < 2)
					break;
				
				continue;	
			}
		
			System.out.println();
			
			
			
			}while(choice > 6 || choice < 1 || choice == 1 || choice == 2 || choice == 3 || choice == 4);
			
			
			
			//we need to change the number to the next consecutive number so that the next player gets the chance to play too.
			// if the number becomes bigger than the number of players then number goes back to 1.
			creatureTurn++;
			if(creatureTurn > numCreatures)
				creatureTurn = 1;
			
			//if the number becomes that of a dead player, we increments again. and again, if the number becomes more than the number of players we go back to 1.
			while(!players[creatureTurn-1].isAlive())
			{
				creatureTurn++;
				if(creatureTurn > numCreatures)
					creatureTurn = 1;
			}
			
		
		}while(Creature.getNumStillAlive() > 1);
		
		
		
		
		//when only 1 player is alive we display game over message
		if(Creature.getNumStillAlive() == 1)
			System.out.println("GAME OVER!!!!!");
		System.out.println();
		
		//when game ends we display the status of the players
		for(int i =0 ; i < numCreatures ; i++)
		{
			System.out.println("Food units        Health units      Fire power units       units Name");
			System.out.println("----------        ------------      ----------             ----------");
			System.out.println(players[i]);	
			System.out.println();
		}
		
		
		//Display the closing message
		System.out.println("[-------------------------------------]");
		System.out.println("\n[ Thank you for using the Battle Game ]");
		System.out.println("\n[-------------------------------------]");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
