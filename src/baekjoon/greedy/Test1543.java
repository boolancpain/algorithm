package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문서 검색
 * 
 * @see https://www.acmicpc.net/problem/1543
 * @author boolancpain
 */
public class Test1543 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer(br.readLine());
		String find = br.readLine();
		
		int idx = sb.indexOf(find);
		int result = 0;
		while(sb.indexOf(find) != -1) {
			result++;
			// replace
			sb.replace(idx, idx + find.length(), "0");
			idx = sb.indexOf(find);
		}
		
		System.out.println(result);
	}
}