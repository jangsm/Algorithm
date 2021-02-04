package ps.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int N = Integer.parseInt(tokenizer.nextToken());
			int M = Integer.parseInt(tokenizer.nextToken());

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
				}
			}

			int maxX = N - M;
			int maxY = N - M;
			
			int result = 0;
			
			for(int i = 0; i<=maxX; i++) {
				for(int j=0; j<=maxY; j++) {
					int sum = 0;
					for(int a = i; a<i+M; a++) {
						for(int b = j; b<j+M; b++) {
							sum += map[a][b];
						}
					}
					if (sum>result) {
						result = sum;
					}
				}
			}
			
			output.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(output.toString());
	}

}
