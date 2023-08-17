package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 듣보잡
 * 
 * @see https://www.acmicpc.net/problem/1764
 * @author boolancpain
 */
public class Test1764 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		
		String[] dutdo = new String[n];
		String[] bodo = new String[m];
		for(int i = 0;i < n;i++) {
			dutdo[i] = br.readLine();
		}
		for(int i = 0;i < m;i++) {
			bodo[i] = br.readLine();
		}
		
		Arrays.sort(dutdo);
		Arrays.sort(bodo);
		
		List<String> results = new ArrayList<>();
		for(int i = 0, j = 0;i < n && j < m;) {
			int comp = dutdo[i].compareTo(bodo[j]);
			if(comp < 0) {
				i++;
			} else if(comp > 0) {
				j++;
			} else {
				results.add(dutdo[i]);
				i++;
				j++;
			}
		}
		
		// sort
		System.out.println(results.size());
		results.forEach(System.out::println);
	}
}