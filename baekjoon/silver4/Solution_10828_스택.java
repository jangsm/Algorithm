package ps.bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			switch (tokenizer.nextToken()) {
			case "push":
				int num = Integer.parseInt(tokenizer.nextToken());
				stack.push(num);
				break;
			case "pop":
				if (!stack.isEmpty()) {
					output.append(stack.pop()).append("\n");
				} else {
					output.append(-1).append("\n");
				}
				break;
			case "size":
				output.append(stack.size()).append("\n");
				break;
			case "empty":
				if (stack.isEmpty()) {
					output.append(1).append("\n");
				} else {
					output.append(0).append("\n");
				}
				break;
			case "top":
				if (!stack.isEmpty()) {
					output.append(stack.peek()).append("\n");
				} else {
					output.append(-1).append("\n");
				}
				break;
			default:
				break;
			}
		}
		
		System.out.println(output.toString());
	}

}
