/**
* Title: Heap.java
* Abstract: Heap program with insert, delete max, heapify, and is heap functions
* Author: Dustin D'Avignon
* ID: 611
* Date: 04/10/2016
**/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class Heap {
	
	public static boolean isHeap(int[] heapArray, int size){
		
		// start from root until last node
		for(int i = 1; i <= (size-2)/2; i++){
			// if left child greater return false
			if(heapArray[2*i] > heapArray[i])
				return false;
			// if right child greater return false
			if(heapArray[2*i+1] > heapArray[i])
				return false;
		}
		return true;
		
	}
	
	public static void heapify(int[] heapArray, int size){
		
		//constructs heap from elements of given array
		int i,j,k,v;
		boolean heap;
		for(i=(size/2); i > 0; i--){
			k=i;
			v=heapArray[k];
			heap = false;
			while(!heap && (2*k) <= size){
				j = 2*k;
				if (j < size) // there are two children
					if(heapArray[j] < heapArray[j+1])
						j=j+1;
				if(v >= heapArray[j])
					heap = true;
				else {
					heapArray[k] = heapArray[j];
					k=j;
				}
			heapArray[k] = v;
			}
		}
	}
	
	public static void insertKey(int[] heapArray, int size, int value){
		
		//increase size and insert element into end then heapify
		heapArray[++size] = value;		
		heapify(heapArray,size);
	}
	
	public static void deleteMax(int[] heapArray, int size){
		
		//exchange root key with last key of Heap
		int temp = heapArray[1];
		heapArray[1] = heapArray[size];
		heapArray[size] = temp;
		
		//decrease size and heapify
		heapify(heapArray, --size);
			
	}
	
	public static void printHeap(int[] heapArray, int size){
		
		for(int i = 1 ; i <= size; i++)
			System.out.print(heapArray[i] + " ");
		System.out.println();
		
	}

	public static void main (String[] args){
		/*
		Get filename from user
		*/
		Scanner scan = new Scanner(System.in);
		System.out.print("Input file name: ");
		String fileName = scan.nextLine(); 
		
		/*
		Run file, throw exception if file error
		*/
		try{

			//open file, start with getting amount of nodes
			File file = new File(fileName);
			Scanner fileInput = new Scanner(file);
			int elements = Integer.parseInt(fileInput.nextLine());
			//get each line from file
			String line;
			String[] lineArray = new String[2];
			int[] heapList = new int[501];
			//grabs ints from text input
			int i=1;
			while(fileInput.hasNext()){
				line = fileInput.nextLine();
				lineArray = line.split(",");
				heapList[i++] = Integer.parseInt(lineArray[0]);			
			}
			
			/*
			 Determine if heap, if not heapify
			 */
			if(isHeap(heapList, elements))
				System.out.println("This is a heap.");
			else {
				System.out.print("This is NOT a heap.\nHeap constructed: ");
				heapify(heapList, elements);
				printHeap(heapList, elements);
			}
			
			int operation = 0;
			while(operation != 3){
				System.out.println("Select an operation:\n\t1. Insert a number\n\t2. Delete the max\n\t3. Quit");
				operation = Integer.parseInt(scan.nextLine());
				
				if(operation == 1){
					System.out.print("Enter a number: ");
					int value = Integer.parseInt(scan.nextLine());
					insertKey(heapList, elements, value);
					elements++;
				}
				
				if(operation == 2){
					deleteMax(heapList, elements);
					elements--;
				}	
				
				if (operation == 3){
					System.out.println("Bye!");
				}	
				
				if(operation == 1 || operation == 2){
					System.out.print("Updated heap: ");
					printHeap(heapList, elements);
					System.out.println();
				}
				
			}

		} catch (Exception e){
			System.out.println("Error: " + e);
		}
		
	}

}

