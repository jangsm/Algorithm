package ps.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 7.
 * @author user
 * @see https://www.acmicpc.net/problem/2346
 * @mem 228
 * @time 16756
 * @caution
 */

public class Deque_no2346_풍선터뜨리기 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		tokenizer = new StringTokenizer(input.readLine(), " ");
		Deque<int[]> deque = new ArrayDeque<>(); // 가지고 있는 수, 인덱스
		for (int i = 1; i <= N; i++) {
			deque.addLast(new int[] { Integer.parseInt(tokenizer.nextToken()), i });
		}

		while (!deque.isEmpty()) {
			int[] temp = deque.pollFirst();
			output.append(temp[1] + " ");
			if (temp[0] > 0) {
				for(int i=0; i<temp[0]-1; i++) { // 삭제해야될 인덱스를 맨 앞으로 가져오는 작업, 양수인 경우 순서대로 가기 때문에 -1해준다.
					if (!deque.isEmpty()) {
						deque.addLast(deque.pollFirst());	
					}
				}
			} else {
				for(int i=0; i<-temp[0]; i++) { // 삭제해야될 인덱스를 맨 앞으로 가져오는 작업
					if (!deque.isEmpty()) {
						deque.addFirst(deque.pollLast());	
					}
				}
			}
		}
		
		System.out.println(output.toString());
	}

}
