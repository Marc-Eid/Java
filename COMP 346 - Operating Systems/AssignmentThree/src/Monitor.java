/**
 * Class Monitor
 * To synchronize dining philosophers.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Monitor
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */
	String state[] = new String[DiningPhilosophers.Number_of_Philosophers]; /*thinking, eating, talking, hungry*/
	int numOfChopsticks; 
	int numPhilopsophers = DiningPhilosophers.Number_of_Philosophers;

	/**
	 * Constructor
	 */
	public Monitor(int piNumberOfPhilosophers)
	{
		// TODO: set appropriate number of chopsticks based on the # of philosophers
		numOfChopsticks = piNumberOfPhilosophers;
		for(int i = 0; i < state.length; i++)
			state[i] = "thinking";
	}

	/*
	 * -------------------------------
	 * User-defined monitor procedures
	 * -------------------------------
	 */

	
	/*
	 * Checks whether the chopsticks on both sides are available. if they are then the philosopher starts eating
	 * and notifies others.
	 * */
	public synchronized void test(final int piTID) {
		
		//get the philosophers numbers on the left and right
		int leftPhilosopher = Math.floorMod(piTID - 1, numPhilopsophers);
		int rightPhilosopher = Math.floorMod(piTID + 1, numPhilopsophers);

		//check that the philosophers on the right and left are not eating. 
		//if they are eating, the philosopher waits. otherwise, starts eating
		if( (!state[leftPhilosopher].equalsIgnoreCase("eating")) && 
				state[piTID].equals("hungry") && 
				(!state[rightPhilosopher].equalsIgnoreCase("eating"))){
			state[piTID] = "eating";
			notifyAll();
		}


	}



	/**
	 * Grants request (returns) to eat when both chopsticks/forks are available.
	 * Else forces the philosopher to wait()
	 * @throws InterruptedException 
	 */
	public synchronized void pickUp(final int piTID)
	{

		//set the state of that philosopher to hungry
		state[piTID] = "hungry";

		//checks whether they can eat or not.
		test(piTID);

		//while the philosophers on the right and left are eating, wait. 
		while(!state[piTID].equals("eating"))
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

	/**
	 * When a given philosopher's done eating, they put the chopstiks/forks down
	 * and let others know they are available.
	 * @throws InterruptedException 
	 */
	public synchronized void putDown(final int piTID)
	{
		//get the philosophers numbers on the left and right
		int leftPhilosopher = Math.floorMod(piTID - 1, numPhilopsophers);
		int rightPhilosopher = Math.floorMod(piTID + 1, numPhilopsophers);

		//after finishing eating set the state to thinking, instead of eating. 
		state[piTID] = "thinking";
		
		//check if the philosophers on the right and left can eat. if they can, notify them
		test(leftPhilosopher);
		test(rightPhilosopher);
	}

	/**
	 * Only one philopher at a time is allowed to philosophy
	 * (while she is not eating).
	 * @throws InterruptedException 
	 */
	public synchronized void requestTalk(final int piTID)
	{

		//while the philosopher is eating, they have to wait. i.e. they cant talk.
		while(state[piTID].equals("eating")) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//if anyone else is talking, wait.
		for(int i = 0; i < numPhilopsophers ; i++) {
			while(state[i].equals("talking"))
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		//otherwise set state to talking. i.e. talk.
		state[piTID] = "talking";


	}

	/**
	 * When one philosopher is done talking stuff, others
	 * can feel free to start talking.
	 */
	public synchronized void endTalk(final int piTID)
	{
		//set state to thinking when done talking
		state[piTID] = "thinking";
		
		//notify all threads
		notifyAll();

	}
}

// EOF
