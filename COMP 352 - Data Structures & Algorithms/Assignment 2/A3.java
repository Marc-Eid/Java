import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class A3 {

	public static void main(String[] args) throws FileNotFoundException {

		//initialize reader
		Scanner key = new Scanner(System.in);
		//create AVL tree object
		MyAVL test = new MyAVL();

		System.out.print("File or manual? ");
		String entriesMethod = key.next();


		String fileName = null;

		if(entriesMethod.equalsIgnoreCase("manual"))
		{

			//prompt the user to enter the size 
			System.out.print("Enter the number of students: ");
			int size = key.nextInt();


			//set the size value
			test.SetSIDCThreshold(size);

			//randomly generate numbers and add them to the tree with the size specified
			for(int i = 0; i < size; i++) {
				test.add(test.generate(), null);
			}


		}else { //File reading


			System.out.print("Enter the name of the file: ");
			fileName = key.next();	

			Scanner inFile = new Scanner(new FileInputStream(fileName));


			int count = 0;
			while(inFile.hasNextInt()) {
				count++;
				inFile.nextInt();
			}

			test.SetSIDCThreshold(count);

			inFile.close();
			inFile  = null;

			inFile = new Scanner(new FileInputStream(fileName));


			while (inFile.hasNextInt()) {
				try {
					test.add(inFile.nextInt(), null);;
				}catch (Exception e) {
					continue;
				}

			}

			inFile.close();

		}








		//do while loop.
		char quit = 'n';
		do {

			// prompt the user for a choice and display a list of choices
			System.out.println("1. generate new key");
			System.out.println("2. add student");
			System.out.println("3. remove student");
			System.out.println("4. view all keys sorted ");
			System.out.println("5. get the value of a key");
			System.out.println("6. get the next key");
			System.out.println("7. get the previous key");
			System.out.println("8. get the range of keys");

			System.out.print("\nwhat do you want to do: ");
			int choice = key.nextInt();

			//if else statements to execute according to choice
			if(choice == 1) {

				int gen = test.generate();
				System.out.println("the new generate and unique number is: " + gen);

			}else if(choice == 2) {
				key.nextLine();
				boolean success = false;
				while(!success) {
					try {
						int temp = test.getSize() + 1;
						test.SetSIDCThreshold(temp);
						System.out.print("enter the key and value to enter(ID Value): ");
						String entry = key.nextLine();
						test.add(Integer.parseInt(entry.split(" ")[0]) , entry.split(" ")[1]);
						success = true;
					}catch(Exception e) {}

				}


			}else if(choice == 3) {

				System.out.print("which student do you want to remove(enter ID): ");
				int toRemove = key.nextInt();
				test.remove(toRemove);

			}else if(choice == 4) {

				test.print();

			}else if(choice == 5) {

				System.out.print("Student's ID: ");
				int ID = key.nextInt();
				System.out.println(test.getValue(ID));

			}else if (choice == 6) {

				System.out.print("enter the ID for which you want to get the next ID: ");
				int ID = key.nextInt();
				System.out.printf("the next ID is %08d\n", test.nextKey(ID));

			}else if(choice == 7) {

				System.out.print("enter the ID for which you want to get the previous ID: ");
				int ID = key.nextInt();
				System.out.printf("the previous ID is %08d\n",  test.prevKey(ID));

			}else if(choice == 8) {

				System.out.print("key 1: ");
				int k1 = key.nextInt();
				System.out.print("key 2: ");
				int k2 = key.nextInt();
				System.out.printf("the number of keys between %08d and %08d is %d\n", k1, k2, test.range(k1, k2));

			}else {
				continue;
			}




			//ask the user if they want to continue or quit
			do {
				System.out.print("\ndo you want to quit? (y/n)");
				quit = key.next().charAt(0);
			}while(quit != 'n' && quit != 'y');



		}while(quit == 'n');


		;

		if(entriesMethod.equalsIgnoreCase("file")) {
			PrintWriter outFile = new PrintWriter(new FileOutputStream(fileName));
			int[] Transfer_to_file = test.allKeys();

			for(int i = 0; i < Transfer_to_file.length; i++) {
				outFile.printf("%08d\n", Transfer_to_file[i]);
			}
			outFile.close();
		}

	}
}