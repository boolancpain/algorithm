package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 거스름돈
 * 
 * @see https://www.acmicpc.net/problem/5585
 * @author boolancpain
 */
public class Test5585 {
	static int result;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int money = 1000 - Integer.parseInt(br.readLine());
			
			money = calc(money, 500);
			money = calc(money, 100);
			money = calc(money, 50);
			money = calc(money, 10);
			money = calc(money, 5);
			money = calc(money, 1);
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int calc(int money, int unit) {
		result += money / unit;
		return money % unit;
	}
}