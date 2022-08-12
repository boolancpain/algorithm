package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 만들기
 * 
 * @see https://www.acmicpc.net/problem/1213
 * @author boolancpain
 */
public class Test1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split("");
		
		int[] alphabet = new int[26];
		
		for(String token : input) {
			int index = (int) token.charAt(0) - 65;
			
			alphabet[index] += 1;
		}
		
		StringBuilder sb = new StringBuilder();
		String fail = "I'm Sorry Hansoo";
		
		// 홀수개의 문자열 집계
		int oddCount = 0;
		int oddIndex = 0;
		for(int i = 0;i < alphabet.length;i++) {
			if(alphabet[i] % 2 == 1) {
				oddCount++;
				oddIndex = i;
			}
		}
		
		if(oddCount > 1) {
			// 홀수개의 문자열은 1개 이상 존재할 수 없음
			System.out.println(fail);
		} else {
			for(int i = 0;i < alphabet.length;i++) {
				for(int j = 0;j < alphabet[i] / 2;j++) {
					sb.append(Character.toString((char) (i + 65)));
				}
			}
			
			System.out.println(sb.toString() + (oddCount == 1 ? Character.toString((char) (oddIndex + 65)) : "") + sb.reverse().toString());
		}
	}
}