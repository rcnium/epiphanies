package com.roop.hackerRank.algo.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author rcnium
 *
 * https://www.hackerrank.com/challenges/coin-change
 *
 * How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to efficiently compute the answer.

Task

Write a program that, given

The amount NN to make change for and the number of types MM of infinitely available coins
A list of MM coins - C={C1,C2,C3,..,CM}C={C1,C2,C3,..,CM}
Prints out how many different ways you can make change from the coins to STDOUT.

The problem can be formally stated:

Given a value NN, if we want to make change for NN cents, and we have infinite supply of each of C={C1,C2,…,CM}C={C1,C2,…,CM} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

Constraints

1≤Ci≤501≤Ci≤50
1≤N≤2501≤N≤250
1≤M≤501≤M≤50
The list of coins will contain distinct integers.
Solving the overlapping subproblems using dynamic programming

You can solve this problem recursively, but not all the tests will pass unless you optimise your solution to eliminate the overlapping subproblems using a dynamic programming solution

Or more specifically;

If you can think of a way to store the checked solutions, then this store can be used to avoid checking the same solution again and again.
Input Format

First line will contain 2 integer N and M respectively. 
Second line contain M integer that represent list of distinct coins that are available in infinite amount.

Output Format

One integer which is the number of ways in which we can get a sum of N from the given infinite supply of M types of coins.

Sample Input

4 3
1 2 3 
Sample Output

4
Sample Input #02

10 4
2 5 3 6
Sample Output #02

5
Explanation

Example 1: For N=4N=4 and C={1,2,3}C={1,2,3} there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}{1,1,1,1},{1,1,2},{2,2},{1,3}

Example 2: For N=10N=10 and C={2,5,3,6}C={2,5,3,6} there are five solutions: {2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}{2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}.

Hints

Think about the degenerate cases:

How many ways can you give change for 0 cents?
How many ways can you give change for >0 cents, if you have no coins?
If you are having trouble defining your solutions store, then think about it in terms of the base case (n=0)(n=0)
For help on reading from STDIN, see the HackerRank environment help page under the "Sample Problem Statement" section.
 */
public class CoinChangeProblemTabular {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int amount = in.nextInt();

		int coinNum = in.nextInt();
		List<Integer> coins = new ArrayList<Integer>();

		for(int i = 0; i < coinNum; i++) {
			int coin = in.nextInt(); 
			coins.add(coin);
		}
		Collections.sort(coins);
		
		System.out.println(getCoinChange(amount, coins));
		in.close();
	}

	private static long getCoinChange(int amount, List<Integer> coins) {
		int coinNum = coins.size();
		long[][] changeWays = new long[coinNum][amount+1];
	
		//adding zero column entries
		for(int i = 0; i < coinNum; i++) {
			changeWays[i][0] = 1;
		}
		
		//adding zero row entries 
		for(int j = 1; j <= amount; j++) {
			changeWays[0][j] = (j % coins.get(0) == 0) ? 1 : 0;
		}
		
		//DP table
		for(int i = 1; i < coins.size(); i++) {
			for(int j = 1; j <= amount; j++) {
				if(j < coins.get(i)) {
					changeWays[i][j] = changeWays[i-1][j];
				} else {
					changeWays[i][j] = changeWays[i-1][j] + changeWays[i][j-coins.get(i)];
				}
			}
		}
		
		return changeWays[coinNum - 1][amount];
	}
}
