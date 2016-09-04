/**
* Title: DFS.java
* Abstract: Depth First Search program using input from adjacency matrix
* Author: Dustin D'Avignon
* ID: 0611
* Date: 03/08/16
**/

import java.util.Scanner;
import java.util.Stack;
import java.lang.String;
import java.io.File;


public class DFS {

	public static void dfs(int[][] adjacencyMatrix, int startNode){

		// create stack
		Stack<Integer> stack = new Stack<Integer>();

		int nodes = adjacencyMatrix[startNode].length;
		boolean[] visited = new boolean[nodes];
		int element = startNode;
		int i = startNode;
		visited[startNode] = true;
		stack.push(startNode);
	
		// print out results of DFS 
		System.out.print(element + " ");
		while(!stack.isEmpty()){
			element = stack.peek();
			i = element;
			while(i < nodes){
				if(adjacencyMatrix[element][i] == 1 && visited[i] == false){
					stack.push(i);
					visited[i] = true;
					element = i;
					i = 1;
					System.out.print(" -> " + element);
					continue;
				}
				i++;
			}
			stack.pop();
		}
		System.out.println();
	}



	public static void main (String[] args){

		/*
		Get filename from user
		*/
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter filename: ");
		String fileName = scan.nextLine(); 
		System.out.println(fileName);

		/*
		Run file, throw exception if file error
		*/
		try{

			//open file, start with getting amount of nodes
			File file = new File(fileName);
			Scanner fileInput = new Scanner(file);
			int nodes =  Integer.parseInt(fileInput.nextLine());
			//get each line from file
			String line;
			String[] lineArray = new String[nodes];
			int[][] adjacencyMatrix = new int[nodes][nodes];
			//grabs ints from text input
			while(fileInput.hasNext()){
				for(int i = 0; i < nodes; i++){
					line = fileInput.nextLine();
					lineArray = line.split(",");
					for(int j = 0; j < nodes; j++){
						adjacencyMatrix[i][j] = Integer.parseInt(lineArray[j]);
						//System.out.print(adjacencyMatrix[i][j] + " ");
					}
				}
			}

			System.out.print("Enter start node: ");
			int startNode = Integer.parseInt(scan.nextLine());

			System.out.print("DFS order: ");
			dfs(adjacencyMatrix, startNode);

		} catch (Exception e){
			System.out.println("Error: " + e);
		}
		
	}

}
