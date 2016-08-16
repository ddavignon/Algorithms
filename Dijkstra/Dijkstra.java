
			/**
			* Title: Dijkstra.java
			* Abstract: Dijkstra shortest path represented with adjacency matrix
			* Author: Dustin D'Avignon
			* Date: 04/26/16
			**/
			import java.util.Scanner;
			import java.lang.String;
			import java.io.File;

			public class Dijkstra {
				
				public static void main(String[] args) {


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

						//get how many nodes	
						int nodes = fileInput.nextInt();

						int[][] matrix = new int[nodes][nodes];
						String[] nodeName = new String[nodes];
						boolean[] visited = new boolean[nodes];
						int[] preNode = new int[nodes];
						int[] distance = new int[nodes];
						int min;
						int nextNode = 0;

						//get node names
						String line;
						String[] lineArray = new String[nodes];
						line = fileInput.nextLine();//consume the \n character from grabbing int
						line = fileInput.nextLine();
						lineArray = line.split(",");
						for(int i = 0; i < nodes; i++)
							nodeName[i] = lineArray[i];
						//enter cost for each node
						while(fileInput.hasNext()){
							for(int i = 0; i < nodes; i++){
								visited[i] = false;		
								preNode[i] = 0;
								line = fileInput.nextLine();
								lineArray = line.split(",");
								for(int j = 0; j < nodes; j++){
									if(i==j){
									matrix[i][j] = 0;
								} else {
									matrix[i][j] = Integer.parseInt(lineArray[j]);
									if(matrix[i][j] == 0)
										matrix[i][j] = 999;	
									matrix[j][i] = matrix[i][j];
								}
								}
							}
						}

					//find starting node
					//Scanner scan = new Scanner(System.in);
					System.out.print("Nodes: ");
					for(String name : nodeName)
						System.out.print(name + " ");
					System.out.print("\nSelect a source node: ");
					String sourceNode = scan.next();
					boolean found = false;
					for(int i = 0; i < nodes ; i++){
						if(nodeName[i].equals(sourceNode)){
							// swap name of matrix nodes
							String tempName = nodeName[i];
							nodeName[i] = nodeName[nextNode];
							nodeName[nextNode] = tempName;

							int temp;
							for(int j = 0; j < nodes; j++){
								temp = matrix[i][j];
								matrix[i][j] = matrix[nextNode][j];
								matrix[j][i] = matrix[i][j];
								matrix[nextNode][j] = temp;
								matrix[j][nextNode] = matrix[nextNode][j];
							}
							matrix[0][i] = matrix[0][0];
							matrix[0][0] = matrix[i][0];
							matrix[i][0] = matrix[0][i];
							found = true;
						}
						if(found == true)
							continue;
					}

					//print header
					System.out.print("\nNprime\t");
					for(String name : nodeName)
						System.out.print("\tD(" + name + "),p(" + name + ")");
					System.out.print("\n------\t");
					for(int i = 0; i < nodes; i++){
						System.out.print("\t--------");
					}
					System.out.println();

					// iniitalize start node
					distance = matrix[0];
					distance[nextNode] = 0;
					visited[nextNode] = true;
					preNode[nextNode] = nextNode;
					
					
					//Dijkstra's algorithm

					for(int i = 0; i<nodes; i++){

						min = 999; // represents infinity

						System.out.print(nodeName[nextNode] + ":\t");

						//find w not in N' such that distance[j] is a minimum
						for(int w = 0; w < nodes; w++){

							if(min > distance[w] && visited[w] == false){		
								min = distance[w];
								nextNode = w;
							} 
						}
						
						// print table values
						for(int s = 0; s < nodes; s++){
							if (distance[s] == 999)
								System.out.print("\tinf\t");
							else if(visited[s] == true)
								System.out.print("\t-\t");
							else
								System.out.print("\t" + distance[s] + "," + nodeName[preNode[s]] + "\t");

						}

						//add w to N' (visited)
						visited[nextNode] = true;

						//update distance[] for all currentNode adjacent to nextNode 
						for(int v = 0; v < nodes; v++){

							//not in N'
							if (visited[v] == false){
								//D(v) = min( D(v), D(w) + c(w,v) ) 
								if(min+matrix[nextNode][v] < distance[v]){
									distance[v] = min+matrix[nextNode][v];
									preNode[v] = nextNode;			

								}
							}
						}

						System.out.println();
					}
				} catch (Exception e){
					System.out.println("Error: " + e);
				}

				
			}
		}