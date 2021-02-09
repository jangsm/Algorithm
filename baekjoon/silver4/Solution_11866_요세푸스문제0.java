package ps.bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i=1; i<=N; i++) {
			deque.addLast(i);
		}
		
		output.append("<");
		
		while (!deque.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				deque.addLast(deque.pollFirst()); // K번째 원소가 맨 앞으로 오도록
			}
			
			output.append(deque.pollFirst()+", ");
		}
		
		output.setLength(output.length()-2); // 맨 마지막 , 제거
		output.append(">");
		
		System.out.println(output.toString());
	}

}
