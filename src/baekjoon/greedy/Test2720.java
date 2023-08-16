package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 세탁소 사장 동혁
 * 
 * @see https://www.acmicpc.net/problem/2720
 * @author boolancpain
 */
public class Test2720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		int[] inputs = new int[test];
		int[][] results = new int[test][4];
		for(int i = 0;i < test;i++) {
			inputs[i] = Integer.parseInt(br.readLine());
			int temp = inputs[i];
			
			// 쿼터 $0.25
			results[i][0] = temp/25;
			temp %= 25;
			// 다임 $0.1
			results[i][1] = temp/10;
			temp %= 10;
			// 니켈 $0.05
			results[i][2] = temp/5;
			// 페니 $0.01
			results[i][3] = temp%5;
		}
		
		for(int i = 0;i < test;i++) {
			System.out.printf("%d %d %d %d\n", results[i][0], results[i][1], results[i][2], results[i][3]);
		}
	}
}