package ps.bj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 26.
 * @author user
 * @see https://www.acmicpc.net/problem/17472
 * @mem 11728
 * @time 84
 * @caution bfs이용해서 각 섬의 개수 및 위치를 구한 후,
 * 			해당 섬들 사이의 최소 거리를 구하고,
 * 			이 값들을 이용해서 MST알고리즘(PRIM) 적용
 */

public class Solution_17472_다리만들기2 {

	static int N, M, island;
	static int[][] map;
	static boolean[][] visited;
	static List<Point>[] islandPosition;

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Point {
		int x, y;

		public Point(int x, int y) {
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

		map = new int[N][M];
		visited = new boolean[N][M];
		islandPosition = new ArrayList[6];

		for (int i = 0; i < islandPosition.length; i++) {
			islandPosition[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		island = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					// bfs
					bfs(i, j);
					island++;
				}
			}
		}

		int[][] islandMap = new int[island][island];

		for (int i = 0; i < island; i++) {
			for (int j = i + 1; j < island; j++) {
				int dist = Integer.MAX_VALUE;
				for (int a = 0; a < islandPosition[i].size(); a++) {
					Point start = islandPosition[i].get(a);
					int startX = start.x;
					int startY = start.y;
					outer: for (int b = 0; b < islandPosition[j].size(); b++) {
						Point end = islandPosition[j].get(b);
						int endX = end.x;
						int endY = end.y;

						if (startX == endX) {
							int startPos = Math.min(startY, endY);
							int endPos = Math.max(startY, endY);
							for (int c = startPos + 1; c < endPos; c++) {
								if (map[startX][c] == 1) {
									continue outer;
								}
							}
							if (Math.abs(startY - endY) - 1 >= 2) {
								dist = Math.min(dist, Math.abs(startY - endY) - 1);
							}
						} else if (startY == endY) {
							int startPos = Math.min(startX, endX);
							int endPos = Math.max(startX, endX);
							for (int c = startPos + 1; c < endPos; c++) {
								if (map[c][startY] == 1) {
									continue outer;
								}
							}
							if (Math.abs(startX - endX) - 1 >= 2) {
								dist = Math.min(dist, Math.abs(startX - endX) - 1);
							}
						}
					}
				}
				if(dist==Integer.MAX_VALUE) {
					dist = 0;
				}
				islandMap[i][j] = dist;
				islandMap[j][i] = dist;
			}
		}

//		for (int[] sub : islandMap) {
//			System.out.println(Arrays.toString(sub));
//		}

		boolean[] visitPrim = new boolean[island];
		int[] minEdge = new int[island];
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		int result = 0;
		minEdge[0] = 0; // 시작위치: 0, 자기 자신 간선 길이는 0

		for (int i = 0; i < island; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int j = 0; j < island; j++) {
				if (!visitPrim[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}

			result += min;
			visitPrim[minVertex] = true;

			for (int j = 0; j < island; j++) {
				if (!visitPrim[j] && islandMap[minVertex][j] != 0 && minEdge[j] > islandMap[minVertex][j]) {
					minEdge[j] = islandMap[minVertex][j];
				}
			}
		}
		
		int visitCount = 0;
		for(int i=0; i<island; i++) {
			if (visitPrim[i]) {
				visitCount++;
			}
		}
		
		if(visitCount==island) {
			System.out.println(result);	
		} else {
			System.out.println("-1");
		}
	}

	static void bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int curX = p.x;
			int curY = p.y;

			islandPosition[island].add(new Point(curX, curY));

			for (int i = 0; i < dir.length; i++) {
				int newX = curX + dir[i][0];
				int newY = curY + dir[i][1];

				if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
					continue;
				}

				if (!visited[newX][newY] && map[newX][newY] == 1) {
					visited[newX][newY] = true;
					queue.offer(new Point(newX, newY));
				}
			}
		}
	}

}
