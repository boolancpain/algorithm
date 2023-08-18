package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 통나무 건너뛰기
 * 
 * @see https://www.acmicpc.net/problem/11497
 * @author boolancpain
 */
public class Test11497 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] inputs = new int[n][];
		for(int i = 0;i < n;i++) {
			int k = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[k];
			for(int j = 0;j < k;j++) {
				arr[j] = Integer.parseInt(input[j]);
			}
			inputs[i] = arr;
		}
		
		for(int i = 0;i < inputs.length;i++) {
			Arrays.sort(inputs[i]);
			
			if(inputs[i][0] == inputs[i][inputs[i].length - 1]) {
				System.out.println(0);
				continue;
			}
			
			int maxDiff = 0;
			int left = 0, right = 0;
			for(int j = 0;j < inputs[i].length;j++) {
				if(j == 0) {
					left = inputs[i][j];
					right = inputs[i][j];
				} else {
					if(j % 2 == 0) {
						int diff = inputs[i][j] - right;
						maxDiff = diff > maxDiff ? diff : maxDiff;
						right = inputs[i][j];
					} else {
						int diff = inputs[i][j] - left;
						maxDiff = diff > maxDiff ? diff : maxDiff;
						left = inputs[i][j];
					}
				}
			}
			
			System.out.println(maxDiff);
		}
	}
}