package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int T = Integer.parseInt(input.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(input.readLine());
			tokenizer = new StringTokenizer(input.readLine(), " ");
			Deque<String> deque1 = new ArrayDeque<>();
			Deque<String> deque2 = new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				if (i<N/2 + N%2) {
					deque1.addLast(tokenizer.nextToken()); // 같거나 하나 더 많다.
				} else {
					deque2.addLast(tokenizer.nextToken());
				}
			}
			
			output.append("#" + tc + " ");
			while(!deque2.isEmpty()) {
				output.append(deque1.pollFirst() + " ");
				output.append(deque2.pollFirst() + " ");
			}
			
			if (!deque1.isEmpty()) {
				output.append(deque1.pollFirst() + " ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}

}
