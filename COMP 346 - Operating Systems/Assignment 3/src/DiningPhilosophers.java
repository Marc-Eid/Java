import java.util.Scanner;

/**
 * Class DiningPhilosophers
 * The main starter.
 *
 * @author Serguei A. Mokhov, mokhov@cs.concordia.ca
 */
public class DiningPhilosophers
{
	/*
	 * ------------
	 * Data members
	 * ------------
	 */

	/**
	 * This default may be overridden from the command line
	 */
	public static final int DEFAULT_NUMBER_OF_PHILOSOPHERS = 4;

	public static int Number_of_Philosophers;
	/**
	 * Dining "iterations" per philosopher thread
	 * while they are socializing there
	 */
	public static final int DINING_STEPS = 10;

	/**
	 * Our shared monitor for the philosphers to consult
	 */
	public static Monitor soMonitor = null;

	/*
	 * -------
	 * Methods
	 * -------
	 */

	/**
	 * Main system starts up right here
	 */
	public static void main(String[] argv)
	{
//		Scanner key = new Scanner(System.in);

		try
		{

//			String numberOfPhilosophers;
//			do {
//
//				//prompt the user for a number
//				System.out.print("Enter the desired number of philosophers: ");
//				numberOfPhilosophers = key.nextLine();
//
//
//				//if the user doesn't enter anything, set the number to the default number
//				if(numberOfPhilosophers.equals(""))
//					Number_of_Philosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
//
//				//if the user enters anything. if its a negative number or not an integer an exception is thrown
//				//the exception prints the error message
//				else {
//					try {
//						Number_of_Philosophers = Integer.parseInt(numberOfPhilosophers);
//						if(Number_of_Philosophers < 1) throw new Exception();
//					}catch(Exception e) {
//						System.out.println("\n%\njava DiningPhilosophers " + numberOfPhilosophers);
//						System.out.println(numberOfPhilosophers + " is not a postive decimal integer.");
//						System.out.println("Usage: java DiningPhilosophers [NUMBER_OF_PHILOSOPHERS] \n%");
//					}
//				}
//
//
//			}while(Number_of_Philosophers < 1); //loop as long as the number isnt a positive integer.s

			if(argv.length == 0)
				Number_of_Philosophers = DEFAULT_NUMBER_OF_PHILOSOPHERS;
			else{
				try {
					Number_of_Philosophers = Integer.parseInt(argv[0]);
					if(Number_of_Philosophers < 1) throw new Exception();
				}catch(Exception e) {
					System.out.println("\n%\njava DiningPhilosophers " + argv[0]);
					System.out.println(argv[0] + " is not a postive decimal integer.");
					System.out.println("Usage: java DiningPhilosophers [NUMBER_OF_PHILOSOPHERS] \n%");
					System.exit(1);
				}
			}
				

			int iPhilosophers = Number_of_Philosophers;

			// Make the monitor aware of how many philosophers there are
			soMonitor = new Monitor(iPhilosophers);

			// Space for all the philosophers
			Philosopher aoPhilosophers[] = new Philosopher[iPhilosophers];


			System.out.println
			(
					iPhilosophers +
					" philosopher(s) came in for a dinner."
					);


			// Let 'em sit down
			for(int j = 0; j < iPhilosophers; j++)
			{
				aoPhilosophers[j] = new Philosopher();
				aoPhilosophers[j].start();
			}



			// Main waits for all its children to die...
			// I mean, philosophers to finish their dinner.
			for(int j = 0; j < iPhilosophers; j++)
				aoPhilosophers[j].join();

			System.out.println("All philosophers have left. System terminates normally.");
		}
		catch(InterruptedException e)
		{
			System.err.println("main():");
			reportException(e);
			System.exit(1);
		}
	} // main()

	/**
	 * Outputs exception information to STDERR
	 * @param poException Exception object to dump to STDERR
	 */
	public static void reportException(Exception poException)
	{
		System.err.println("Caught exception : " + poException.getClass().getName());
		System.err.println("Message          : " + poException.getMessage());
		System.err.println("Stack Trace      : ");
		poException.printStackTrace(System.err);
	}
}

// EOF
