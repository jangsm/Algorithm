package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/2583
 * @mem 12364
 * @time 88
 * @caution
 */

public class Solution_2583_영역구하기 {

	static int M, N, K;
	static int[][] map;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		M = Integer.parseInt(tokenizer.nextToken());
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M];

		for (int i = 0; i < K; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x1 = Integer.parseInt(tokenizer.nextToken());
			int y1 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken());
			int y2 = Integer.parseInt(tokenizer.nextToken());

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					map[r][c] = 1;
				}
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					result.add(bfs(r, c));
				}
			}
		}
		
		Collections.sort(result);
		output.append(result.size()+"\n");
		for(int i = 0; i<result.size(); i++) {
			output.append(result.get(i)+" ");
		}
		System.out.println(output.toString());

	}

	static int bfs(int r, int c) {
		
		int count = 0;
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {r, c});
		map[r][c] = 2;
		count++;
		
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.poll()[1];
			
			for(int i=0; i<dir.length; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				
				if (nx<0 || nx>=N || ny<0 || ny>=M) {
					continue;
				}
				
				if (map[nx][ny]==0) {
					queue.offer(new int[] {nx, ny});
					map[nx][ny] = 2; 
					count++;
				}
			}
		}
		
		return count;
	}

}
