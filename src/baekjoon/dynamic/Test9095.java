package baekjoon.dynamic;

import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * 
 * @see https://www.acmicpc.net/problem/9095
 * @author boolancpain
 */
public class Test9095 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			
			int[] arr = new int[t];
			for(int i = 0;i < t;i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] solution = new int[11];
			for(int i = 0;i < solution.length;i++) {
				if(i == 0) {
					solution[i] = 0;
				} else if(i == 1 || i == 2) {
					solution[i] = i;
				} else if(i == 3) {
					solution[i] = 4;
				} else {
					solution[i] = solution[i - 3] + solution[i - 2] + solution[i - 1];
				}
			}
			
			for(int n : arr) {
				System.out.println(solution[n]);
			}
		}
	}
}