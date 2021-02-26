package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/10026
 * @mem 12368
 * @time 104
 * @caution
 */

public class Solution_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] isNot, is;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		isNot = new boolean[N][N];
		is = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = input.readLine().toCharArray();
		}

		int isCount = 0, isNotCount = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!isNot[r][c]) {
					solve(r, c, isNot, false);
					isNotCount++;
				}
				if (!is[r][c]) {
					solve(r, c, is, true);
					isCount++;
				}
			}
		}

		System.out.println(isNotCount + " " + isCount);
	}

	static void solve(int r, int c, boolean[][] arr, boolean is) { // 색맹이면 true, 색맹이 아니면 false

		char color1 = map[r][c];
		char color2 = map[r][c];
		if (is) {
			if (color1 == 'R') {
				color2 = 'G';
			} else if (color1 == 'G') {
				color2 = 'R';
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { r, c });
		arr[r][c] = true;

		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];

			for (int i = 0; i < dir.length; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (!arr[nx][ny] && (map[nx][ny] == color1 || map[nx][ny] == color2)) {
					arr[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
	}

}
