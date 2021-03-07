package ps.study.practiceTest.date210307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 7.
 * @author user
 * @see https://www.acmicpc.net/problem/1904
 * @mem 58164
 * @time 260
 * @caution
 */

public class Solution_1904_01타일 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		arr = new int[1000001];

		System.out.println(solve(N)%15746);
	}

	static int solve(int n) {
		if (n == 1) {
			return arr[1] = 1;
		} else if (n == 2) {
			return arr[2] = 2;
		} else if (arr[n] != 0) {
			return arr[n];
		} else {
			return arr[n] = (solve(n - 1) + solve(n - 2))%15746;
		}
	}

}
