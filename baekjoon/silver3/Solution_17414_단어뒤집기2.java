package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 25.
 * @author user
 * @see https://www.acmicpc.net/problem/17413
 * @mem 23672
 * @time 208
 * @caution
 */

public class Solution_17414_단어뒤집기2 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		String str = input.readLine();
		StringBuilder sb = new StringBuilder(str);

		Stack<Character> stack = new Stack<>();
		boolean isTag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && !isTag) {
				while (!stack.isEmpty()) {
					output.append(stack.pop());
				}
				output.append(str.charAt(i));
			} else {
				if (str.charAt(i) == '<') {
					while (!stack.isEmpty()) {
						output.append(stack.pop());
					}
					isTag = true;
				} 
				if (isTag) {
					output.append(str.charAt(i));
				} else {
					stack.push(str.charAt(i));	
				}
				
				if (str.charAt(i) == '>') {
					isTag = false;
				}
				
			}
		}

		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		System.out.println(output.toString());

	}

}
