package baekjoon;

import java.util.Scanner;

/**
 * 분해합
 * 
 * @see https://www.acmicpc.net/problem/2231
 * @author boolancpain
 */
public class Test2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int result = 0;
		
		for(int i = 1;i < input;i++) {
			int number = i;
			int sum = 0;
			
			while(number != 0) {
				sum += number % 10;
				number /= 10;
			}
			
			if(sum + i == input) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
}