package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 30
 * 
 * @see https://www.acmicpc.net/problem/10610
 * @author boolancpain
 */
public class Test10610 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String n = br.readLine();
			
			// "배수판정법"
			// 30의 배수 판정법 : 3의 배수이면서 10의 배수이다
			// 3의 배수 판정법 : 모든 자리 수의 합이 3의 배수이다
			// 10의 배수 판정법 : 일의 자리수가 0이다
			
			// 10의 배수 판정법, 0이 없으면 10의 배수가 될 수 없다
			if(!n.contains("0")) {
				System.out.println(-1);
				return;
			}
			
			// 3의 배수 판정법, 모든 자리 수를 더했을 때 3으로 나눈 나머지가 0이어야 한다.
			String[] arr = n.split("");
			long sum = 0;
			for(String t : arr) {
				sum += Integer.parseInt(t);
			}
			
			if(sum % 3 != 0) {
				System.out.println(-1);
				return;
			}
			
			// 내림차순 정렬
			Arrays.sort(arr, (s1, s2) -> s2.compareTo(s1));
			String result = "";
			for(String t : arr) {
				result = result.concat(t);
			}
			
			System.out.println(new BigInteger(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}