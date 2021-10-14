// ----------------------------------------------------------------------------------------
// Assignment #3 - COMP 249
// Part 1
// Written by: Marc Eid 40153034
// Due Date: Thursday 19 August
//-----------------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class PartOne {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner key = new Scanner(System.in);
		
		System.out.println("Welcome to the file processing program, written by Marc.\n");
		//ask the user to enter the file name.
		System.out.print("Enter the name of the file that you want to process: ");
		String fileName = key.next();
		
		//initialize the input and output file. 
		Scanner inFile = new Scanner(new FileInputStream(fileName));
		PrintWriter outFile = new PrintWriter(new FileOutputStream("sub-dictionary.txt"));
		
		//initialize an ArrayList.
		ArrayList<String> dictionary = new ArrayList<>();
		
		
		
		//while the file has a word we continue looping.
		//here we do the word processing.
		//fist we will get rid of characters and words with numbers... the sorting will be done later. 
		while (inFile.hasNext()) {


			String word = inFile.next(); //read the word.
			word = word.toLowerCase();	//convert to lower case. later will be converted to upper case


			//if its a single letter and not equal to a or i then we disregard.
			if( word.length() == 1 && ( !word.equals("a") && !word.equals("i") ) ) 
				continue;
			
			if(word.equals("")) //if an empty word is picked up we diregard it.
				continue;

			//if a word has a number disregard it. expect if its mc^2.
			for(int i = 0 ; i < word.length() ; i++ ) { 

				if(word.equals("mcÂ²")) { //the word will be read like that. 
					word = "mc²"; //then we fix it to appear as we want it.
					break;
				}
				if( Character.isDigit( word.charAt(i) ) ){ //if the word has a number and is not mc^2, it wont be recorded. 
					word = null;
					break;
				}

				if( word.charAt(i) == '?' || word.charAt(i) == ':' || word.charAt(i) == '’' || word.charAt(i) == ','
						|| word.charAt(i) == '=' || word.charAt(i) == ';' || word.charAt(i) == '!' || word.charAt(i) == '.'){ // check for punctuation...and remove them.
					word = word.substring(0,i);
					break;
				}
			}


			//if the word is null we move on to read the next word
			if(word == null)
				continue;
			
			word = word.toUpperCase(); //convert the word to upper case. 
			
			if(dictionary.contains(word)) //if the word already exists we move on to the next word. 
				continue;
			
			dictionary.add(word); //fill the ArrayList unordered
			
			
		}
		
		
		//after finishing the processing; order the ArrayList.
		
		for(int i = 0 ; i < dictionary.size() ; i++) 
			for(int j = i + 1; j < dictionary.size() ; j++) {
				if( dictionary.get(i).compareTo(dictionary.get(j)) > 0) {
					
					String temp = dictionary.get(j);	
					dictionary.set(j, dictionary.get(i) );
					dictionary.set(i, temp );
					
				}
			}
			
		
		outFile.println("The document produced this sub-dictionary, which includes " + dictionary.size() + " entries.");
		
		outFile.println();
		

		//assign the first letter of the first word. 
		char firstLetter = dictionary.get(0).charAt(0);
		int i = 0;
		do{
			outFile.println();
			outFile.println(firstLetter); //print the first letter of the word.
			outFile.println("==");
			
			while(i < dictionary.size() && dictionary.get(i).charAt(0) == firstLetter ) { //while the words start with the same letter keep printing them
				outFile.println(dictionary.get(i));
		
					i++;
			}
			
			if( i< dictionary.size() && dictionary.get(i).charAt(0) != firstLetter){ //if the next word start with a different letter, print this first letter and 
				firstLetter = dictionary.get(i).charAt(0);							// then print the word....
			}
			
		}while(i < dictionary.size()); //keep repeating this process until no more words
	
		
		
		
		
		
		System.out.println("END OF PROGRAM");
		
		
		
		
		
		
		
		
		
		inFile.close();
		outFile.close();

	}	
}
