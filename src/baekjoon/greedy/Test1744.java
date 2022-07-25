package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 수 묶기
 * 
 * @see https://www.acmicpc.net/problem/1744
 * @author boolancpain
 */
public class Test1744 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			ArrayList<Integer> positives = new ArrayList<>();
			ArrayList<Integer> negatives = new ArrayList<>();
			int zeroCount = 0;
			
			for(int i = 0;i < n;i++) {
				int num = sc.nextInt();
				if(num > 0) {
					positives.add(num);
				} else if(num < 0) {
					negatives.add(num);
				} else {
					zeroCount++;
				}
			}
			
			// 양수 내림차순
			Collections.sort(positives, (i1, i2) -> i2 - i1);
			// 음수 오름차순
			Collections.sort(negatives, (i1, i2) -> i1 - i2);
			
			int result = 0;
			int temp = 0;
			
			// 내림차순으로 정렬된 양수는 두 수를 곱하고 더한다.
			// ex) 5, 4, 3, 2, 1 = (5 * 4) + (3 * 2) + 1
			for(int i = 0;i < positives.size() - (positives.size() % 2);i++) {
				int num = positives.get(i);
				// 1은 곱하기보다 더하기가 유리하다
				if(num == 1) {
					result += temp + num;
					temp = 0;
				} else {
					if(i % 2 == 0) {
						temp = num;
					} else {
						result += temp * num;
						temp = 0;
					}
				}
			}
			
			// 양수가 홀수개 라면 마지막 숫자는 그냥 더한다.
			if(positives.size() % 2 > 0) {
				result += positives.get(positives.size() - 1);
			}
			
			// 오름차순 정렬된 음수는 두 수를 곱하고 더한다.
			for(int i = 0;i < negatives.size();i++) {
				if(i % 2 == 0) {
					temp = negatives.get(i);
				} else {
					result += temp * negatives.get(i);
					temp = 0;
				}
			}
			
			// 음수가 홀수개이고, 0이 존재하지 않는다면 더한다.
			// 0이 존재하면 음수와 0을 곱해 0으로 처리함
			if(negatives.size() % 2 > 0 && zeroCount == 0) {
				result += temp;
			}
			
			System.out.println(result);
		}
	}
}