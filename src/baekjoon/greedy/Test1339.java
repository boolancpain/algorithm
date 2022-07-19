package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 단어 수학
 * 
 * @see https://www.acmicpc.net/problem/1339
 * @author boolancpain
 */
public class Test1339 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int n = Integer.parseInt(br.readLine());
			
			String[] inputs = new String[n];
			
			for(int i = 0;i < n;i++) {
				inputs[i] = br.readLine();
			}
			
			ArrayList<String> tokens = new ArrayList<>();
			
			// 입력값을 자리수별로 토큰으로 만든다. ABC = 100A + 10B + C
			for(String input : inputs) {
				String[] inputElements = input.split("");
				
				for(int i = 0;i < inputElements.length;i++) {
					tokens.add((int) Math.pow(10, (inputElements.length - 1 - i)) + inputElements[i]);
				}
			}
			
			HashMap<String, Integer> tokenMap = new HashMap<>();
			
			// 토큰의 숫자들을 합친다. 100A, 10B, C, 100B, 10C, A = 101A, 110B, 11C
			for(String token : tokens) {
				String number = token.substring(0, token.length() - 1);
				String alphabet = token.substring(token.length() - 1);
				if(tokenMap.containsKey(alphabet)) {
					tokenMap.put(alphabet, Integer.parseInt(number) + tokenMap.get(alphabet));
				} else {
					tokenMap.put(alphabet, Integer.parseInt(number));
				}
			}
			
			int sum = 0;
			int seq = 9;
			
			// 내림차순 정렬 후 높은 숫자를 9부터 곱해 더한다.
			List<Integer> values = tokenMap.values().stream()
					.sorted((i1, i2) -> i2 - i1)
					.collect(Collectors.toList());
			
			for(Integer i : values) {
				sum += seq-- * i;
			}
			
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}