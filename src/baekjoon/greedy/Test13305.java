package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 주유소
 * 
 * @see https://www.acmicpc.net/problem/13305
 * @author boolancpain
 */
public class Test13305 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			long[] distance = new long[n - 1];
			long[] town = new long[n];
			
			String[] distances = br.readLine().split(" ");
			for(int i = 0;i < distances.length;i++) {
				distance[i] = Integer.parseInt(distances[i]);
			}
			
			String[] towns = br.readLine().split(" ");
			for(int i = 0;i < towns.length;i++) {
				town[i] = Integer.parseInt(towns[i]);
			}
			
			long cost = 0;
			long prevCost = Integer.MAX_VALUE;
			for(int i = 0;i < distance.length;i++) {
				// 이전 도시와 현재 도시의 낮은 가격으로 비용을 추가
				prevCost = Math.min(prevCost, town[i]);
				cost += prevCost * distance[i];
			}
			
			System.out.println(cost);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}