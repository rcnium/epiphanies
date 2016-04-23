package com.roop.hackerRank.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author rcnium
 * https://www.hackerrank.com/challenges/red-john-is-back
 * 
 * Red John has committed another murder. But this time, he doesn't leave a red smiley behind. What he leaves behind is a puzzle for Patrick Jane to solve. He also texts Teresa Lisbon that if Patrick is successful, he will turn himself in. The puzzle begins as follows.

There is a wall of size 4xN in the victim's house. The victim also has an infinite supply of bricks of size 4x1 and 1x4 in her house. There is a hidden safe which can only be opened by a particular configuration of bricks in the wall. In every configuration, the wall has to be completely covered using the bricks. There is a phone number written on a note in the safe which is of utmost importance in the murder case. Gale Bertram wants to know the total number of ways in which the bricks can be arranged on the wall so that a new configuration arises every time. He calls it M. Since Red John is back after a long time, he has also gained a masters degree in Mathematics from a reputed university. So, he wants Patrick to calculate the number of prime numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should call Red John on the phone number from the safe and he will surrender if Patrick tells him the correct answer. Otherwise, Teresa will get another murder call after a week.

You are required to help Patrick correctly solve the puzzle.

Input Format

The first line of input will contain an integer T followed by T lines each containing an integer N.

Output Format

Print exactly one line of output for each test case. The output should contain the number P.

Constraints 
1<=T<=20 
1<=N<=40

Sample Input

2
1
7
Sample Output

0
3
 */

public class RedJohn {
	static Map<Integer, Long> brickArrangements = new HashMap<Integer, Long>();
	static Map<Integer, Long> factorialMap = new HashMap<Integer, Long>();
	static Map<Long, Integer> primesCounter = new HashMap<Long, Integer>();
	static List<Long> primes = new ArrayList<Long>();
	static long lastCounterEntry;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i = 0; i < t ; i++) {
			int brickNum = in.nextInt();
			getBrickArrangements(brickNum);
			long arrangements = brickArrangements.get(brickNum);
			System.out.println(arrangements);
			System.out.println(primesCounter.get(arrangements));
		}
		
		in.close();
	}

	private static void getBrickArrangements(int brickNum) {
		for(int i = 0; i <= brickNum; i++) {
			getArrangements(i);
			getPrimesCount(brickArrangements.get(i));
		}
	}

	private static void getPrimesCount(long i) {
		if(!primesCounter.containsKey(i)) {
			if(i == 0 || i == 1) {
				primesCounter.put(i, 0);
			} else if(i == 2) {
				primesCounter.put(i, 1);
				primes.add(i);
			} else {
				if(!primesCounter.containsKey(i - 1)) {
					updatePrimesCounter(lastCounterEntry, i-1);
				}
				int counter = primesCounter.get(i - 1) + isPrime(i);
				primesCounter.put(i, counter);
			}
			lastCounterEntry = i;
		}
	}

	private static void updatePrimesCounter(long lastEntry, long l) {
		for(long i = lastEntry+1; i <= l; i++) {
			int count = primesCounter.get(i-1) + isPrime(i);
			primesCounter.put(i, count);
		}
	}

	private static Integer isPrime(long i) {
		for(long prime : primes) {
			if(i % prime == 0) {
				return 0;
			} 
		}
		
		primes.add(i);
		return 1;
	}

	private static void getArrangements(int brickNum) {
		if(brickNum < 0)
			return;
		if(!brickArrangements.containsKey(brickNum)) {
			if(brickNum == 0){
				brickArrangements.put(0, (long)1);
			} else {
				long arrangements = brickArrangements.get(brickNum - 1) +
						((brickNum - 4 >= 0) ? brickArrangements.get(brickNum - 4) : 0);
				brickArrangements.put(brickNum, arrangements);
			}
		}
	}
}
