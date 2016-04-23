package com.roop.hackerRank.algo.dp;

import java.util.Scanner;

/**
 * 
 * @author rcnium
 *
 * https://www.hackerrank.com/challenges/maxsubarray
 * 
 * Given an array A={a1,a2,…,aN}A={a1,a2,…,aN} of NN elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer TT. TT cases follow. 
Each test case begins with an integer NN. In the next line, NN integers follow representing the elements of array AA.

Constraints:

1≤T≤101≤T≤10
1≤N≤1051≤N≤105
−104≤ai≤104−104≤ai≤104
The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 */

public class MaxSumSubarray {
	static int maxContiguousSum = 0;
	static int maxNonContiguousSum = 0;
	static int maxEntry = Integer.MIN_VALUE;
	static int sum = 0;
	static int ans = 0;
	static boolean hasPositive = false;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int t0 = 0; t0 < t; t0++) {
			int size = in.nextInt();
			int[] arr = new int[size];
			for(int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}
			kadaneMaxSumSubArray(arr);
			System.out.println(maxContiguousSum + " " + maxNonContiguousSum);
			maxContiguousSum = 0;
			maxNonContiguousSum = 0;
			maxEntry = Integer.MIN_VALUE;
			sum = 0;
			ans = 0;
			hasPositive = false;
		}
		in.close();
	}

	private static void kadaneMaxSumSubArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				hasPositive = true;
				maxNonContiguousSum += arr[i];
			} else {
				maxEntry = Math.max(maxEntry, arr[i]);
			}
			
			sum += arr[i];
			
			if(sum < 0) {
				sum = 0;
			}
			
			ans = Math.max(sum, ans);
		}
		
		maxContiguousSum = hasPositive ? ans : maxEntry;
		maxNonContiguousSum = hasPositive ? maxNonContiguousSum : maxEntry;
	}
}
