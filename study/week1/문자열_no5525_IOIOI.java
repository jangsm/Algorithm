package baekjoon.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_no5525_IOIOI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String str = br.readLine();
		br.close();
		str = str.substring(0, M);

		StringBuilder p = new StringBuilder("");
		for (int i = 0; i < 2 * N + 1; i++) {
			if (i % 2 == 0) {
				p.append('I');
			} else {
				p.append('O');
			}
		}

//		int answer = 0;
//		int fromIndex = 0;
//		while (str.indexOf(p.toString(), fromIndex) != -1) {
//			fromIndex = str.indexOf(p.toString(), fromIndex) + 1;
//			answer++;
//		}

		int answer = KMP(str, p.toString());

		System.out.println(answer);
	}

	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		for (int i = 0; i < pi.length; i++) {
			pi[i] = 0;
		}
		int j = 0; // 이동하면서 검사할 인덱스
		for (int i = 1; i < pattern.length(); i++) {  // KMP와 비슷한 방식으로 찾으면 찾는 시간을 줄일 수 있다.
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}

			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j; // 일치하면 계속 뒤로 가면서 검사하므로 현재 검사한 인덱스만큼이 접두사/접미사로서 겹치는 부분이다 -> j는 index로 0부터 시작하므로 j+1
			}
		}
		return pi;
	}

	public static int KMP(String text, String pattern) {
		int answer = 0;
		int[] pi = getPi(pattern);

		int j = 0; // pattern 검사 index

		for (int i = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) { // 패턴과 텍스트가 일치하지 않는 순간 pi배열을 이용하여 비교할 인덱스 변경
																   // while을 이용하여 일치구간 or 맨 앞까지
				j = pi[j - 1];
			}

			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) { // 패턴 맨 끝위치로 모두 일치시
					answer++;
					j = pi[j]; // 해당 범위에 찾을 문자열이 더 있을 수 있기 때문에
				} else {
					j++;
				}
			}
		}
		return answer;
	}

}
