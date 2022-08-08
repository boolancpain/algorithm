package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 강의실 배정
 * 
 * @see https://www.acmicpc.net/problem/11000
 * @author boolancpain
 */
public class Test11000 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n][2];
			for(int i = 0;i < n;i++) {
				String str = br.readLine();
				
				arr[i][0] = Integer.parseInt(str.split(" ")[0]);
				arr[i][1] = Integer.parseInt(str.split(" ")[1]);
			}
			
			// 강의 시작, 종료 오름차순 정렬
			Arrays.sort(arr, (i1, i2) -> {
				if(i1[0] == i2[0]) {
					return i1[1] - i2[1];
				} else {
					return i1[0] - i2[0];
				}
			});
			
			// 종료시간을 저장한 큐
			PriorityQueue<Integer> q = new PriorityQueue<>();
			// 첫 강의의 종료시간 입력
			q.offer(arr[0][1]);
			
			for(int i = 1;i < arr.length;i++) {
				// 가장 이른 강의 종료보다 크거나 같으면 종료 시간을 바꿈
				if(q.peek() <= arr[i][0]) {
					q.poll();
				}
				q.offer(arr[i][1]);
			}
			
			System.out.println(q.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}