package com.roop.hackerRank.algo.dp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** 
 * 
 * @author rcnium
 *
 * https://www.hackerrank.com/challenges/fibonacci-modified
 * 
 * A series is defined in the following manner:

Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
Tn+2 = (Tn+1)2 + Tn

So, if the first two terms of the series are 0 and 1: 
the third term = 12 + 0 = 1 
fourth term = 12 + 1 = 2 
fifth term = 22 + 1 = 5 
... And so on.

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series.

Input Format

You are given three space separated integers A, B and N on one line.

Input Constraints 
0 <= A,B <= 2 
3 <= N <= 20

Output Format

One integer. 
This integer is the Nth term of the given series when the first two terms are A and B respectively.

Note

Some output may even exceed the range of 64 bit integer.
Sample Input

0 1 5  
Sample Output

5
Explanation

The first two terms of the series are 0 and 1. The fifth term is 5. How we arrive at the fifth term, is explained step by step in the introductory sections.
 */

public class ModifiedFibonacciSeries {
	private static Map<BigInteger, BigInteger> cachedResults;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		cachedResults = new HashMap<BigInteger, BigInteger>();
		cachedResults.put(BigInteger.valueOf(new Long(1)), BigInteger.valueOf(new Long(in.nextInt())));
		cachedResults.put(BigInteger.valueOf(new Long(2)), BigInteger.valueOf(new Long(in.nextInt())));
		int term = in.nextInt();
		
		modifiedFibonacciSeries(term);
		System.out.println(cachedResults.get(BigInteger.valueOf(new Long(term))));
		in.close();
	}

	private static void modifiedFibonacciSeries(int term) {
		if(term == 1 || term == 2) {
			return ;
		}
		for(long i = 3; i <= term; i++) {
			if(!cachedResults.containsKey(BigInteger.valueOf(new Long(i)))){
				cachedResults.put(BigInteger.valueOf(new Long(i)), 
						cachedResults.get(BigInteger.valueOf(new Long(i-1)))
								.multiply(cachedResults.get(BigInteger.valueOf(new Long(i-1))))
								.add(cachedResults.get(BigInteger.valueOf(new Long(i-2)))));
			}
		}
	}
}
