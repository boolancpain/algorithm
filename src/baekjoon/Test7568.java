package baekjoon;

import java.util.Scanner;

/**
 * 덩치
 * 
 * @see https://www.acmicpc.net/problem/7568
 * @author boolancpain
 */
public class Test7568 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			int[][] persons = new int[n][2];
			
			int[] ranks = new int[n];
			
			for(int[] person : persons) {
				person[0] = sc.nextInt();
				person[1] = sc.nextInt();
			}
			
			for(int i = 0;i < ranks.length;i++) {
				ranks[i] = 1;
			}
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++) {
					if(i != j) {
						if(persons[i][0] < persons[j][0] && persons[i][1] < persons[j][1]) {
							ranks[i] += 1;
						}
					}
				}
			}
			
			for(int rank : ranks) {
				System.out.print(rank + " ");
			}
		}
	}
}