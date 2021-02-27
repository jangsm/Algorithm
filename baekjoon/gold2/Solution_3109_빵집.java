package ps.bj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 18.
 * @author user
 * @see https://www.acmicpc.net/problem/3109
 * @mem 41976
 * @time 332
 * @caution 1. 이동방향을 오른쪽 위, 오른쪽, 오른쪽 아래 순으로 검사 
 * 			-> 0행부터 위에서 아래로 검사하므로 이동에 대해서도
 *          위쪽부터 검사해야 겹치는 경우가 발생하지 않음 
 *          2. 재귀적으로 이전단계로 돌아갈때 방문처리를 해제해줄 필요 없음 ->
 *          어차피 해당위치에서는 더 이상 못간다는 것을 의미하므로 
 *          해당위치로 진입 자체를 막는 일종의 DP역할 가능
 */

public class Solution_3109_빵집 {

	static int R, C, result;
	static char[][] map;
	static boolean[][] visited;
	static boolean returnFlag;
	static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String line = input.readLine();
			for (int c = 0; c < line.length(); c++) {
				map[r][c] = line.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			returnFlag = false;
			searchPath(r, 0);
		}

		System.out.println(result);
//		for(boolean[] b : visited) {
//			System.out.println(Arrays.toString(b));
//		}

	}

	static void searchPath(int x, int y) {

		if (x < 0 || x >= R || y < 0 || y >= C) {
			return;
		}

		if (map[x][y] == 'x') {
			return;
		}

		if (visited[x][y]) {
			return;
		}

		if (y == C - 1) { // 도착
			visited[x][y] = true;
			result++;
			returnFlag = true;
			return;
		}

		visited[x][y] = true;
		// 3가지 경우 : 오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선
		for (int i = 0; i < dir.length; i++) {
			int newX = x + dir[i][0];
			int newY = y + dir[i][1];
			searchPath(newX, newY); // 넘기고 검사
			if (returnFlag) {
				return;
			}
		}
//		visited[x][y] = false; // 이게 중요한 부분!!
	}

}
