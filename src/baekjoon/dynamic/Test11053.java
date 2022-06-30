package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 가장 긴 증가하는 부분 수열
 * 
 * @see https://www.acmicpc.net/problem/11053
 * @author boolancpain
 */
public class Test11053 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			String[] inputs = br.readLine().split(" ");
			for(int i = 0;i < inputs.length;i++) {
				arr[i] = Integer.parseInt(inputs[i]);
			}
			
			int[] dp = new int[n];
			
			dp[0] = 1;
			
			// 각 원소부터 순차적으로 탐색
			for(int i = 1;i < n;i++) {
				dp[i] = 1;
				
				// i번째 원소보다 앞에 있는 원소들을 탐색
				for(int j = 0;j < i;j++) {
					if(arr[j] < arr[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			
			int max = dp[0];
			for(int d : dp) {
				if(max < d) {
					max = d;
				}
			}
			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}