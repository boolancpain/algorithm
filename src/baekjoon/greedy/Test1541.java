package baekjoon.greedy;

import java.util.Scanner;

/**
 * 잃어버린 괄호
 * 
 * @see https://www.acmicpc.net/problem/1541
 * @author boolancpain
 */
public class Test1541 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();
			sc.close();
			
			int sum = 0;
			// -로 분해한 뒤 +로 분해한 각 토큰을 모두 더해서 뺀다
			String[] subTokens = str.split("-");
			
			for(int i = 0;i < subTokens.length;i++) {
				String[] addTokens = subTokens[i].split("\\+");
				
				int tempSum = 0;
				for(int j = 0;j < addTokens.length;j++) {
					tempSum += Integer.parseInt(addTokens[j]);
				}
				
				if(i == 0) {
					sum = tempSum;
				} else {
					sum -= tempSum;
				}
			}
			
			System.out.println(sum);
		}
	}
}