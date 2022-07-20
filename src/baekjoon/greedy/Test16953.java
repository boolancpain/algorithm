package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A → B
 * 
 * @see https://www.acmicpc.net/problem/16953
 * @author boolancpain
 */
public class Test16953 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String input = br.readLine();
			
			long a = Integer.parseInt(input.split(" ")[0]);
			long b = Integer.parseInt(input.split(" ")[1]);
			
			int result = 1;
			
			while(a != b) {
				// a가 커진 경우 종료
				if(a > b) {
					result = -1;
					break;
				}
				
				if(b % 10 == 1) {
					// 끝자리가 1인 경우 10으로 나눔
					b /= 10;
				} else if(b % 2 == 0) {
					// 끝자리가 1이 아니고, 2로 나누어 떨어지는 경우 2로 나눔
					b /= 2;
				} else {
					// 끝자리가 1이 아니고, 2로 나누어 떨어지지 않는 경우 종료
					result = - 1;
					break;
				}
				
				result++;
			}
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}