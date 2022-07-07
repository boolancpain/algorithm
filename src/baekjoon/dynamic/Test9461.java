package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 * 
 * @see https://www.acmicpc.net/problem/9461
 * @author boolancpain
 */
public class Test9461 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int t = Integer.parseInt(br.readLine());
			
			int[] arr = new int[t];
			int max = 0;
			for(int i = 0;i < t;i++) {
				arr[i] = Integer.parseInt(br.readLine());
				
				max = Math.max(max, arr[i]);
			}
			
			long[] dp = new long[max + 1];
			
			for(int i = 1;i <= max;i++) {
				if(i < 4) {
					dp[i] = 1;
				} else if(i < 6) {
					dp[i] = 2;
				} else {
					dp[i] = dp[i - 1] + dp[i - 5];
				}
			}
			
			for(int num : arr) {
				System.out.println(dp[num]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}