package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 거스름돈
 * 
 * @see https://www.acmicpc.net/problem/14916
 * @author boolancpain
 */
public class Test14916 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int result = -1;
		
		for(int i = n / 5;i >= 0;i--) {
			int remain = n - (i * 5);
			
			if(remain % 2 == 0) {
				result = i + remain / 2;
				break;
			}
		}
		
		System.out.println(result);
	}
}