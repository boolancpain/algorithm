package baekjoon;

import java.util.Scanner;

/**
 * 설탕 배달
 * 
 * @see https://www.acmicpc.net/problem/2839
 * @author boolancpain
 */
public class Test2839 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 설탕 n 킬로그램
			int n = sc.nextInt();
			
			int answer = -1;
			
			// 5킬로그램 봉지로 나눌때 최대 몫
			int maxShare = n / 5;
			
			for(int i = 0;i <= maxShare;i++) {
				// 봉지 수
				int a = i;
				int r = n - (i * 5);
				
				a += r / 3;
				r = r % 3;
				
				if(r == 0) {
					if(answer == -1 || answer > a) {
						answer = a;
					}
				}
			}
			
			System.out.println(answer);
		}
	}
}