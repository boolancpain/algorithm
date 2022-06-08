package programmers.lv2;

/**
 * lv2. 문자열 압축
 * 
 * @see https://programmers.co.kr/learn/courses/30/lessons/60057
 * @author boolancpain
 */
public class Test1 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		// test case 1
		String s = "aabbaccc";
		int expect = 7;
		int result = solution.solution(s);
		System.out.println(String.format("테스트 케이스 1 expect : %s, result : %s : %s", expect, result, expect == result ? "통과" : "실패"));
		
		// test case 2
		s = "ababcdcdababcdcd";
		expect = 9;
		result = solution.solution(s);
		System.out.println(String.format("테스트 케이스 2 expect : %s, result : %s : %s", expect, result, expect == result ? "통과" : "실패"));
		/*
		*/
	}
	
	static class Solution {
		public int solution(String s) {
			// 3자 보다 작은 경우는 문자열 길이를 그대로 리턴
			if(s.length() < 3) {
				return s.length();
			}
			
			// 1. 압축할 때 입력값의 절반을 넘는 크기의 압축은 존재하지 않는다.
			int len = s.length();
			int compressibility = Math.round(len / 2);
			
			String result = s;
			
			// 2. 입력값의 절반 크기까지 순회하며 압축 테스트
			for(int i = 1;i <= compressibility;i++) {
				StringBuilder sb = new StringBuilder();
				
				int j = 0;
				int max = len - i;
				
				while(j < max) {
					// 탐색 토큰
					String token = s.substring(j, j + i);
					
					int start = j + i;
					int cnt = 1;
					
					while(token.equals(s.substring(start, start + i))) {
						// 탐색 회수 증가
						cnt++;
						// 탐색 인덱스 증가
						start += i;
						
						if(start + i >= max)
							break;
					}
					
					if(cnt <= 1) {
						sb.append(s.substring(j, j + 1));
						j++;
					} else {
						sb.append(cnt);
						sb.append(token);
						j = j + (i * cnt);
					}
				}
				
				// 최소 길이
				result = result.length() > sb.length() ? sb.toString() : result;
			}
			
			System.out.println("\t" + s);
			System.out.println("\t" + result);
			return result.length();
		}
	}
}