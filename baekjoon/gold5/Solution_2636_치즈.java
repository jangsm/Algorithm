package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 24.
 * @author user
 * @see https://www.acmicpc.net/problem/2636
 * @mem 16168
 * @time 132
 * @caution
 */

public class Solution_2636_치즈 {

	static int N, M;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}

		List<int[]> cheese = new ArrayList<int[]>();
		List<Integer> count = new ArrayList<>();
		while(true) {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						setHoleOrBoundary(i, j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						for (int k = 0; k < dir.length; k++) {
							int newX = i + dir[k][0];
							int newY = j + dir[k][1];

							if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
								continue;
							}

							if (map[newX][newY] == 9) { // 치즈 테두리면
								cheese.add(new int[] {i, j});
								break;
							}
						}
					}
				}
			}
			
			if(cheese.size()==0) {
				break;
			}
			
			for(int i=0; i<cheese.size(); i++) {
				map[cheese.get(i)[0]][cheese.get(i)[1]] = 9;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 1) {
						map[i][j] = 0; 
					}
				}
			}
			
			count.add(cheese.size());
			cheese.clear();
		}
		
		System.out.println(count.size() + "\n" + count.get(count.size()-1));
	}

	static void setHoleOrBoundary(int startX, int startY) {

		boolean[][] visited = new boolean[N][M];

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { startX, startY });
		visited[startX][startY] = true;

		boolean holeFlag = true;
		while (!queue.isEmpty()) {
			int curX = queue.peek()[0];
			int curY = queue.poll()[1];

			for (int i = 0; i < dir.length; i++) {
				int newX = curX + dir[i][0];
				int newY = curY + dir[i][1];

				if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
					holeFlag = false;
					continue;
				}

				if (map[newX][newY] == 0 && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new int[] { newX, newY });
				}
			}
		}

		if (holeFlag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						map[i][j] = 2;
					}
				}
			}
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						map[i][j] = 9;
					}
				}
			}
		}
	}

}
