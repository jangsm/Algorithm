package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			input.readLine(); // 테스트케이스 고정으로 불필요한 값
			tokenizer = new StringTokenizer(input.readLine(), " ");
			Queue<Integer> queue = new LinkedList<>();
			while(tokenizer.hasMoreTokens()) {
				queue.offer(Integer.parseInt(tokenizer.nextToken()));
			}
			
			int cnt = 1;
			while(true) {
				int num = queue.poll();
				int newNum = num - cnt;
				cnt++;
				if (cnt==6) {
					cnt = 1;
				}
				if (newNum<=0) {
					newNum = 0;
					queue.offer(newNum);
					break;
				} else {
					queue.offer(newNum);
				}
			}
			
			output.append("#").append(tc).append(" ");
			while(!queue.isEmpty()) {
				output.append(queue.poll()).append(" ");
			}
			output.append("\n");
		}
		
		System.out.println(output.toString());
	}

}
