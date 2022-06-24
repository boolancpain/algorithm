package baekjoon.dynamic;

import java.util.Scanner;

/**
 * 1로 만들기
 * 
 * @see https://www.acmicpc.net/problem/1463
 * @author boolancpain
 */
public class Test1463 {
	static int MIN = 0;
	public static void compare(int x, int cnt) {
		if(x == 1) {
			if(cnt < MIN || MIN == 0) {
				MIN = cnt;
			}
			
			return;
		} else if(cnt >= MIN && MIN > 0) {
			// 최적해보다 크거나 같아지면 종료
			return;
		}
		
		// 3으로 나누어 떨어지면 3으로 나누기
		if(x % 3 == 0) {
			compare(x / 3, cnt + 1);
		}
		// 2으로 나누어 떨어지면 2로 나누기
		if(x % 2 == 0) {
			compare(x / 2, cnt + 1);
		}
		
		compare(x - 1, cnt + 1);
	}
	
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			compare(n, 0);
			
			System.out.println(MIN);
		}
	}
}