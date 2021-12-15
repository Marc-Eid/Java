import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Part2 {
	public static void main(String[] args) throws FileNotFoundException {





		//open file.
		Scanner inFile = new Scanner(new FileInputStream("test.txt"));

		//matrix to plot the lines
		int[][] matrix = new int[1000][1000];
		
		//number of cells in the matrix where the number is >= 2.
		int safePoints = 0;

		//read each line 
		while(inFile.hasNext()) {

			//read line
			String line = inFile.nextLine();
			//split string to get the numbers
			String[] splited = line.split(",|  | -> ");

			
			//parse the numbers for easier code
			int x1 = Integer.parseInt(splited[0]);
			int y1 = Integer.parseInt(splited[1]);
			int x2 = Integer.parseInt(splited[2]);
			int y2 = Integer.parseInt(splited[3]);
			
			
			
			
			
			
			

			//line is vertical
			if(x1 == x2 && y1 != y2) {
				if(y2 > y1)
					for(int i = y1 ; i <= y2  ; i++)
						matrix[x1][i]++;
				else // y1 > y2
					for(int i = y2 ; i <= y1  ; i++)
						matrix[x1][i]++;

			//horizontal line
			}else if(x1 != x2 && y1 == y2){ 
				if(x2 > x1)
					for(int i = x1 ; i <= x2  ; i++)
						matrix[i][y1]++;
				else // x1 > x2
					for(int i = x2 ; i <= x1  ; i++)
						matrix[i][y1]++;
			}else if(x1 == x2 && y1 == y2){ //xs are equal and ys are equal
				matrix[x1][y1]++;
			
			//diagonal lines
			//this code is for part 2
			}else {
				if(x1 < x2 && y1 < y2)
					for(int i = x1, j = y1; i <= x2; i++, j++)
						matrix[i][j]++;

				else if(x1 < x2 && y1 > y2)
					for(int i = x1, j = y1; i <= x2; i++, j--)
						matrix[i][j]++;

				else if(x1 > x2 && y1 > y2)
					for(int i = x1, j = y1; i >= x2; i--, j--)
						matrix[i][j]++;
				else
					for(int i = x1, j = y1; i >= x2; i--, j++)
						matrix[i][j]++;
				
			}
			

		}

		//count the number of safe points.
		for(int i = 0; i < 1000; i++)
			for(int j = 0; j < 1000; j++)
				if(matrix[i][j] >= 2)
					safePoints++;
		
		
		System.out.println(safePoints);


	}
}

	
	
	

