/**
 * Class Philosopher.
 * Outlines main subrutines of our virtual philosopher.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class Philosopher extends BaseThread
{
	
	
	/**
	 * Max time an action can take (in milliseconds)
	 */
	public static final long TIME_TO_WASTE = 1000;

	/**
	 * The act of eating.
	 * - Print the fact that a given phil (their TID) has started eating.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done eating.
	 */
	public void eat()
	{
		//show thay the philospher started eating
		System.out.println("Philosopher " + getTID() + " started eating" );
		
		//give turn to someone else for a specific amount of time.
		try
		{
			Thread.yield();
			sleep((long)(Math.random() * TIME_TO_WASTE));
			Thread.yield();
		}
		catch(InterruptedException e)
		{
			System.err.println("Philosopher.eat():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
		
		//show that the philosopher finished eating
		System.out.println("Philosopher " + getTID() + " is done eating.");
	}

	/**
	 * The act of thinking.
	 * - Print the fact that a given phil (their TID) has started thinking.
	 * - yield
	 * - Then sleep() for a random interval.
	 * - yield
	 * - The print that they are done thinking.
	 */
	public void think()
	{
	
		System.out.println("Philosopher " + getTID() + " started thinking");
		Thread.yield();
		
		try {
			sleep((long)(Math.random() * TIME_TO_WASTE));
		} catch (InterruptedException e) {
			System.err.println("Philosopher.eat():");
			DiningPhilosophers.reportException(e);
			System.exit(1);
		}
		
		Thread.yield();
		System.out.println("Philosopher " + getTID() + " finished thinking");
		
	}

	/**
	 * The act of talking.
	 * - Print the fact that a given phil (their TID) has started talking.
	 * - yield
	 * - Say something brilliant at random
	 * - yield
	 * - The print that they are done talking.
	 */
	public void talk()
	{
		System.out.println("Philosopher " + getTID() + " started talking");
		Thread.yield();

		saySomething();

		Thread.yield();
		System.out.println("Philosopher " + getTID() + " finished talking");
	}

	
	/**
	 * No, this is not the act of running, just the overridden Thread.run()
	 */
	public void run()
	{
		for(int i = 0; i < DiningPhilosophers.DINING_STEPS; i++)
		{
	
			DiningPhilosophers.soMonitor.pickUp(getTID()-1);

			eat();

			DiningPhilosophers.soMonitor.putDown(getTID()-1);

			think();

			
			
			// a coin is flipped to check if the philosopher can talk or not. 
			if((int)(Math.random() * 2 + 1 ) == 1)
			{
				DiningPhilosophers.soMonitor.requestTalk(getTID()-1);
				talk();
				DiningPhilosophers.soMonitor.endTalk(getTID()-1);
			}
			Thread.yield();
		}
	} // run()

	/**
	 * Prints out a phrase from the array of phrases at random.
	 * Feel free to add your own phrases.
	 */
	public void saySomething()
	{
		String[] astrPhrases =
		{
			"Eh, it's not easy to be a philosopher: eat, think, talk, eat...",
			"You know, true is false and false is true if you think of it",
			"2 + 2 = 5 for extremely large values of 2...",
			"If thee cannot speak, thee must be silent",
			"My number is " + getTID() + ""
		};

		System.out.println
		(
			"Philosopher " + getTID() + " says: " +
			astrPhrases[(int)(Math.random() * astrPhrases.length)]
		);
	}
}

// EOF
