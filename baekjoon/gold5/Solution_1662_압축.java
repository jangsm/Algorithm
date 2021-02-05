package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1662_압축 {
	
	static class Pair{
		char c;
		int len;
		
		public Pair(char c, int len) {
			super();
			this.c = c;
			this.len = len;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		String str = input.readLine();

		int[] len = new int[str.length()];
		Arrays.fill(len, 1);

		Stack<Pair> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ')') {
				stack.push(new Pair(str.charAt(i), 1));
			} else {
				int subLength = 0;
				while (true) {
					Pair p = stack.pop();
					if (p.c == '(') {
						p = stack.pop();
						p.len = subLength * Integer.parseInt(String.valueOf(p.c));
						stack.push(p);
						break;
					}
					subLength+=p.len;
				}
			}
		}

		int length = 0;
		while(!stack.isEmpty()) {
			length += stack.pop().len;
		}

		System.out.println(length);

//		int length = 0;
//		
//		Stack<Character> stack = new Stack<>();
//		boolean isOpen = true;
//		boolean flag = false;
//		for(int i=0; i<str.length(); i++) {
//			if (str.charAt(i)!=')') {
//				if (str.charAt(i)=='(') {
//					if (!isOpen) {
//						flag=true;
//					}
//					isOpen = true;
//				}
//				stack.push(str.charAt(i));
//			} else {
//				isOpen = false;
//				int subLength = 0;
//				while(true) {
//					char c = stack.pop();
//					if (c=='(') {
//						if (!stack.isEmpty()) {
//							c = stack.pop();
//							if (flag) {
//								subLength = subLength*Integer.parseInt(String.valueOf(c));
//								length += subLength;
//								flag = false;
//							} else {
//								subLength += length;
//								length = subLength * Integer.parseInt(String.valueOf(c));	
//							}	
//						}
//						break;
//					}
//					subLength++;
//				}
//			}
//		}
//		
//		while(!stack.isEmpty()) {
//			stack.pop();
//			length++;
//		}
//		
//		System.out.println(length);
	}

}
