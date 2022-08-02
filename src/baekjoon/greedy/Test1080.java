package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 행렬
 * 
 * @see https://www.acmicpc.net/problem/1080
 * @author boolancpain
 */
public class Test1080 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String input = br.readLine();
			int n = Integer.parseInt(input.split(" ")[0]);
			int m = Integer.parseInt(input.split(" ")[1]);
			
			int[][] a = new int[n][m];
			int[][] b = new int[n][m];
			
			for(int i = 0;i < n;i++) {
				String[] arr = br.readLine().split("");
				for(int j = 0;j < m;j++) {
					a[i][j] = Integer.parseInt(arr[j]);
				}
			}
			for(int i = 0;i < n;i++) {
				String[] arr = br.readLine().split("");
				for(int j = 0;j < m;j++) {
					b[i][j] = Integer.parseInt(arr[j]);
				}
			}
			
			int result = 0;
			
			// 모든 요소를 탐색하며 비교함
			Loop:
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < m;j++) {
					// 동일 위치 요소가 다를때
					if(a[i][j] != b[i][j]) {
						// 더이상 변환할 수 없는 위치인 경우 -1 리턴
						if(i > n - 3 || j > m - 3) {
							result = -1;
							break Loop;
						} else {
							result++;
							// 해당 위치부터 3칸의 요소를 변환함
							for(int k = i;k < i + 3;k++) {
								for(int l = j;l < j + 3;l++) {
									// 0, 1 반전
									a[k][l] = a[k][l] ^ 1;
								}
							}
						}
					}
				}
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}