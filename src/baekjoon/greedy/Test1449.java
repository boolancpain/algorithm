package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 수리공 항승
 * 
 * @see https://www.acmicpc.net/problem/1449
 * @author boolancpain
 */
public class Test1449 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] inputs = br.readLine().split(" ");
			
			int n = Integer.parseInt(inputs[0]);
			int l = Integer.parseInt(inputs[1]);
			
			inputs = br.readLine().split(" ");
			
			int[] arr = new int[n];
			for(int i = 0;i < n;i++) {
				arr[i] = Integer.parseInt(inputs[i]);
			}
			
			Arrays.sort(arr);
			
			int result = 1;
			int start = arr[0];
			
			for(int i = 1;i < n;i++) {
				// 물 새는곳이 붙인 테이프의 끝보다 멀면 새 테이프를 붙임.
				int end = start + l - 1;
				if(end < arr[i]) {
					result++;
					start = arr[i];
				}
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
