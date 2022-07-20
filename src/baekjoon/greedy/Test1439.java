package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 뒤집기
 * 
 * @see https://www.acmicpc.net/problem/1439
 * @author boolancpain
 */
public class Test1439 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String s = br.readLine();
			
			StringTokenizer zeroTokenizer = new StringTokenizer(s, "0");
			StringTokenizer oneTokenizer = new StringTokenizer(s, "1");
			
			// 각 토큰을 0과 1로 잘라서 토큰의 개수가 적은것을 바꾸는게 최소값이다.
			System.out.println(Math.min(zeroTokenizer.countTokens(), oneTokenizer.countTokens()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}