package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 피보나치 수 2
 * 
 * @see https://www.acmicpc.net/problem/2748
 * @author boolancpain
 */
public class Test2748 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			long[] dp = new long[n + 1];
			
			dp[0] = 0;
			dp[1] = 1;
			
			if(n >= 2) {
				for(int i = 2;i <= n;i++) {
					dp[i] = dp[i - 2] + dp[i - 1];
				}
			}
			
			System.out.println(dp[n]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}