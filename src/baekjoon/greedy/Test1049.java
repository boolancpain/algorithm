package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 기타줄
 * 
 * @see https://www.acmicpc.net/problem/1049
 * @author boolancpain
 */
public class Test1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int minPackage = Integer.MAX_VALUE; // 패키지 최소가
		int minOne = Integer.MAX_VALUE; // 낱개 최소가
		
		for(int i = 0;i < m;i++) {
			input = br.readLine().split(" ");
			
			minPackage = Math.min(minPackage, Integer.parseInt(input[0]));
			minOne = Math.min(minOne, Integer.parseInt(input[1]));
		}
		
		int result = 0;
		
		if(minPackage < minOne * 6) {
			// 낱개로 6개의 가격보다 패키지가 가격이 낮은 경우
			if((n % 6) * minOne > minPackage) {
				// 패키지로 구매하고 남은 기타줄을 낱개로 구매하는것보다 패키지로 구매하는게 가격이 낮은 경우 패키지를 한개 더 구매
				result = ((n / 6) + 1) * minPackage;
			} else {
				result = (n / 6) * minPackage + (n % 6) * minOne;
			}
		} else {
			// 낱개가 패키지보다 가격이 낮다면 낱개로만 계산
			result = n * minOne;
		}
		
		System.out.println(result);
	}
}