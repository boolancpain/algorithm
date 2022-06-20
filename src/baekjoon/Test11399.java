package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * ATM
 * 
 * @see https://www.acmicpc.net/problem/11399
 * @author boolancpain
 */
public class Test11399 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[] inputs = new int[n];
			for(int i = 0;i < n;i++) {
				inputs[i] = sc.nextInt();
			}
			
			Arrays.sort(inputs);
			
			int answer = 0;
			int t = 0;
			for(int i = 0;i < n;i++) {
				t = t + inputs[i];
				answer += t;
			}
			
			System.out.println(answer);
		}
	}
}