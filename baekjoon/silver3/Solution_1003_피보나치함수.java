package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 8.
 * @author user
 * @see https://www.acmicpc.net/problem/1003
 * @mem 11496
 * @time 136
 * @caution
 */

public class Solution_1003_피보나치함수 {

	static int T, N;
	static int[] fibo;
	static int[][] cnt;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			fibo = new int[N + 1];
			cnt = new int[N + 1][2];
			fibonacci(N);
			output.append(cnt[N][0] + " " + cnt[N][1] + "\n");
		}

		System.out.println(output.toString());
	}

	static void fibonacci(int n) {
		if (n == 0) {
			fibo[0] = 0;
			cnt[0][0] = 1;
			cnt[0][1] = 0;
		} else if (n == 1) {
			fibo[1] = 1;
			cnt[1][0] = 0;
			cnt[1][1] = 1;
		} else {
			fibo[0] = 0;
			cnt[0][0] = 1;
			cnt[0][1] = 0;
			
			fibo[1] = 1;
			cnt[1][0] = 0;
			cnt[1][1] = 1;
			
			for (int i = 2; i <= n; i++) {
				fibo[i] = fibo[i - 1] + fibo[i - 2];
				cnt[i][0] = cnt[i - 1][0] + cnt[i - 2][0];
				cnt[i][1] = cnt[i - 1][1] + cnt[i - 2][1];
			}
		}
	}
}
