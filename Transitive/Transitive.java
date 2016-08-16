/**
* Title: Transitive.java
* Abstract: implements Warshall's algortithm to display the transitive closure from an input matrix
* Author: Dustin D'Avignon
* ID: 611
* Date: 05/01/16
**/

import java.util.Scanner;
import java.lang.String;
import java.io.File;

public class Transitive {

	public static void main (String[] args){

		//get file name and input data into matrx
		System.out.print("Enter a file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();

		try{

			File file = new File(fileName);
			Scanner fileInput = new Scanner(file);
			String sizeInput;
			sizeInput = fileInput.nextLine();
			int matrixSize = Integer.parseInt(sizeInput.split(",")[0]);

			//get each line from file and print initial matrix
			System.out.println("\nInitial Data: ");
			String line;
			String[] lineArray = new String[matrixSize];
			int[][] inputMatrix = new int[matrixSize][matrixSize];
			//grabs ints from text input
			while(fileInput.hasNext()){
				for(int i = 0; i < matrixSize; i++){
					line = fileInput.nextLine();
					lineArray = line.split(",");
					for(int j = 0; j < matrixSize; j++){
						inputMatrix[i][j] = Integer.parseInt(lineArray[j]);
						System.out.print(inputMatrix[i][j] + " ");
					}
					System.out.println();
				}
			}	
			
			// Warshall's algorithm
			for(int k = 0; k < matrixSize; k++){
				for(int i = 0; i < matrixSize; i++){
					for(int j = 0; j < matrixSize; j++){
						if(inputMatrix[i][k] == 1 && inputMatrix[k][j] == 1)
							inputMatrix[i][j] = 1;
					}
				}
			}

			//Print final result
			System.out.println("\nFinal Result: ");	
			for(int i = 0; i < matrixSize; i++){
				for(int j = 0; j < matrixSize; j++){
					System.out.print(inputMatrix[i][j] + " ");
				}
				System.out.println();
			}	

		} catch (Exception e){
			System.out.println("Error " + e);
		}


	}

}
