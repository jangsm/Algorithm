package baekjoon.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_no2798_블랙잭 {

	static int N, M;
	static int result;
	static int[] cards;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokenizer;

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(input.readLine(), " ");
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int[] arr = new int[N]; // 완탐 돌릴 순열
//		Arrays.fill(arr, 0);
		comb(cards, arr, 0, N, 3);
		System.out.println(result);
	}

	private static void comb(int[] cards, int[] arr, int index, int n, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 1) {
					sum += cards[i];
				}
			}
			if ((M - sum) >= 0 && (M - sum) < (M - result)) {
				result = sum;
			}
			return;
		}

		if (index == n) {
			return;
		}

		arr[index] = 1;
		comb(cards, arr, index + 1, n, r - 1);

		arr[index] = 0;
		comb(cards, arr, index + 1, n, r);
	}

}
