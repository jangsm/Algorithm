package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 17.
 * @author user
 * @see https://www.acmicpc.net/problem/16936
 * @mem 211964
 * @time 708
 * @caution
 */

public class Solution_16936_나3곱2 {

	static int N;
	static long[] arr;
	static long[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		arr = new long[N];
		result = new long[N];
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(tokenizer.nextToken());
		}

		makePerm(0, new long[N], new boolean[N]);

		for (long r : result) {
			output.append(r + " ");
		}
		output.append("\n");
		System.out.println(output.toString());
	}

	static void makePerm(int cnt, long[] choosed, boolean[] visited) {

		if (cnt >= 2) {
			BigInteger a = new BigInteger(Long.toString(choosed[cnt - 2]));
			a = a.multiply(new BigInteger("2"));
			BigInteger b = new BigInteger(Long.toString(choosed[cnt - 1]));
			// BigInteger 비교는 compareTo -> 같으면 0, 다르면 1
			if (!(a.compareTo(b) == 0 || (choosed[cnt-2]%3==0 && choosed[cnt - 2] / 3 == choosed[cnt - 1]))) {
				return;
			}
		}

		if (cnt == N) {
			result = choosed.clone();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			choosed[cnt] = arr[i];
			visited[i] = true;
			makePerm(cnt + 1, choosed, visited);
			visited[i] = false;
		}
	}

}
