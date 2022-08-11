package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 병든 나이트
 * 
 * @see https://www.acmicpc.net/problem/1783
 * @author boolancpain
 */
public class Test1783 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int result = 0;
		
		if(n == 1) {
			// 세로가 1줄인 경우 이동할 수 없음
			result = 1;
		} else if(n == 2) {
			// 세로가 2줄인 경우 홀수칸만 방문 가능(가로 + 2, 세로 +- 1)
			result = Math.min((m + 1) / 2, 4);
		} else {
			// 가로가 7줄 보다 작으면 4번 이상 이동시 제약사항을 만족할 수 없음 
			if(m < 7) {
				// 3번 이동시 최대 방문 = 4
				result = Math.min(m, 4);
			} else {
				result = m - 2;
			}
		}
		
		System.out.println(result);
	}
}