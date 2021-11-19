import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.Timestamp;

public class Oddonacci1 {






	public static void main(String[] args) {

		//open the output file and check if successful.
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("FirstVersion.txt"));
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		String a = "time it took";

		//find and print the oddonacci numbers, using the exponential version, from 5 to 100 in increments of 5. 
		for(int i = 5; i <= 100 ; i+=5) {
			long timestamp1 = System.currentTimeMillis();
			out.printf( "The %3dth oddonacci number: %-30.0f", i, oddonacci1(i));
			long timestamp2 = System.currentTimeMillis();
			out.printf(" %s : %1d ms\n", a ,timestamp2-timestamp1); //we print the time it took 
			out.flush(); //we use flush to print the content to the file in each iteration, since the PrintWriter class buffers.
		}

		out.close(); //close the file





	}
	//first version. This is the exponential version of the algorithm.
	static double oddonacci1(int n) { //take a positive integer n. and outputs the nth oddonacci number

		if( n>=1 && n <=3 ) //those are the base cases. If n is between 1 and 3 inclusive, the method returns 1.
			return 1;
		else
			return oddonacci1(n-3) + oddonacci1(n-2) + oddonacci1(n-1); //this is head recursion because after the return there are still processing to do.
	}																	//each method call, call another 3 methods.



}
