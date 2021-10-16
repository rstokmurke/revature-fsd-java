package com.revature.app.codingSession;

public class Pattern {

	public static void main(String[] args) {
		int[][] arr = new int[4][5];
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {
				arr[r][c] = r*4+c+1;
				arr[r][4] +=  arr[r][c];
			}			
		}
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print(String.format("%4d",  arr[r][c]));
			}			
			System.out.println();
		}


	}

}
