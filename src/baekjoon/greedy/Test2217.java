package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 로프
 * 
 * @see https://www.acmicpc.net/problem/2217
 * @author boolancpain
 */
public class Test2217 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			for(int i = 0;i < n;i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			// 오름차순 정렬
			Arrays.sort(arr);
			
			int max = 0;
			for(int i = 0;i < n;i++) {
				// 가장 가벼운 물체를 들 수 있는 로프부터 합계를 구함
				max = Math.max(max, arr[i] * (n - i));
			}
			
			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}