package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 18.
 * @author user
 * @see https://www.acmicpc.net/problem/1987
 * @mem 301512
 * @time 2068
 * @caution
 */

public class Solution_1987_알파벳 {

	static int R, C, result = Integer.MIN_VALUE;
	static char[][] map;
//	static boolean[][] visited;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());

		map = new char[R][C];
//		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = input.readLine();
			for (int c = 0; c < line.length(); c++) {
				map[r][c] = line.charAt(c);
			}
		}

		solve(0, 0, 1, new HashSet<Character>());
		System.out.println(result);
	}

	static void solve(int x, int y, int depth, Set<Character> choosed) {

//		visited[x][y] = true;
		choosed.add(map[x][y]);
		result = Math.max(result, depth);
		outer: for (int i = 0; i < dir.length; i++) {
			int newX = x + dir[i][0];
			int newY = y + dir[i][1];

			if (newX < 0 || newX >= R || newY < 0 || newY >= C) {
				continue;
			}
			for (int j = 0; j < choosed.size(); j++) {
				if (choosed.contains(map[newX][newY])) {
					continue outer;
				}
			}
			
			solve(newX, newY, depth + 1, choosed);

//			if (!visited[newX][newY]) {
//				solve(newX, newY, depth + 1, choosed);
//			}

		}
//		visited[x][y] = false;
		choosed.remove(map[x][y]);
	}

}
