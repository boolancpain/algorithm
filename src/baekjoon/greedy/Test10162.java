package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 전자레인지
 * 
 * @see https://www.acmicpc.net/problem/10162
 * @author boolancpain
 */
public class Test10162 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int time = Integer.parseInt(br.readLine());
			
			int[] result = new int[3];
			
			int A = 5 * 60;
			int B = 1 * 60;
			int C = 10;
			
			if(time >= A) {
				result[0] += time / A;
				time = time % A;
			}
			if(time >= B) {
				result[1] += time / B;
				time = time % B;
			}
			if(time >= C) {
				result[2] += time / C;
				time = time % C;
			}
			if(time != 0) {
				System.out.println(-1);
			} else {
				System.out.println(result[0] + " " + result[1] + " " + result[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}