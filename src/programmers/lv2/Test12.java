package programmers.lv2;

import java.util.Arrays;

/**
 * lv.2 요격 시스템
 * 
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/181188
 * @author boolancpain
 */
public class Test12 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][] targets = new int[][] {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		int expect = 3;
		int result = solution.solution(targets);
		System.out.println(String.format("[테스트 케이스 2] : %s", expect == result ? "통과" : "실패"));
	}
	
	public static class Solution {
		public int solution(int[][] targets) {
			// 오름차순 정렬
			Arrays.sort(targets, (a1, a2) -> 
				a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
			
			// targets 배열의 크기가 1이상이라는 전제가 주어졌으므로 1부터 시작
			int answer = 1;
			// 요격할 y축 미사일의 범위를 지정
			int start = 0;
			int end = Integer.MAX_VALUE;
			
			for(int[] target : targets) {
				if(end <= target[0]) {
					// 현재 요격할 y축 미사일의 범위를 벗어난 경우 미사일 수 1개 추가
					answer++;
					start = target[0];
					end = target[1];
				} else {
					// 현재 요격할 y축 미사일의 범위를 좁힌다.
					start = Math.max(start, target[0]);
					end = Math.min(end, target[1]);
				}
			}
			
			return answer;
		}
	}
}