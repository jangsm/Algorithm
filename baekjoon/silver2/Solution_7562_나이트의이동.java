package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//class Pair {
//	int x;
//	int y;
//
//	public Pair(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//}

public class Solution_7562_나이트의이동 {

	static int T, L, startX, startY, endX, endY;
	static boolean[][] chess;
	static int[][] dir = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			L = Integer.parseInt(input.readLine());
			chess = new boolean[L][L];

			tokenizer = new StringTokenizer(input.readLine(), " ");
			startX = Integer.parseInt(tokenizer.nextToken());
			startY = Integer.parseInt(tokenizer.nextToken());

			tokenizer = new StringTokenizer(input.readLine(), " ");
			endX = Integer.parseInt(tokenizer.nextToken());
			endY = Integer.parseInt(tokenizer.nextToken());

			bfs(new Pair(startX, startY));
		}

		System.out.println(output.toString());
	}

	static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(p);
		chess[p.x][p.y] = true;

		int depth = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			while (size-- > 0) {
				
				Pair first = queue.poll();

				if (first.x == endX && first.y == endY) {
					output.append(depth + "\n");
					break;
				}
				
				for (int i = 0; i < 8; i++) {
					int newX = first.x + dir[i][0];
					int newY = first.y + dir[i][1];

					if (newX < 0 || newX >= L || newY < 0 || newY >= L) {
						continue;
					}

					if (!chess[newX][newY]) {
						chess[newX][newY] = true;
						queue.offer(new Pair(newX, newY));
					}
				}
			}
			depth++;
		}
	}

}
