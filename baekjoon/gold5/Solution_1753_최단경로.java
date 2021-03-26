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
 * @mem 120080
 * @time 1944
 * @caution 시간 엄청 오래걸림, pq이용하자
 */

public class Solution_1753_최단경로 {

	static int V, E, K;
	static Node[] graph;
	static StringBuilder output;

	static class Node {
		int index;
		List<Integer> child;
		List<Integer> weight;

		public Node(int index) {
			super();
			this.index = index;
			this.child = new ArrayList<>();
			this.weight = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", child=" + child + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		V = Integer.parseInt(tokenizer.nextToken());
		E = Integer.parseInt(tokenizer.nextToken());
		graph = new Node[V + 1]; // 1번부터

		for (int i = 1; i <= V; i++) { // graph 초기화
			graph[i] = new Node(i);
		}

		K = Integer.parseInt(input.readLine());

		for (int i = 0; i < E; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int u = Integer.parseInt(tokenizer.nextToken());
			int v = Integer.parseInt(tokenizer.nextToken());
			int w = Integer.parseInt(tokenizer.nextToken());

			graph[u].child.add(v);
			graph[u].weight.add(w);
		}

		dijkstra(K);
		System.out.println(output.toString());
	}

	static void dijkstra(int start) {

		boolean[] visited = new boolean[V + 1];
		int[] dist = new int[V + 1]; // 출발 위치부터 모든 정점들까지의 최소거리 저장을 위한 배열
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0; // 자기 자신까지의 거리는 0

		int count = 0; // visited count하는 변수 -> 모두 visit하면 끝
		while (count!=V) {

			int min = Integer.MAX_VALUE;
			int minVertex = 0;

			for (int i = 1; i <= V; i++) { // index 1번부터
				if (!visited[i] && min > dist[i]) {
					min = dist[i];
					minVertex = i;
				}
			}
			visited[minVertex] = true;
			count++;

			if(minVertex!=0) {
				// 모두 방문 안했는데 minVertex가 0이면 INF를 가지는 값
				for (int i = 0; i < graph[minVertex].child.size(); i++) {
					// 자식 중 아직 미방문이고 거쳐서 갔더니 누적비용이 더 싸진 지점
					// 자식만 확인하면 됨, 타고타고 들어갈 필요 없음
					// 갱신된 값을 바탕으로 가장 바깥의 반복문이 돌면서 다 갱신함
					if (!visited[graph[minVertex].child.get(i)]
							&& dist[graph[minVertex].child.get(i)] > dist[minVertex] + graph[minVertex].weight.get(i)) {
						dist[graph[minVertex].child.get(i)] = dist[minVertex] + graph[minVertex].weight.get(i);
					}
				}	
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				output.append("INF\n");
			} else {
				output.append(dist[i] + "\n");
			}
		}
	}

}
