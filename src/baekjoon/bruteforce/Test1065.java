package baekjoon.bruteforce;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 한수
 * 
 * @see https://www.acmicpc.net/problem/1065
 * @author boolancpain
 */
public class Test1065 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int input = sc.nextInt();
			
			int total = 0;
			// 99
			if(input < 100) {
				total = input;
			} else {
				total = 99;
			}
			
			for(int i = 100;i <= input;i++) {
				int[] arr = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
				int diff = 0;
				boolean isRight = true;
				for(int j = 0;j < arr.length - 1;j++) {
					if(j == 0) {
						diff = arr[j + 1] - arr[j];
						continue;
					}
					if(arr[j + 1] - arr[j] != diff) {
						isRight = false;
						break;
					}
				}
				
				if(isRight) total++;
			}
			
			System.out.println(total);
		}
	}
}