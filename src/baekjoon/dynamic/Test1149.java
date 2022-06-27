package baekjoon.dynamic;

import java.util.Scanner;

/**
 * RGB거리
 * 
 * @see https://www.acmicpc.net/problem/1149
 * @author boolancpain
 */
public class Test1149 {
	static int[][] DP;
	
	static int RED = 0;
	static int GREEN = 1;
	static int BLUE = 2;
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][3];
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < 3;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			DP = new int[n][3];
			DP[0][RED] = arr[0][RED];		// red
			DP[0][GREEN] = arr[0][GREEN];	// green
			DP[0][BLUE] = arr[0][BLUE];		// blue
			
			solution(arr, 1);
			
			System.out.println(Math.min(Math.min(DP[n - 1][RED], DP[n - 1][GREEN]), DP[n - 1][BLUE]));
		}
	}
	
	public static void solution(int[][] arr, int depth) {
		// 배열의 끝까지 누적 최소값을 구한다
		if(arr.length > depth) {
			// red
			DP[depth][RED] = Math.min(DP[depth - 1][GREEN], DP[depth - 1][BLUE]) + arr[depth][RED];
			// green
			DP[depth][GREEN] = Math.min(DP[depth - 1][RED], DP[depth - 1][BLUE]) + arr[depth][GREEN];
			// blue
			DP[depth][BLUE] = Math.min(DP[depth - 1][RED], DP[depth - 1][GREEN]) + arr[depth][BLUE];
			
			// next
			solution(arr, depth + 1);
		}
	}
}