package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 4.
 * @author user
 * @see https://www.acmicpc.net/problem/6593
 * @mem 14963
 * @time 140
 * @caution
 */

public class Solution_6593_상범빌딩 {

	static int L, R, C;
	static char[][][] building;
	static int startL, startR, startC;
	static int endL, endR, endC;
	static int[][] dir = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		while (true) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			L = Integer.parseInt(tokenizer.nextToken());
			R = Integer.parseInt(tokenizer.nextToken());
			C = Integer.parseInt(tokenizer.nextToken());
			building = new char[L][R][C];

			if (L == 0 && R == 0 && C == 0) { // 탈출 조건
				break;
			}

			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					building[l][r] = input.readLine().toCharArray();
					for (int c = 0; c < C; c++) {
						if (building[l][r][c] == 'S') {
							startL = l;
							startR = r;
							startC = c;
						} else if (building[l][r][c] == 'E') {
							endL = l;
							endR = r;
							endC = c;
						}
					}
				}
				input.readLine();
			}

			int result = bfs();
			if (result == -1) {
				output.append("Trapped!\n");
			} else {
				output.append("Escaped in " + result + " minute(s).\n");
			}
		}

		System.out.println(output.toString());
	}

	static int bfs() {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { startL, startR, startC });
		building[startL][startR][startC] = 'x';

		int time = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			while (size-- > 0) {
				int curL = queue.peek()[0];
				int curR = queue.peek()[1];
				int curC = queue.poll()[2];

				for (int i = 0; i < dir.length; i++) {
					int newL = curL + dir[i][0];
					int newR = curR + dir[i][1];
					int newC = curC + dir[i][2];

					if (newL < 0 || newL >= L || newR < 0 || newR >= R || newC < 0 || newC >= C) {
						continue;
					}

					if (building[newL][newR][newC] == 'E') {
						return time + 1;
					} else if (building[newL][newR][newC] == '.') {
						queue.add(new int[] { newL, newR, newC });
						building[newL][newR][newC] = 'x';
					}
				}
			}
			time++;
		}

		return -1;
	}

}
