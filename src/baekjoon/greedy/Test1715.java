package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기
 * 
 * @see https://www.acmicpc.net/problem/1715
 * @author boolancpain
 */
public class Test1715 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			// 우선순위 큐
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			
			for(int i = 0;i < n;i++) {
				// 큐에 추가
				queue.add(Integer.parseInt(br.readLine()));
			}
			
			long sum = 0;
			
			// 큐에 2개 이상의 카드뭉치가 있어야 비교
			while(queue.size() > 1) {
				int a = queue.poll();
				int b = queue.poll();
				
				int temp = a + b;
				
				sum += temp;
				// 다시 큐에 추가
				queue.add(temp);
			}
			
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}