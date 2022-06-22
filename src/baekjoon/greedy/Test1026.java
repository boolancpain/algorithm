package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 보물
 * 
 * @see https://www.acmicpc.net/problem/1026
 * @author boolancpain
 */
public class Test1026 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[] a = new int[n];
			Integer[] b = new Integer[n];
			
			for(int i = 0;i < n;i++) {
				a[i] = sc.nextInt();
			}
			for(int i = 0;i < n;i++) {
				b[i] = sc.nextInt();
			}
			
			// 가장 큰 수와 가장 작은 수의 곱으로 합계를 최소화 한다.
			// a는 오름차순
			Arrays.sort(a);
			// b는 내림차순
			Arrays.sort(b, (o1, o2) -> o2 - o1);
			
			int sum = 0;
			for(int i = 0;i < n;i++) {
				sum += a[i] * b[i];
			}
			
			System.out.println(sum);
		}
	}
}