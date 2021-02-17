package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 17.
 * @author user
 * @see https://www.acmicpc.net/problem/1992
 * @mem 12560
 * @time 92
 * @caution 재귀적으로 합쳐지는 부분에서 문자열이 같으면 전체가 하나로 합쳐짐
 * ex) 0100 0100 0100 0100 이면 0100으로 합쳐진다 => length조건 추가
 */

public class Solution_1992_쿼드트리 {

	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = input.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j);
			}
		}

		System.out.println(recursive(0, 0, N));
	}

	static String recursive(int startX, int startY, int n) {
		if (n == 1) {
			return String.valueOf(map[startX][startY]);
		}

		String area1 = recursive(startX, startY, n / 2);
		String area2 = recursive(startX, startY + n / 2, n / 2);
		String area3 = recursive(startX + n / 2, startY, n / 2);
		String area4 = recursive(startX + n / 2, startY + n / 2, n / 2);

		String answer = null;
		if (area1.length() == 1 && area1.equals(area2) && area2.equals(area3) && area3.equals(area4)) {
			// length에 대한 조건이 없으면 재귀를 반복하면서 0100이 반복되더라도 하나로 합치게 된다
			answer = area1;
		} else {
			answer = "(" + area1 + area2 + area3 + area4 + ")";
		}
		return answer;
	}

}
