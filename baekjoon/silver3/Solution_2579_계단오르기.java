package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/2579
 * @mem 11628
 * @time 76
 * @caution
 */

public class Solution_2579_계단오르기 {

	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}

		dp[1] = arr[1];
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		if (N >= 3) {
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
			}
		}

//		System.out.println(Arrays.toString(arr));
		System.out.println(dp[N]);

	}

}
