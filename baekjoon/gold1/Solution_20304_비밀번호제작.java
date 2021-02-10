package ps.bj.g1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 10.
 * @author user
 * @see https://www.acmicpc.net/problem/20304
 * @mem
 * @time
 * @caution 단순히 O(NM)으로 풀게되면 시간초과!! BFS + 비트연산자 이용하여 풀이를 해야한다. 
 * 			-> BFS를 사용한다는 생각이 쉽지 않음
 */

public class Solution_20304_비밀번호제작 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		int[] attacks = new int[M];
		boolean[] visited = new boolean[N + 1];

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < M; i++) {
			attacks[i] = Integer.parseInt(tokenizer.nextToken());
		}

		///// BFS 구현 /////
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < M; i++) { // 초기 정보 넣어줌
			queue.offer(attacks[i]);
			visited[attacks[i]] = true;
		}

		int depth = 0; // depth 단계별로 출력 --> 공격 비밀번호 -> 공격비밀번호에서 안전 거리 1인 비밀번호 -> 거기서 또 안전거리 1인 비밀번호 (이미 방문한건 제외)
		while (!queue.isEmpty()) {

			int size = queue.size();
			
//			System.out.println(depth + " : " + queue);

			while (size-- > 0) { // 현재 들어있는 size만큼씩 돌려주면 그게 하나의 depth가 된다!! -> 제일 깊게 들어가는것이 안전도가 제일 높은 값이 된다!!
				int first = queue.poll();
				int next;
				for (int i = 1; i <= N; i <<= 1) { // next를 구하기 위한 shift연산
//					if ((first & i) > 0) { // 0보다 크면, 즉 11과 01에 대해서 1이나온다는것은 first가 해당 위치에 1을 가지고 있다는 것이고 0으로 바꿔주면 안전거리 1이 증가
//						next = first - i;
//					} else { // 0이면 , 즉 10과01에 대해서 0이 나온다는것은 first가 해당 위치에 0을 가지고 있다는 것이고 1로 바꿔주면 안전거리 1이 증가
//						next = first + i;
//					}
					
					// 위의 내용을 요약하면 값이 똑같으면 0으로, 다르면 1로 바뀐다 -> 즉 XOR연산
					next = first^i;
					
					if (next<=N && !visited[next]) {
						visited[next] = true;
						queue.offer(next);
					}
				}
			}
			depth++;
		}
		
		System.out.println(--depth);
	}

}
