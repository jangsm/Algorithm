package ps.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 3.
 * @author user
 * @see https://www.acmicpc.net/problem/3190
 * @mem 13944
 * @time 120
 * @caution 경우를 나눠서 다 해봄, 시간 줄일 수 있을 것 같음
 */

public class Solution_3190_뱀 {

	static int N, K, L;
	static int[][] map;
	static char[] turn;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		map = new int[N + 1][N + 1]; // 1~N

		for (int i = 0; i < K; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());

			map[x][y] = 1;
		}

		L = Integer.parseInt(input.readLine());
		turn = new char[10001];
		for (int i = 0; i < L; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int time = Integer.parseInt(tokenizer.nextToken());
			char dir = tokenizer.nextToken().charAt(0);

			turn[time] = dir;
		}

		int curX = 1, curY = 1, curDir = 1; // 0:위, 1: 오른쪽, 2: 아래, 3: 왼쪽
		int curTime = 0;
		List<int[]> snake = new ArrayList<int[]>();
		snake.add(new int[] { curX, curY, curDir, curTime });
		outer: while (true) {

			int headX = snake.get(0)[0];
			int headY = snake.get(0)[1];
			int headDir = snake.get(0)[2];

			int newX = headX + dir[headDir][0];
			int newY = headY + dir[headDir][1];

			if (newX < 1 || newX > N || newY < 1 || newY > N) { // 갈 수 없는 위치이면 끝난다.
				break outer;
			}

			for (int i = 1; i < snake.size(); i++) {
				if (newX == snake.get(i)[0] && newY == snake.get(i)[1]) { // 자기 자신과 부딪히는 경우
					break outer;
				}
			}

			boolean isEat = false;
			if (map[newX][newY] == 1) { // 사과가 있으면 먹는다.
				isEat = true;
				map[newX][newY] = 0;
			}
			
			int lastX = snake.get(snake.size()-1)[0];
			int lastY = snake.get(snake.size()-1)[1];
			int lastDir = snake.get(snake.size()-1)[2];
			int lastTime = snake.get(snake.size()-1)[3];

			// 위치 갱신
			for (int i = 0; i < snake.size(); i++) {
				// get
				curX = snake.get(i)[0];
				curY = snake.get(i)[1];
				curDir = snake.get(i)[2];
				curTime = snake.get(i)[3];

				// set
				snake.get(i)[0] = curX + dir[curDir][0];
				snake.get(i)[1] = curY + dir[curDir][1];
				snake.get(i)[2] = curDir; // 일단 그대로, 이동 끝나면 바꿔줌
				snake.get(i)[3] = curTime + 1; // 시간 1초 증가

				if (turn[snake.get(i)[3]] == 'L') { // 방향 왼쪽으로 변경
					curDir -= 1;
					if (curDir < 0) {
						curDir += 4;
					}
				} else if (turn[snake.get(i)[3]] == 'D') { // 방향 오른쪽으로 변경
					curDir += 1;
					if (curDir >= 4) {
						curDir -= 4;
					}
				}
				snake.get(i)[2] = curDir; // 방향 변경
			}
			
			if (isEat) {
				snake.add(new int[] {lastX, lastY, lastDir, lastTime});
			}
		}
		
		System.out.println(++snake.get(0)[3]);
	}

}
