package com.roop.hackerRank.algo.graphTheory;

import java.util.Scanner;

/**
 * 
 * @author rcnium
 * 
 * https://www.hackerrank.com/challenges/bfsshortreach
 *
 *Given an undirected graph consisting of NN nodes (labelled 1 to N) where a specific given node SS represents the start position and an edge between any two nodes is of length 66 units in the graph.

It is required to calculate the shortest distance from start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1−1. 
Note 2: The length of each edge in the graph is 66 units.

Input Format

The first line contains TT, denoting the number of test cases. 
First line of each test case has two integers NN, denoting the number of nodes in the graph and MM, denoting the number of edges in the graph. 
The next MM lines each consist of two space separated integers x yx y, where xx and yy denote the two nodes between which the edge exists. 
The last line of a testcase has an integer SS, denoting the starting position.

Constraints 
1≤T≤101≤T≤10 
2≤N≤10002≤N≤1000 
1≤M≤N×(N−1)21≤M≤N×(N−1)2 
1≤x,y,S≤N1≤x,y,S≤N

Output Format

For each of TT test cases, print a single line consisting of N−1N−1 space-separated integers, denoting the shortest distances of the N-1 nodes from starting position SS. This will be done for all nodes same as in the order of input 1 to N.

For unreachable nodes, print −1−1.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2
Sample Output

6 6 -1
-1 6
Explanation

For test cases 1:

The graph given in the test case is shown as :

Graph

S denotes the node 1 in the test case and B,C and D denote 2,3 and 4. Since S is the starting node and the shortest distances from it are (1 edge, 1 edge, Infinity) to the nodes B,C and D (2,3 and 4) respectively.

Node D is unreachable, hence -1 is printed (not Infinity).

For test cases 2: There are only one edge (2, 3) in a graph with 3 nodes, so node 1 is unreachable from node 2, and node 3 has one edge from node 2, each edge has the length of 6 units. So we output -1 6.
     

 */
public class BreadthFirstSearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int a=0; a<t; a++) {
			int n = in.nextInt();
			int m = in.nextInt();

			Graph g = new Graph(m, n);
			for(int edges=0 ; edges<m; edges++) {
				int v = in.nextInt();
				int w = in.nextInt();
				g.addEdge(v, w);
				g.addEdge(w, v);
			}
			int source = in.nextInt();
			g.breadthFirstSearch(source);

			for(int i =1; i <= g.getNumVertices(); i++) {
				if(i == source) {
					continue;
				}
				
				if(g.getDistanceMap().containsKey(i)){
					System.out.print(g.getDistanceMap().get(i) + " ");
				} else {
					System.out.print("-1 ");
				}
			}
			
			/*for(Entry<Integer, Integer> entry : g.getDistanceMap().entrySet()){
				System.out.print(entry.getValue() + " ");
			}
			
			for(int i =0; i < (g.getNumVertices() - g.getDistanceMap().size() - 1); i++) {
				System.out.print("-1 ");
			}*/
			
			
			System.out.println("");
		}
			
			
		in.close();
	}
}
