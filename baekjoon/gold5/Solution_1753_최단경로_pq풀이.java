package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 26.
 * @author user
 * @see https://www.acmicpc.net/problem/1753
 * @mem 115404
 * @time 788
 * @caution pq이용해서 최소값 뽑아주면 최적화 가능
 * 			pq에 새로운 Node를 넣을때 weight은 원래 가지고 있는 값이 아닌 갱신 값을 넣어주어야함
 */

public class Solution_1753_최단경로_pq풀이 {

	static int V, E, K;
	static List<Node>[] graph;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int end, weight;

		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		V = Integer.parseInt(tokenizer.nextToken());
		E = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(input.readLine());
		graph = new ArrayList[V + 1]; // 1번부터
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int inf = 987654321;
		Arrays.fill(dist, inf);

		for (int i = 0; i < E; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			int w = Integer.parseInt(tokenizer.nextToken());

			graph[u].add(new Node(v, w));
		}
		
		dijkstraPQ(K);
		
		for(int i=1; i<=V; i++) {
			if (dist[i] == inf) {
				output.append("INF");
			} else {
				output.append(dist[i]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	static void dijkstraPQ(int start) {
		boolean[] visited = new boolean[V + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {

			Node curNode = pq.poll();

			int startIdx = curNode.end;
			visited[startIdx] = true;

			for (Node node : graph[startIdx]) {
				if (!visited[node.end]
						&& dist[node.end] > dist[startIdx] + node.weight) {
					dist[node.end] = dist[startIdx] + node.weight;
					pq.add(new Node(node.end, dist[node.end]));
					// 현재 갱신된 weight을 넣어주어야 pq에서 최소값을 올바르게 뽑음
				}
			}
		}
	}

}
