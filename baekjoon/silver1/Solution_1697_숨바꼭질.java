package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/1697
 * @mem 14368
 * @time 112
 * @caution 중복방문을 막기 위하여 방문처리해주기!! => 안해주면 불필요한 중복이 많아서 메모리초과
 */

public class Solution_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());

		boolean[] visited = new boolean[100001];
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { N, 0 });
		visited[N] = true;

		while (true) {

			int time = queue.peek()[1];
			int pos = queue.poll()[0];

			if (pos == K) {
				System.out.println(time);
				break;
			}

			if (pos - 1 >= 0 && !visited[pos - 1]) {
				queue.offer(new int[] { pos - 1, time + 1 });
				visited[pos - 1] = true;
			}

			if (pos + 1 <= 100000 && !visited[pos + 1]) {
				queue.offer(new int[] { pos + 1, time + 1 });
				visited[pos + 1] = true;
			}

			if (pos * 2 <= 100000 && !visited[pos * 2]) {
				queue.offer(new int[] { pos * 2, time + 1 });
				visited[pos * 2] = true;
			}

		}
	}

}
