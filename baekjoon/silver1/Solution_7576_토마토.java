package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7576_토마토 {

	static int N, M;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		M = Integer.parseInt(tokenizer.nextToken());
		N = Integer.parseInt(tokenizer.nextToken());
		map = new int[N][M];

		Queue<int[]> queue = new ArrayDeque<int[]>();
		for (int r = 0; r < N; r++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokenizer.nextToken());

				if (map[r][c] == 1) {
					queue.offer(new int[] { r, c });
				}
			}
		}
		
		System.out.println(solve(queue));

	}

	static int solve(Queue<int[]> queue) {

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

					if (map[nx][ny] == 0) {
						map[nx][ny] = 1;
						queue.offer(new int[] { nx, ny });
					}
				}
			}
			time++;
		}
		
		for(int r = 0; r<N; r++) {
			for(int c = 0; c<M; c++) {
				if (map[r][c]== 0 ) {
					return -1;
				}
			}
		}
		
		return --time;
	}

}
