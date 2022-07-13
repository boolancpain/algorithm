package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 수들의 합
 * 
 * @see https://www.acmicpc.net/problem/1789
 * @author boolancpain
 */
public class Test1789 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			long s = Long.parseLong(br.readLine());
			
			int n = 0;
			int num = 1;
			long sum = 0;
			
			while(sum < s) {
				sum += num++;
				n++;
				// 다음 자연수를 더했을때 s보다 크다면 종료
				if(s < num + sum) {
					break;
				}
			}
			
			System.out.println(n);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}