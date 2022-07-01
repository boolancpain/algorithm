package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 연속합
 * 
 * @see https://www.acmicpc.net/problem/1912
 * @author boolancpain
 */
public class Test1912 {
	static int[] DP;
	
	static int max= 0;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			String[] str = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i = 0;i < n;i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			DP = new int[n];
			
			DP[0] = arr[0];
			max = arr[0];
			
			// 탐색
			find(arr, n - 1);
			
			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int find(int[] arr, int index) {
		if(index > 0) {
			// 이전 요소까지의 합계와 현재 요소값으로 큰 값을 저장
			DP[index] = Math.max(find(arr, index - 1) + arr[index], arr[index]);
		} else {
			DP[index] = arr[index];
		}
		
		max = Math.max(max, DP[index]);
		
		return DP[index];
	}
}