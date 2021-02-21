package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 21.
 * @author user
 * @see https://www.acmicpc.net/problem/10163
 * @mem 13156
 * @time 108
 * @caution
 */

public class Solution_b1_10163_색종이 {

	static int N;
	static int[][] map = new int[101][101];
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		result = new int[N + 1];
		int index = 1;
		for (int i = 0; i < N; i++, index++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			int width = Integer.parseInt(tokenizer.nextToken());
			int height = Integer.parseInt(tokenizer.nextToken());

			for (int a = x; a < x + width; a++) {
				for (int b = y; b < y + height; b++) {
					map[a][b] = index;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				for (int idx = 1; idx < index; idx++) {
					if (map[i][j] == idx) {
						result[idx]++;
					}
				}
			}
		}

		for (int i = 1; i < result.length; i++) {
			output.append(result[i] + "\n");
		}

		System.out.println(output.toString());
	}

}
