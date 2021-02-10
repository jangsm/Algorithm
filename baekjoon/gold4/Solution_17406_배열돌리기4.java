package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_17406_배열돌리기4 {

	static int N, M, K;
	static int[][] map;
	static int[][] real;
	static int[][] order;
	static int[] arr;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
//		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M];
		real = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
				real[i][j] = map[i][j];
			}
		}

		order = new int[K][3];
		for (int i = 0; i < K; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			order[i][0] = Integer.parseInt(tokenizer.nextToken()); // r
			order[i][1] = Integer.parseInt(tokenizer.nextToken()); // c
			order[i][2] = Integer.parseInt(tokenizer.nextToken()); // s
		}

//		rotate(order[0][0], order[0][1], order[0][2]);
//		for(int[] sub : map) {
//			System.out.println(Arrays.toString(sub));
//		}

		arr = new int[K]; // 순열을 만들기 위한 배열
		for (int i = 0; i < K; i++) {
			arr[i] = i;
		}
		perm(0, new int[K], new boolean[K]);
		System.out.println(result);

	}

	static void perm(int cnt, int[] choosed, boolean[] visited) {
		if (cnt == K) {
			for (int i = 0; i < N; i++) { // 값 초기화
				for (int j = 0; j < M; j++) {
					map[i][j] = real[i][j];
				}
			}
			for (int i = 0; i < choosed.length; i++) {
				int index = choosed[i];
				rotate(order[index][0], order[index][1], order[index][2]);
			}

			for (int[] subArr : map) {
//				System.out.println(Arrays.toString(subArr));
				int tempResult = 0;
				for (int i : subArr) {
					tempResult += i;
				}
				result = Math.min(result, tempResult);
			}
//			System.out.println();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (visited[i]) {
				continue;
			}
			choosed[cnt] = arr[i];
			visited[i] = true;
			perm(cnt + 1, choosed, visited);
			visited[i] = false;
		}
	}

	static void rotate(int r, int c, int s) {

		int startX = r - s - 1;
		int endX = r + s - 1;
		int startY = c - s - 1;
		int endY = c + s - 1;

		int T = Math.min(endX - startX, endY - startY) / 2;
		int N = endX - startX + 1;
		int M = endY - startY + 1;

//		System.out.println(startX + ", " + endX + ", " + N + ", " + startY + ", " + endY + ", " + M);

		for (int t = 0; t < T; t++) {
			int keep = map[startX + t][endY - t];

			// 맨위 오른쪽이동
			for (int y = M - 1 - 1 - t; y >= t; y--) {
				map[startX + t][startY + y + 1] = map[startX + t][startY + y];
			}
			// 왼쪽 위로이동
			for (int x = t + 1; x <= N - 1 - t; x++) {
				map[startX + x - 1][startY + t] = map[startX + x][startY + t];
			}
			// 아래쪽 왼쪽이동
			for (int y = t + 1; y <= M - 1 - t; y++) {
				map[startX + N - 1 - t][startY + y - 1] = map[startX + N - 1 - t][startY + y];
			}
			// 오른쪽 아래로이동
			for (int x = M - 1 - 1 - t; x >= t; x--) {
				map[startX + x + 1][startY + M - 1 - t] = map[startX + x][startY + M - 1 - t];
			}

			map[startX + 1 + t][startY + M - 1 - t] = keep;
		}
	}

}
