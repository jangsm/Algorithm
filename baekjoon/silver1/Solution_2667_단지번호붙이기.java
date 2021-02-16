package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 15.
 * @author user
 * @see https://www.acmicpc.net/problem/2667
 * @mem 11628
 * @time 80
 * @caution char -> int로 변환 신경쓰기 그냥 변경하면 아스키코드값이 들어간다
 * 			Character.getNumericValue
 */

public class Solution_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int count;
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = input.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}

		List<Integer> list = new ArrayList<Integer>(); // size를 담는다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					bfs(new Pair(i, j));
					count++;
					list.add(size);
					size = 0;
				}
			}
		}

		Collections.sort(list);

		output.append(count + "\n");
		for (int i = 0; i < list.size(); i++) {
			output.append(list.get(i) + "\n");
		}
		
		System.out.println(output.toString());
	}

	static void bfs(Pair p) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(p);
		map[p.x][p.y] = -1;
		size++;

		while (!queue.isEmpty()) {
			Pair first = queue.poll();

			for (int i = 0; i < dir.length; i++) {
				int newX = first.x + dir[i][0];
				int newY = first.y + dir[i][1];

				if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[newX].length) {
					continue;
				}

				if (map[newX][newY] == 1) {
					map[newX][newY] = -1;
					queue.offer(new Pair(newX, newY));
					size++;
				}
			}
		}
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
