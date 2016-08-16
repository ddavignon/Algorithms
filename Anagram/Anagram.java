/**
* Title: Anagram.java
* Abstract: This program accepts user input of two words or sentences and determines if anagram
* Author: Dustin D'Avignon
* ID: 611
* Date: 02/05/16
**/

import java.util.Scanner;
import java.util.Arrays;


class Anagram {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String firstInput, secondInput = "";
	
		//get user input of words to compare
		System.out.print("Enter first word: ");
		firstInput = scan.nextLine();
		System.out.print("Enter second word: ");
		secondInput = scan.nextLine();
		
		//print results based on boolean call of anagram
		if(aGram(firstInput, secondInput))
			System.out.println("Anagram.\nDone.");
		else
			System.out.println("No anagram.\nDone.");
	}

	//boolean function to determine anagram		
	public static boolean aGram(String firstWord, String secondWord){
		
			//remove whitespace and compare length of words to avoid unnecessary comparisons
			firstWord = firstWord.replaceAll(" ", "");
			secondWord = secondWord.replaceAll(" ", "");
			if(firstWord.length() != secondWord.length())
				return false;
		
			//convert input into character array and then sort letters	
			char[] firstChar = firstWord.toCharArray();
			char[] secondChar = secondWord.toCharArray();
			Arrays.sort(firstChar);
			Arrays.sort(secondChar);
	
			//compare letters through iteration
			for(int i = 0; i < firstWord.length(); i++){
				if(firstChar[i] != secondChar[i])
					return false;
			}
			return true;
	}
	
}