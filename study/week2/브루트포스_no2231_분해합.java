package baekjoon.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_no2231_분해합 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokenizer;

		int N = Integer.parseInt(input.readLine());
		int result = 0;

		for (int i = 1; i < N; i++) {
			int temp = i;
			int sum = i;
			while (temp / 10 != 0) {
				sum += temp % 10;
				temp /= 10;
			}
			sum += temp;

			if (sum == N) {
				result = i;
				break;
			}
		}

		System.out.println(result);
		
	}

}
