package baekjoon.greedy;

import java.util.Scanner;

/**
 * 동전 0
 * 
 * @see https://www.acmicpc.net/problem/11047
 * @author boolancpain
 */
public class Test11047 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int limit = 0;
			
			int[] coins = new int[n];
			for(int i = 0;i < n;i++) {
				coins[i] = sc.nextInt();
				
				if(coins[i] <= k) {
					limit = i;
				}
			}
			
			sc.close();
			
			int answer = 0;
			int remain = k;
			for(int i = limit;i >= 0;i--) {
				answer += remain / coins[i];
				remain %= coins[i];
				
				if(remain == 0) break;
			}
			
			System.out.println(answer);
		}
	}
}