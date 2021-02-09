package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

	static int T, N, M;
	static int[] snacks;
	static int[] selected;
	static int result = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(tokenizer.nextToken());
			M = Integer.parseInt(tokenizer.nextToken());
			snacks = new int[N];
			selected = new int[2];
			result = -1;
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(tokenizer.nextToken());
			}
			makeComb(0, 0);
			output.append("#"+tc+" "+result+"\n");
		}
		System.out.println(output.toString());
	}

	static void makeComb(int cnt, int startIdx) {
		if (cnt == 2) {
			int sum = selected[0] + selected[1];
			if (sum<=M) {
				result = Math.max(result, sum);
			}
			return;
		}

		for (int i = startIdx; i < N; i++) {
			selected[cnt] = snacks[i];
			makeComb(cnt + 1, i + 1);
		}
	}

}
