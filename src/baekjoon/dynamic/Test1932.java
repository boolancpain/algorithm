package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정수 삼각형
 * 
 * @see https://www.acmicpc.net/problem/1932
 * @author boolancpain
 */
public class Test1932 {
	static int[][] DP;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] triangle = new int[n][n];
			
			for(int i = 0;i < n;i++) {
				String[] row = br.readLine().split(" ");
				for(int j = 0;j < row.length;j++) {
					triangle[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			DP = new int[n][n];
			
			// 탐색
			find(triangle, 0);
			
			System.out.println(DP[0][0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void find(int[][] triangle, int row) {
		// 마지막 행까지 Top-Down
		if(triangle.length - 1 > row) {
			// 탐색
			find(triangle, row + 1);
		}
		
		for(int i = 0;i <= row;i++) {
			// 맨 아랫줄인 경우
			if(triangle.length - 1 == row) {
				DP[row][i] = triangle[row][i];
			} else {
				// 대각선 왼쪽과 오른쪽(i, i+1) 중 큰 수와 더하기
				DP[row][i] = Math.max(DP[row + 1][i], DP[row + 1][i + 1]) + triangle[row][i];
			}
		}
	}
}