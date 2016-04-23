package com.roop.hackerRank.algo.impl;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		
		int strLen = s.length();
		int rows = (int) Math.floor(Math.sqrt(strLen));
		int cols = (int) Math.ceil(Math.sqrt(strLen));
		if(rows*cols < strLen){
			rows++;
		}
		char[][] charGrid = new char[rows][cols];
		
		char[] chars = s.toCharArray();
		int pointer = 0;
		for(int i=0; i<rows; i++){
			for(int j=0; j<cols; j++) {
				if((pointer) < chars.length) {
					charGrid[i][j] = chars[pointer];
				} else {
					charGrid[i][j] = ' ';
				}
				pointer++;
			}
		}
		in.close();
		
		for(int i=0; i<cols; i++){
			for(int j=0; j<rows; j++){
				if(charGrid[j][i] != ' '){
					System.out.print(charGrid[j][i]);
				}
			}
			System.out.print(" ");
		}
	}
}
