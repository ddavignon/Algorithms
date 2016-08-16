/**
* Title: CommonElements.java
* Abstract: Finds the common elements in two lists of positve integers.
* Author: Dustin D'Avignon
* ID: 611
* Date: 01/30/16
**/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.io.File;
import java.io.IOException;


public class CommonElements {

	public static void main(String[] args){
		//setup scanner to receive input
		Scanner scanner = new Scanner(System.in);
		//ask user for file
		System.out.print("Input file name: ");
		//get input from user
		String fileName = scanner.next();

		//open file, if file not found notify user
		try {
			//input file into ArrayList
			File file = new File(fileName);
			Scanner input = new Scanner(file);
			ArrayList<Integer> startList = new ArrayList<Integer>();
			int number;

			while(input.hasNext()){
				number = input.nextInt();
				startList.add(number);
			}
			
			//put common elements into a stack
			Stack<Integer> listCommon = new Stack<Integer>();
			for(int i = 0; i < startList.size(); i++){
				int j = i + 1;
				boolean match = false;
				while(j < startList.size() && match == false){
					if(startList.get(i) == startList.get(j)){
						listCommon.push(startList.get(i));
						startList.remove(i);
						startList.remove(j);
						match = true;
					} else {
						j++;
					}
				}
			}
			//print results
			System.out.print("Result: ");
			if(listCommon.isEmpty()){
				System.out.print("No common element.");
			} else {
				while(!listCommon.isEmpty()){
					System.out.print(listCommon.pop() + " ");
				}
			}
			System.out.println("\nDone.");
		} catch (IOException ioe){ 
			//notify user of error
			System.out.println("Something went wrong: " + ioe.getMessage());	
		}
	}
}