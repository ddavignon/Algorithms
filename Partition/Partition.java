/**
* Title: Partition.java
* Abstract: Program partions elements into two equal subsets
* Author: Dustin D'Avignon
* ID: 611
* Date: 02/23/16
**/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Partition {
	
	public static int sumPartition(ArrayList<Integer> numbers){
		
		int result = 0;
		for(int i = 0; i < numbers.size(); i++){
			result += numbers.get(i);
		}

		return result;
		
	}
	
	public static void partition(int[] startSet, int elements){
		
		//sort list and set up two partition sets
		Arrays.sort(startSet);
		ArrayList<Integer> setA = new ArrayList<>();
		ArrayList<Integer> setB = new ArrayList<>();
			
		/*
		traverse through sorted list starting at largest value
		if sum of set is less than other set add new smaller number
		*/
		for(int i = startSet.length-1; i >= 0; i--){
			if(sumPartition(setA) < sumPartition(setB)){
				setA.add(startSet[i]);
			}
			else {
				setB.add(startSet[i]);
			}
		}	
			
		if(sumPartition(setA) != sumPartition(setB))
			System.out.println("No partition");
		else {
			//print solution	
			System.out.print("Partition: ");
			for(int i = 0; i < setA.size(); i++){
				System.out.print(" " + setA.get(i));
			}
			System.out.print(" vs ");
			for(int i = 0; i < setB.size(); i++){
				System.out.print(" " + setB.get(i));
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		//get user input for set
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of input: ");
		int input = scan.nextInt();
		int[] initialSet = new int[input];
		
		//input user numbers into set array
		System.out.print("Enter " + input + " numbers: ");
		for(int i = 0; i < input; i++){
			initialSet[i] = scan.nextInt();
		}
		
		//find partition
		partition(initialSet, input);
		
	}
}