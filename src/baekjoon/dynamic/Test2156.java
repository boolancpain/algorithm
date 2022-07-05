package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 포도주 시식
 * 
 * @see https://www.acmicpc.net/problem/2156
 * @author boolancpain
 */
public class Test2156 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[] inputs = new int[n + 1];
			int[] dp = new int[n + 1];
			
			for(int i = 1;i <= n;i++) {
				inputs[i] = Integer.parseInt(br.readLine());
			}
			
			dp[1] = inputs[1];
			if(n > 1) {
				dp[2] = dp[1] + inputs[2];
				for(int i = 3;i <= n;i++) {
					// 케이스 1 : 3번째 전 포도주(누적) > 1번째 전 포도주 > 현재 포도주
					// 케이스 2 : 2번째 전 포도주(누적) > 현재 포도주
					dp[i] = Math.max(dp[i - 3] + inputs[i - 1], dp[i - 2]) + inputs[i];
					dp[i] = Math.max(dp[i], dp[i - 1]);
				}
			}
			
			System.out.println(dp[n]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}