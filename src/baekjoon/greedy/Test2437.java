package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 저울
 * 
 * @see https://www.acmicpc.net/problem/2437
 * @author boolancpain
 */
public class Test2437 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			
			String[] inputs = br.readLine().split(" ");
			for(int i = 0;i < n;i++) {
				arr[i] = Integer.parseInt(inputs[i]);
			}
			
			// 오름차순 정렬
			Arrays.sort(arr);
			
			int result = 0;
			for(int i = 0;i < n;i++) {
				// 누적합 : S(n)
				// 배열 : A(n)
				// A(1) = S(n) = 1 이어야 한다
				// A(2) 부터는
				// A(n) > S(n - 1) + 1인 경우
				// S(n - 1) + 1이 구할 수 없는 누적합
				if(arr[i] > result + 1) {
					break;
				}
				
				result += arr[i];
			}
			
			System.out.println(result + 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}