/**
* Title: PrimeFactor.java
* Abstract: This program accepts user input of a number and displays the prime factors on the screen
* Author: Dustin D'Avignon
* ID: 611
* Date: 01/30/16
**/

import java.util.Scanner;


public class PrimeFactor{
    
    public static void main (String[] args) {
	//Scanner for input
	Scanner scanner = new Scanner(System.in);
	//Prompt user for input
	System.out.print("Enter a number: ");
	//get user input with scanner
	long number = scanner.nextLong();
	//beginning of line to print
	System.out.print(number + " = ");
	
	//divisor to check factorization and firstNum for proper print format	
	long div =2;
	boolean firstNum = true;
	while(number > 1){
	    //check if factor
	    if(number%div == 0){
		//print first prime factor
		if(firstNum){
		    System.out.print(div);
		    firstNum = !firstNum;
		}
		//prints all subsequent prime factors
		else
		    System.out.print(" * " + div);
		//change number to new factor that needs to be checked for prime
		number = number/div;
	    }
	    //increase divisor to find factors
	    else
		div++;
	}
	//Done with calculations
	System.out.println("\n" + "Done.");
    }
}