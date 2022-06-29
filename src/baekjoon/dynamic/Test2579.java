package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * 
 * @see https://www.acmicpc.net/problem/2579
 * @author boolancpain
 */
public class Test2579 {
	static int[] DP;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[] stairs = new int[n + 1];
			for(int i = 1;i <= n;i++) {
				stairs[i] = Integer.parseInt(br.readLine());
			}
			
			DP = new int[n + 1];
			
			DP[1] = stairs[1];
			
			if(n > 1) {
				DP[2] = stairs[1] + stairs[2];
			}
			
			// 각 계단마다 발생할 수 있는 최대 값을 구한다
			for(int i = 3;i < DP.length;i++) {
				// case 1. 2칸 아래 계단을 밟고 현재 계단을 밟는다
				// case 2. 3칸 아래 계단과 바로 아래 계단을 밟고 현재 계단을 밟는다
				DP[i] = Math.max(DP[i - 2], DP[i - 3] + stairs[i - 1]) + stairs[i];
			}
			
			System.out.println(DP[DP.length - 1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void climb(int n) {
		
	}
}