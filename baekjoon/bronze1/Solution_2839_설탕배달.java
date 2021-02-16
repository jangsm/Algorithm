package ps.bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2839_설탕배달 {

	static int N;
	static int result = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());

		int max5 = N / 5;
		while (max5 >= 0) {
			int remain5 = N - 5 * max5;
			if (remain5 % 3 == 0) {
				result = max5 + remain5 / 3;
				break;
			}
			max5--;
		}
		
		System.out.println(result);
	}

}
