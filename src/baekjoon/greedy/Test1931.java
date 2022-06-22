package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 회의실 배정
 * 
 * @see https://www.acmicpc.net/problem/1931
 * @author boolancpain
 */
public class Test1931 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[][] inputs = new int[n][2];
			for(int i = 0;i < n;i++) {
				inputs[i][0] = sc.nextInt();
				inputs[i][1] = sc.nextInt();
			}
			
			Arrays.sort(inputs, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						return o1[0] - o2[0];
					} else {
						return o1[1] - o2[1];
					}
				}
			});
			
			int answer = 0;
			int end = 0;
			for(int i = 0;i < inputs.length;i++) {
				if(end <= inputs[i][0]) {
					answer++;
					end = inputs[i][1];
				}
			}
			
			System.out.println(answer);
		}
	}
}