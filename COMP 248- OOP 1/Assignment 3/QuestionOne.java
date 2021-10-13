// -----------------------------------------------------------------------------------------------------------------------
// Assignment #3 Question 1
// Written by: Marc Eid 40153034
// For COMP 248 section A - Winter 2021
// -----------------------------------------------------------------------------------------------------------------------
/* The purpose of this program is to write a java code than can randomly generate a magic square, a 3x3 matrix, whose columns, rows, and 2 diagonals 
   all have the same sum and each number occurs only once.
*/
public class QuestionOne {

	public static void main(String[] args) {
		
		//this is to print the welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf( " %34s","Welcome to the Magic Matrix Program!");
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		//declaring the 3x3 matrix
		int[][] magicMatrix = new int[3][3];
		
		
		
		//declaring these variables to store the random numbers in them 
		
		//these will fill the first row
		int x1;
		int x2;
		int x3;
		//these will fill the second row
		int x4;
		int x5;
		int x6;
		//these will fill the third row
		int x7;
		int x8;
		int x9;
		
		//generate random numbers (between 1 and 9) until each column and row have their sum equal to 15.
		/* the condition for this loop is that it keeps on repeating until it finds different numbers (no repetition) that make all the column and rows 
		   and diagonals have their sum equal to 15
		*/
		
		do
		{
			x1 = (int)( Math.random() * 9 + 1 );
			x2 = (int)( Math.random() * 9 + 1 );
			x3 = (int)( Math.random() * 9 + 1 );
			
			x4 = (int)( Math.random() * 9 + 1 );
			x5 = (int)( Math.random() * 9 + 1 );
			x6 = (int)( Math.random() * 9 + 1 );
			
			x7 = (int)( Math.random() * 9 + 1 );
			x8 = (int)( Math.random() * 9 + 1 );
			x9 = (int)( Math.random() * 9 + 1 );
			
		
			
		}
		while( (x1 + x2 + x3 != 15) || (x4 + x5 + x6 !=15) || (x7 + x8 + x9 !=15) || (x1 + x4 + x7 !=15) || (x2 + x5 + x8 !=15) || (x3 + x6 + x9 !=15) || (x1 + x5 + x9 !=15) 
				|| (x3 + x5 + x7 !=15)
				|| x1==x2 || x1==x3 || x1==x4 || x1==x5 || x1==x6 || x1==x7 || x1==x8 || x1==x9 || x2==x3 || x2==x4 || x2==x5 || x2==x6 || x2==x7 || x2==x8 || x2==x9
				|| x3==x4 || x3==x5 || x3==x6 || x3==x7 || x3==x8 || x3==x9 || x4==x5 || x4==x6 || x4==x7 || x4==x8 || x4==x9 || x5==x6 || x6==x7 || x6==x8 || x6==x9
				|| x7==x8 || x7==x9 || x8==x9);
		
		//initializing the 2-D array with the random numbers generated
		magicMatrix[0][0] = x1;
		magicMatrix[0][1] = x2;
		magicMatrix[0][2] = x3;
		
		magicMatrix[1][0] = x4;
		magicMatrix[1][1] = x5;
		magicMatrix[1][2] = x6;
		
		magicMatrix[2][0] = x7;
		magicMatrix[2][1] = x8;
		magicMatrix[2][2] = x9;
		
		//displaying the 3x3 matrix
		System.out.println("\nThe randomly generated matrix is: ");
		
		for(int row = 0 ; row < magicMatrix.length ; row++)
		{
			for(int column = 0 ; column < magicMatrix[row].length ; column++)
			{
				System.out.printf( "   %4d  "  , magicMatrix[row][column] );
				
				
			}
			System.out.println();
		
		}	
		
		//print out the closing message
		System.out.print("\nThank you for using the Magic Matrix Program!");
		

	}

}
