package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 24.
 * @author user
 * @see https://www.acmicpc.net/problem/1600
 * @mem 57452
 * @time 484
 * @caution BFS는 좌표에 대해서만이 아닌 하나의 상태를 나타낼 수 있는 것이면 모두 가능
 * 			즉, 상태가 변하는 것에 대해서 bfs
 * 			해당 문제에서는 x,y좌표와 함께 점프할 수 있는 횟수가 하나의 상태가 된다
 * 			이동횟수 제한이 없다면..??
 */

public class Solution_1600_말이되고픈원숭이 {

	static int K, W, H, result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][][] visited; // 점프하는 횟수에 대해서도 따로 처리 -> 점프로 이동과 한칸씩 3번 이동해서 도착하는것은 다른 경우이다.
	// 하나로 관리하게 되면 말로 이동하는 거리가 visit 처리되버리고 이후 한칸씩 이동은 해당 위치 방문을 못해서 
	// 해당 위치는 무조건 카운트 하나 줄이고 갈 수 있는 위치가 되버린다.
	// 무조건 최소값이 아닌 점프를 아끼다가 마지막에 장애물을 뛰어넘고 도착해야 할 수도 있다.
	static int[][] monkeyDir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] horseDir = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 },
			{ 1, -2 } };

	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		K = Integer.parseInt(input.readLine());

		tokenizer = new StringTokenizer(input.readLine(), " ");
		W = Integer.parseInt(tokenizer.nextToken());
		H = Integer.parseInt(tokenizer.nextToken());

		map = new int[H][W];
		visited = new boolean[K+1][H][W];

		for (int h = 0; h < H; h++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		System.out.println(solve(0, 0));
	}

	static int solve(int x, int y) {

		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { x, y, K, 0 }); // x, y, 점프, 카운트
		visited[K][x][y] = true;

		while (!queue.isEmpty()) {
			
			int curX = queue.peek()[0];
			int curY = queue.peek()[1];
			int curK = queue.peek()[2];
			int curCount = queue.poll()[3];

			if (curX == H - 1 && curY == W - 1) {
				return curCount;
			}

			for (int i = 0; i < monkeyDir.length; i++) {
				int newX = curX + monkeyDir[i][0];
				int newY = curY + monkeyDir[i][1];

				if (newX < 0 || newX >= H || newY < 0 || newY >= W) {
					continue;
				}

				if (!visited[curK][newX][newY] && map[newX][newY] == 0) {
					visited[curK][newX][newY] = true;
					queue.offer(new int[] { newX, newY, curK, curCount+1 });
				}
			}

			if (curK > 0) {
				for (int i = 0; i < horseDir.length; i++) {
					int newX = curX + horseDir[i][0];
					int newY = curY + horseDir[i][1];

					if (newX < 0 || newX >= H || newY < 0 || newY >= W) {
						continue;
					}

					if (!visited[curK-1][newX][newY] && map[newX][newY] == 0) {
						visited[curK-1][newX][newY] = true;
						queue.offer(new int[] { newX, newY, curK - 1, curCount+1 });
					}
				}
			}

		}
		
		return -1;
	}

}
