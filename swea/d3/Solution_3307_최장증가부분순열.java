package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3307_최장증가부분순열 {

	static int T, N;
	static int[] arr, LIS;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			arr = new int[N];
			LIS = new int[N];
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(tokenizer.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j] && LIS[j] + 1 > LIS[i]) {
						LIS[i] = LIS[j] + 1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
//			System.out.println(Arrays.toString(LIS));
			output.append("#" + tc + " " + max + "\n");
		}
		System.out.println(output.toString());
	}

}
