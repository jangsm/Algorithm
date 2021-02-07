package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_15654_N과M_5 {
	
	static int[] data;
	static int N, M;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		data = new int[N];

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(data);

		makePerm(0, new int[M], new boolean[N]);
		System.out.println(output.toString());
	}

	static void makePerm(int cnt, int[] choosed, boolean[] isSelected) {
		if (cnt == M) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}

		for (int i = 0; i < data.length; i++) {
			if (isSelected[i]) {
				continue;
			}

			choosed[cnt] = data[i];
			isSelected[i] = true;
			makePerm(cnt + 1, choosed, isSelected);
			isSelected[i] = false;
		}
	}
}
