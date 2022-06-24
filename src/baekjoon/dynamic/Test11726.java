package baekjoon.dynamic;

import java.util.Scanner;

/**
 * 2xn 타일링
 * 
 * @see https://www.acmicpc.net/problem/11726
 * @author boolancpain
 */
public class Test11726 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[] dp = new int[1001];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			for(int i = 3;i < dp.length;i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
			
			System.out.println(dp[n]);
		}
	}
}