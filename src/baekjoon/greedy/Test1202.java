package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 보석 도둑
 * 
 * @see https://www.acmicpc.net/problem/1202
 * @author boolancpain
 */
public class Test1202 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String inputs = br.readLine();
			// 보석 개수
			int n = Integer.parseInt(inputs.split(" ")[0]);
			// 가방 개수
			int k = Integer.parseInt(inputs.split(" ")[1]);
			
			// 보석(무게, 가격)
			ArrayList<int[]> jewels = new ArrayList<>();
			
			// 보석 입력
			for(int i = 0;i < n;i++) {
				String input = br.readLine();
				int weight = Integer.parseInt(input.split(" ")[0]);
				int price = Integer.parseInt(input.split(" ")[1]);
				jewels.add(new int[] {weight, price});
			}
			
			// 보석 정렬(무게 오름차순 > 가격 내림차순)
			Collections.sort(jewels, (j1, j2) -> {
				if(j1[0] == j2[0]) {
					return j2[1] - j1[1];
				} else {
					return j1[0] - j2[0];
				}
			});
			
			// 가방
			ArrayList<Integer> bags = new ArrayList<>();
			// 가방 입력
			for(int i = 0;i < k;i++) {
				bags.add(Integer.parseInt(br.readLine()));
			}
			
			// 가방 무게 정렬(오름차순)
			Collections.sort(bags);
			
			// 보석 큐(가격 내림차순 > 무게 오름차순)
			PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> {
				if(arr1[1] == arr2[1]) {
					return arr1[0] - arr2[0];
				} else {
					return arr2[1] - arr1[1];
				}
			});
			
			long result = 0;
			
			for(int i = 0, j = 0;i < bags.size();i++) {
				// 보석 무게가 현재 가방에 담을 수 있는 무게보다 작거나 같으면 큐에 넣는다.
				while(j < n && jewels.get(j)[0] <= bags.get(i)) {
					queue.add(jewels.get(j++));
				}
				
				if(!queue.isEmpty()) {
					result += queue.poll()[1];
				}
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}