package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 부녀회장이 될테야
 * 
 * @see https://www.acmicpc.net/problem/2775
 * @author boolancpain
 */
public class Test2775 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int testCase = Integer.parseInt(br.readLine());
			
			int[] k = new int[testCase];
			int[] n = new int[testCase];
			for(int i = 0;i < testCase;i++) {
				k[i] = Integer.parseInt(br.readLine());
				n[i] = Integer.parseInt(br.readLine());
			}
			
			for(int i = 0;i < testCase;i++) {
				System.out.println(getPeople(k[i], n[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// n층 k호에 몇명이 사는지
	public static int getPeople(int n, int k) {
		if(n == 0) {
			return k;
		} else if(k == 1) {
			return 1;
		} else {
			// 3층 5호 = 3층 4호 + 2층 5호
			return getPeople(n, k - 1) + getPeople(n - 1, k);
		}
	}
}