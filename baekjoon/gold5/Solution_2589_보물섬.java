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
 * @see https://www.acmicpc.net/problem/2589
 * @mem 163104
 * @time 464
 * @caution 모든 L에 대해 dfs -> 이 방법이 최선일까..?? -> 출발점, 도착점이 정해지지않아 브루트포스가 최선인듯하다..
 */

public class Solution_2589_보물섬 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = input.readLine().toCharArray();
		}

		int result = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 'L') {
					result = Math.max(result, solve(r, c));
				}
			}
		}
		
		System.out.println(result);
	}

	static int solve(int r, int c) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;

		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int x = queue.peek()[0];
				int y = queue.poll()[1];

				for (int i = 0; i < dir.length; i++) {
					int nx = x + dir[i][0];
					int ny = y + dir[i][1];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						continue;
					}

					if (map[nx][ny] == 'L' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
			time++;
		}
		
		return --time;
	}

}
