package com.roop.hackerRank.algo.strings;

import java.util.Scanner;

/**
 * 
 * @author rcnium
 *
 * https://www.hackerrank.com/challenges/the-love-letter-mystery?h_r=next-challenge&h_v=zen
 * 
 * James found a love letter his friend Harry has written for his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

To do this, he follows two rules:

He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.

Input Format

The first line contains an integer , i.e., the number of test cases. 
The next  lines will contain a string each. The strings do not contain any spaces.

Constraints 
 
 length of string  
All characters are lower case English letters.

Output Format

A single line containing the number of minimum operations corresponding to each test case.

Sample Input

4
abc
abcba
abcd
cba
Sample Output

2
0
4
2
Explanation

For the first test case, abc -> abb -> aba.
For the second test case, abcba is already a palindromic string.
For the third test case, abcd -> abcc -> abcb -> abca = abca -> abba.
For the fourth test case, cba -> bba -> aba.

 */

public class LoveLetterMystery {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int i = 0; i < t; i++) {
			reqOpNum(in.next());
		}
		
		in.close();
	}

	private static void reqOpNum(String s) {
		int counter = 0;
		
		for(int i = 0, j = s.length()-1; i <= j; i++, j--) {
			counter += Math.abs(s.charAt(i) - s.charAt(j));
		}
		
		System.out.println(counter);
	}
}