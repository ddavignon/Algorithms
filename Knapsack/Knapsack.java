
/**
* Title: Knapsack.java
* Abstract: Program finds capacity of knapsack problem
* Author: Dustin D'Avignon
* ID: 611
* Date: 04/29/16
**/

import java.util.Scanner;
import java.lang.Math;

public class Knapsack {
	

    static void knapSack(int capacity,int itemWeight[],int itemValue[],int items){
        
        int [][]valueAmount = new int[items+1][capacity+1];
   	
	   // Build table 
        for (int i = 0; i <= items; i++){
            for (int j = 0; j <= capacity; j++){
                //set outside values to zero
                if (i==0 || j==0)
                    valueAmount[i][j] = 0;
                //if itemWeight is unde current capacity add prev
                else if (itemWeight[i-1] <= j)
                    valueAmount[i][j] = Math.max(itemValue[i-1] + valueAmount[i-1][j-itemWeight[i-1]],  valueAmount[i-1][j]);
                //carry over old value
                else
                    valueAmount[i][j] = valueAmount[i-1][j];
            }

        }


 	
 		
 		// print table
       System.out.print("\ni/j: ");
       for(int i = 0; i <= capacity; i++){
    	   System.out.print(i + "\t");
       }
       System.out.println();
 	   for(int i = 0; i <= items; i++){
 		   System.out.print(i + "  : ");
       	for(int j = 0; j <= capacity; j++){
       		System.out.print(valueAmount[i][j] + "\t");      		
       	}
       	System.out.println();
       }
       
	   // print result  
	System.out.println("\nMax value: " + valueAmount[items][capacity]);
 		   
    }

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number of items: ");
		int items = scan.nextInt();
		
		System.out.print("Enter knapsack capacity: ");
		int capacity = scan.nextInt();
		
		int[] itemWeight = new int[items];
		int[] itemValue = new int[items];

		System.out.println("Enter weights and values of " + items + " items: ");
		for(int i = 0; i < items; i++){
			System.out.print("\tItem " + (i+1) +": ");
			itemWeight[i] = scan.nextInt();
			itemValue[i] = scan.nextInt();

		}

		knapSack(capacity, itemWeight, itemValue, items);
	}

}
