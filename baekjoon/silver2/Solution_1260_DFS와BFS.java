package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1260_DFS와BFS {

	static int N, M, V;
	static boolean[][] map;
	static boolean[] visited;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		V = Integer.parseInt(tokenizer.nextToken());

		map = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			map[x][y] = true;
			map[y][x] = true;
		}
		
		dfs(V);
		visited = new boolean[N + 1];
		output.append("\n");
		bfs();
		
		System.out.println(output.toString());
	}

	static void dfs(int v) {
		output.append(v + " ");
		visited[v] = true;
		
		for(int i=1; i<map[v].length; i++) {
			if (map[v][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
//		output.append(V+" ");
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			int first = queue.poll();
			output.append(first + " ");
			
			for(int i=1; i<map[first].length; i++) {
				if (map[first][i]&& !visited[i] ) {
					queue.offer(i);
					visited[i] = true; 
				}
			}
		}
	}

}
