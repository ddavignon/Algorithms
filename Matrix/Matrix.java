/**
* Title: Matrix.java
* Abstract: This program will create 2 matrices to the user specified size
* - it will then add and multiply the two matrices and print the results
* Author: Dustin D'Avignon
* ID: 611
* Date: 02/23/16
**/

import java.util.Scanner;
import java.util.Random;

public class Matrix {
	public static void main(String[] args) {
		
		//prompt user for input
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the dimension: ");
		
		//get dimension of matrix
		int input = scan.nextInt();
		
		//use 2d array to represent matrix
		int[][] firstMatrix = new int[input][input];
		int[][] secondMatrix = new int[input][input];
		
		/*
		assign random values between 1 and 100
		to first and second matrix
		*/
		Random rand = new Random();
		for(int i = 0; i < input; i++){
			for(int j = 0; j < input; j++){
				firstMatrix[i][j] = rand.nextInt(100);
				secondMatrix[i][j] = rand.nextInt(100);
			}
		}
		
		//print first matrix values
		System.out.print("First matrix (" + input + " x " + input + ")");
		for(int i = 0; i < input; i++){
			System.out.println();
			for(int j = 0; j < input; j++){
			System.out.printf("% 3d", firstMatrix[i][j]);
			}
		}
		
		//print second matrix values
		System.out.print("\nSecond matrix (" + input + " x " + input + ")");
		for(int i = 0; i < input; i++){
			System.out.println();
			for(int j = 0; j < input; j++){
			System.out.printf("% 3d", secondMatrix[i][j]);
			}
		}
		
		//print addition results
		System.out.print("\n\nAddition result: ");
		for(int i = 0; i < input; i++){
			System.out.println();
			for(int j = 0; j < input; j++){
			System.out.printf("% 4d", (firstMatrix[i][j] + secondMatrix[i][j]));
			}
		}
		
		/*
		print multiplication results using dot product
		k traverses firstMatrix left to right
		and secondMatrix top to bottom
		*/
		int sum=0; //track sum for dot product
		System.out.print("\n\nMultiplication result: ");
		for (int i = 0 ; i < input ; i++ ){
			System.out.println();
			for (int j = 0 ; j < input ; j++ ){   
				for (int k = 0 ; k < input ; k++ ){
					sum = (sum + (firstMatrix[i][k]*secondMatrix[k][j]));
				}
				System.out.printf("% 6d", sum);
				sum = 0;
			}
		}		
		System.out.println("\n\nDone.");
	}
}