package baekjoon;

import java.util.Scanner;

/**
 * 블랙잭
 * 
 * @see https://www.acmicpc.net/problem/2798
 * @author boolancpain
 */
public class Test2798 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[] cardArr = new int[n];
			for(int i = 0;i < n;i++) {
				cardArr[i] = sc.nextInt();
			}
			
			int sum = 0;
			int tempSum = 0;
			for(int i = 0;i < n - 2;i++) {
				for(int j = i + 1;j < n - 1;j++) {
					for(int k = j + 1;k < n;k++) {
						tempSum = cardArr[i] + cardArr[j] + cardArr[k];
						
						if(tempSum > sum && tempSum <= m) {
							sum = tempSum;
						}
					}
				}
			}
			
			System.out.println(sum);
		}
	}
}