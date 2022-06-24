package baekjoon.dynamic;

import java.util.Scanner;

/**
 * 피보나치 함수
 * 
 * @see https://www.acmicpc.net/problem/1003
 * @author boolancpain
 */
public class Test1003 {
	static int count0 = 0;
	static int count1 = 0;
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			
			int[] arr = new int[t];
			for(int i = 0;i < arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			
			int[][] dp = new int[41][2];
			dp[0] = new int[] {1, 0};
			dp[1] = new int[] {0, 1};
			
			for(int i = 2;i < 41;i++) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}
			
			for(int i = 0;i < t;i++) {
				System.out.println(dp[arr[i]][0] + " " + dp[arr[i]][1]);
			}
		}
	}
}