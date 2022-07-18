package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 신입 사원
 * 
 * @see https://www.acmicpc.net/problem/1946
 * @author boolancpain
 */
public class Test1946 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// 테스트 케이스
			int t = Integer.parseInt(br.readLine());
			
			ArrayList<int[][]> cases = new ArrayList<>();
			
			for(int i = 0;i < t;i++) {
				// 지원자 수
				int n = Integer.parseInt(br.readLine());
				
				int[][] applicants = new int [n][2];
				
				for(int j = 0;j < n;j++) {
					String[] scores = br.readLine().split(" ");
					applicants[j][0] = Integer.parseInt(scores[0]);
					applicants[j][1] = Integer.parseInt(scores[1]);
				}
				
				cases.add(applicants);
			}
			
			for(int i = 0;i < t;i++) {
				int[][] applicants = cases.get(i);
				
				// 서류심사 성적으로 오름차순 정렬
				Arrays.sort(applicants, (a1, a2) -> a1[0] - a2[0]);
				int cnt = 0;
				
				int min = 0;
				
				for(int j = 0;j < applicants.length;j++) {
					int[] target = applicants[j];
					
					// 서류심사 성적으로 정렬되어 있기 때문에 면접 성적이 최소값 보다 적어야 채용
					// (서류, 면접 성적이 하나라도 떨어지지 않아야 하는 조건)
					if(j == 0 || min > target[1]) {
						cnt++;
						min = target[1];
					}
				}
				
				System.out.println(cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}