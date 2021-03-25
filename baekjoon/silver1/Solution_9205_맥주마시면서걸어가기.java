package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 25.
 * @author user
 * @see https://www.acmicpc.net/problem/9205
 * @mem 12428
 * @time 104
 * @caution bfs로 해결해야한다.
 * 			처음 풀이 방법: 현 위치에서 가장 가까운 위치로 이동해서 재탐색 하는식으로 하였는데 이럴 경우 문제가 생김
 * 			-1600(콘서트) - -600(편의점) - 0(출발) - 500(편의점)
 * 			가장 가까운 500으로 이동한후 갈 수 있는 곳이 없다 -> -600위치로 이동했으면 콘서트를 도착할 수 있다.
 * 			bfs로 갈 수 있는곳을 모두 담아둔후 하나씩 빼면서 처리해야한다.
 */

public class Solution_9205_맥주마시면서걸어가기 {

	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());

			int[][] pos = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				pos[i][0] = Integer.parseInt(tokenizer.nextToken());
				pos[i][1] = Integer.parseInt(tokenizer.nextToken());
			}

			boolean[] visited = new boolean[N+2];
			Queue<int[]> queue = new ArrayDeque<int[]>();
			queue.add(new int[] {pos[0][0], pos[0][1]});
			visited[0] = true;
			
			boolean flag = false;
			while(!queue.isEmpty()) {
				int curX = queue.peek()[0];
				int curY = queue.poll()[1];
				
				if(curX==pos[N+1][0] && curY==pos[N+1][1]) {
					flag = true;
					break;
				}
				
				for(int i=0; i<N+2; i++) {
					if(!visited[i] && (Math.abs(curX-pos[i][0]) + Math.abs(curY-pos[i][1]))<=1000) {
						visited[i] = true;
						queue.add(new int[] {pos[i][0], pos[i][1]});
					}
				}
			}
			
			if(flag) {
				output.append("happy\n");
			} else {
				output.append("sad\n");
			}
		}
		System.out.println(output.toString());
	}

}
