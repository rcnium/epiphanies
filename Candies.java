package com.roop.hackerRank.algo.dp;

import java.util.Scanner;

/**
 * 
 * @author rcnium
 *
 * https://www.hackerrank.com/challenges/candies
 * 
 * Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line ( their positions are fixed), and each  of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies given to the children.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an integer that indicates the rating of each child.

Constraints

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4
Explanation

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies. Hence optimal distribution will be 1, 2, 1.
 */

public class Candies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int childrenNum = in.nextInt();
		
		int[] ratings = new int[childrenNum];
		for(int i = 0; i < childrenNum; i++) {
			ratings[i] = in.nextInt();
		}
		
		getMinCandiesNum(ratings);
		in.close();
	}

	private static void getMinCandiesNum(int[] ratings) {
		int[] candies = new int[ratings.length];
		
		candies[0] = 1;
		long candiesNum = 0;
		
		for(int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1] + 1;
			} else {
				candies[i] = 1;
			}
			
		}
		
		for(int i = ratings.length-1; i >= 1; i--) {
			if(ratings[i-1] > ratings[i]) {
				if(candies[i-1] <= candies[i]) {
					candies[i-1] = candies[i] + 1;
				}
			}
			candiesNum += candies[i];
		}
		
		candiesNum += candies[0];
		System.out.println(candiesNum);
	}
}
