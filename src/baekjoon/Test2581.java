package baekjoon;

import java.util.Scanner;

/**
 * 소수
 * 
 * @see https://www.acmicpc.net/problem/2581
 * @author boolancpain
 */
public class Test2581 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			int sum = 0;
			int min = 0;
			for(int i = m;i <= n;i++) {
				boolean isPrimeNumber = true;
				
				if(i == 1) continue;
				
				// 소수 구하기 : 2부터 N - 1까지 배수인지 체크
				for(int j = 2;j < i;j++) {
					if(i % j == 0) {
						isPrimeNumber = false;
						break;
					}
				}
				
				if(isPrimeNumber) {
					sum += i;
					if(min == 0) min = i;
				}
			}
			
			if(sum == 0) {
				System.out.println(-1);
			} else {
				System.out.println(sum);
				System.out.println(min);
			}
		}
	}
}