package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1074_Z {

	static int N, r, c;
	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());

		solve(0, N, r, c);

		System.out.println(result);
	}

	static void solve(int startIdx, int N, int r, int c) {

		if (N == 1) {
			int num = 0;
			if (r == 0 && c == 0) {
				num = 0;
			} else if (r == 0 && c == 1) {
				num = 1;
			} else if (r == 1 && c == 0) {
				num = 2;
			} else {
				num = 3;
			}
			result = startIdx + num;
			return;
		}

		int half = (int) Math.pow(2, N - 1);
		int max = 2 * half;
		if (r >= 0 && r < half && c >= 0 && c < half) { // 1번위치
			solve(startIdx, N - 1, r, c);
		} else if (r >= 0 && r < half && c >= half && c < max) { // 2번위치
			solve(startIdx + half * half, N - 1, r, c - half);
		} else if (r >= half && r < max && c >= 0 && c < half) { // 3번위치
			solve(startIdx + 2 * half * half, N - 1, r - half, c);
		} else { // 4번위치
			solve(startIdx + 3 * half * half, N - 1, r - half, c - half);
		}
	}

}
