package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1935_후위표기식2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		String str = input.readLine();

		int[] alphabet = new int[26];

		for (int i = 0; i < N; i++) {
			alphabet[i] = Integer.parseInt(input.readLine());
		}

		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			double num1, num2;
			switch (str.charAt(i)) {
			case '*':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1*num2);
				break;
			case '/':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1/num2);
				break;
			case '+':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1+num2);
				break;
			case '-':
				num2 = stack.pop();
				num1 = stack.pop();
				stack.push(num1-num2);
				break;
			default:
				stack.push((double) alphabet[str.charAt(i) - 'A']);
				break;
			}
		}
		
		output.append(String.format("%.2f", stack.pop()));
		System.out.println(output.toString());
		
	}

}
