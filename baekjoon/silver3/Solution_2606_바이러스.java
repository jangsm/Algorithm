package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2606_바이러스 {

	static int N, M;
	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine()); // 컴퓨터 수
		M = Integer.parseInt(input.readLine()); // 연결돈 네트워크 수

		map = new boolean[N + 1][N + 1]; // 1번부터 시작하는 index와 사이즈를 맞추기 위해
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());

			map[x][y] = true;
			map[y][x] = true;
		}
		
		bfs();
		
		int result = 0;
		for(int i=1; i<visited.length; i++) {
			if (visited[i]) {
				result++;
			}
		}
		
		System.out.println(--result); // 맨 처음 감염시킨 1번은 제외

	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int first = queue.poll();
			visited[first] = true;
			for(int i=1; i<map[first].length; i++) {
				if (map[first][i] && !visited[i]) {
					queue.offer(i);
				}
			}
		}
	}

}
