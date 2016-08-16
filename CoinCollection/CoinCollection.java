/**
* Title: CoinCollection.java
* Abstract: max number of coins to collect
* Author: Dustin D'Avignon
* ID: 611
* Date: 04/28/16
**/

import java.util.Scanner;
import java.io.File;
import java.lang.Math;

public class CoinCollection {

    static void collectionCoin(int coinCell[][],int n, int m){
        
        int [][]valueAmount = new int[n+1][m+1]; //F(i,j)

	   // Build table 
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                //set outside values to zero
                if (i==0 || j==0)
                    valueAmount[i][j] = 0;
                else if (i > 0 || j > 0)
                	valueAmount[i][j] = Math.max(valueAmount[i-1][j]+ coinCell[i-1][j-1],valueAmount[i][j-1] + coinCell[i-1][j-1]);
            }

        }

        System.out.println("Max coins: " + valueAmount[n][m]);
		
        int i = 1;
        int j = i;
		System.out.print("Path: ");	 
   		while(i <= n && j <= m ){
   				if(i > 1 || j > 1)
   					System.out.print("->");
   				if(j == m)
   					System.out.print("(" + i++ + "," + j + ")");
	       		else if (i == n)
	       			System.out.print("(" + i + "," + j++ + ")");
        		else if(valueAmount[i+1][j] > valueAmount[i][j+1])
	        		System.out.print("(" + i++ + "," + j + ")");
	        	else
	        		System.out.print("(" + i + "," + j++ + ")");

     	}
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
			//get each line from file

			String line;
			String[] boardSize = new String[2];
			line = fileInput.nextLine();
			boardSize = line.split(",");
			int n =  Integer.parseInt(boardSize[0]);
			int m =  Integer.parseInt(boardSize[1]);
			String[] lineArray = new String[m];
			int[][] coinMatrix = new int[n][m];
			//grabs ints from text input
			while(fileInput.hasNext()){
				for(int i = 0; i < n; i++){
					line = fileInput.nextLine();
					lineArray = line.split(",");
					for(int j = 0; j < m; j++){
						coinMatrix[i][j] = Integer.parseInt(lineArray[j]);
					}
				}
			}

			collectionCoin(coinMatrix,n,m);

		} catch (Exception e){
			System.out.println("Error: " + e);
		}
	}

}
