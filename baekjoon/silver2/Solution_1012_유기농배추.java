package ps.bj.s2;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Solution_1012_유기농배추 {

	static int T, M, N, K;
	static int[][] farm;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			M = Integer.parseInt(tokenizer.nextToken());
			N = Integer.parseInt(tokenizer.nextToken());
			K = Integer.parseInt(tokenizer.nextToken());
			farm = new int[M][N];

			for (int k = 0; k < K; k++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				int x = Integer.parseInt(tokenizer.nextToken());
				int y = Integer.parseInt(tokenizer.nextToken());
				farm[x][y] = 1;
			}

			int result = 0;
			for (int m = 0; m < M; m++) {
				for (int n = 0; n < N; n++) {
					if (farm[m][n] == 1) {
						bfs(new Pair(m, n));
						result++;
					}
				}
			}

			output.append(result + "\n");
		}
		System.out.println(output.toString());

	}

	static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(p);
		farm[p.x][p.y] = -1;

		while (!queue.isEmpty()) {

			Pair first = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = first.x + dir[i][0];
				int newY = first.y + dir[i][1];

				if (newX < 0 || newX >= M || newY < 0 || newY >= N) {
					continue;
				}

				if (farm[newX][newY] == 1) {
					farm[newX][newY] = -1;
					queue.offer(new Pair(newX, newY));
				}
			}
		}
	}

}
