import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.Timestamp;

public class Oddonacci2 {


	public static void main(String[] args) {

		//open the output file and check if successful.
		PrintWriter out = null;
		try {
		out = new PrintWriter(new FileOutputStream("SecondVersion.txt"));
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

		String a = "time it took";

		//find and print the oddonacci numbers, using the linear version, from 5 to 100 in increments of 5.
		for(int i = 5; i <= 100 ; i+=5) {
			long timestamp1 = System.currentTimeMillis();
			out.printf( "The %3dth oddonacci number: %-30.0f", i, oddonacci2(i));
			long timestamp2 = System.currentTimeMillis();
			out.printf(" %s  : %1d ms\n", a ,timestamp2-timestamp1);//we print the time it took 
			out.flush(); //we use flush to print the content to the file in each iteration, since the PrintWriter class buffers. needed more in the first version.
		}

		out.close(); //close the file


	


	}
	
	//second version 
	static double oddonacci2(int n) { //this method is a wrapper method that calls the method that actually does the computations. 
		 return oddHelp(n, 1, 1 ,1); //the nth number along with the 3 base cases are passed into this function. 

	}
	//helper method
	static double oddHelp(int n, double a , double b , double c ) {
		
		if(n == 1) //those are the base cases. 
			return a;
		else if(n == 2)
			return b;
		else if(n == 3)
			return c;
		
		else  
			return oddHelp(n-1, c, a, a+b+c); //this is tail recursion because after the return there is no more processing to do.
											// as we can see, there is only one call for each call. hence we expect a linear behavior
		

	}
	
}