package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 * 
 * @see https://www.acmicpc.net/problem/10844
 * @author boolancpain
 */
public class Test10844 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] dp = new int[n][10];
			
			int result = 0;
			
			for(int i = 1;i < 10;i++) {
				dp[0][i] = 1;
			}
			
			if(n > 1) {
				// 앞자리부터 숫자를 탐색한다.
				for(int i = 1;i < n;i++) {
					for(int j = 0;j < 10;j++) {
						if(j == 0) {
							// 끝자리가 0인 경우는 1가지밖에 없음
							dp[i][j] = dp[i - 1][j + 1];
						} else if(j == 9) {
							// 끝자리가 9인 경우는 1가지 밖에 없음
							dp[i][j] = dp[i - 1][j - 1];
						} else {
							dp[i][j] = (dp[i - 1][j + 1] + dp[i - 1][j - 1]) % 1000000000;
						}
					}
				}
			}
			
			for(int num : dp[n - 1]) {
				result = (result + num) % 1000000000;
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}