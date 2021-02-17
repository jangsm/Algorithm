package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 17.
 * @author user
 * @see https://www.acmicpc.net/problem/15686
 * @mem 14640, bfs는 217720
 * @time 168, bfs는 416
 * @caution 치킨집은 최대 13개!! 이런식으로 작은 수일때는 완탐을 통해 우선 해결하자!! -> 13개중 M개를 뽑아서 모든 경우
 *          비교
 *          최소거리를 bfs로 구할 필요 없다. 그냥 중첩for문으로 직접 구해주는것이 훨씬 빠르다 필요한것만!!!
 */

public class Solution_15686_치킨배달 {

	static int N, M, result = Integer.MAX_VALUE;
	static int[][] map;
//	static int[][] dist;
//	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Pair> home;
	static List<Pair> chicken;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][N];
//		dist = new int[N][N];
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());

				if (map[i][j] == 1) {
					home.add(new Pair(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Pair(i, j));
				}
			}
		}

		makeComb(0, new Pair[M], 0);

		System.out.println(result);
	}

	static void makeComb(int cnt, Pair[] choosed, int startIdx) {
		if (cnt == M) {
			int dist = 0;
			for (int i = 0; i < home.size(); i++) {
				int hx = home.get(i).x;
				int hy = home.get(i).y;
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int cx = choosed[j].x;
					int cy = choosed[j].y;
					minDist = Math.min(minDist, Math.abs(hx - cx) + Math.abs(hy - cy));
				}
				dist += minDist;
			}
			result = Math.min(result, dist);
			return;
		}

		for (int i = startIdx; i < chicken.size(); i++) {
			choosed[cnt] = chicken.get(i);
			makeComb(cnt + 1, choosed, i + 1);
		}
	}

//	static void bfs(Pair[] choosed) {
//		Queue<Pair> queue = new LinkedList<>();
//		for (int i = 0; i < M; i++) {
//			queue.offer(choosed[i]);
//			dist[choosed[i].x][choosed[i].y] = -1; // -1로 초기화
//		}
//
//		int depth = 1;
//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			while (size-- > 0) {
//				Pair first = queue.poll();
//				for (int i = 0; i < dir.length; i++) {
//					int newX = first.x + dir[i][0];
//					int newY = first.y + dir[i][1];
//
//					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
//						continue;
//					}
//
//					if (dist[newX][newY] == 0) {
//						dist[newX][newY] = depth;
//						queue.offer(new Pair(newX, newY));
//					}
//				}
//			}
//			depth++;
//		}
//
//	}

}
