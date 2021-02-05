package ps.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1223_계산기2 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			input.readLine(); // 길이, 사용하지 않음
			String str = input.readLine();
			Stack<Integer> num = new Stack<>();
			Stack<Character> operator = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '*':
					operator.push(str.charAt(i));
					break;
				case '+':
					operator.push(str.charAt(i));
					break;
				default:
					if (!operator.isEmpty() && operator.peek()=='*') {
						operator.pop();
						int a = num.pop();
						int b = Integer.parseInt(String.valueOf(str.charAt(i)));
						num.push(a*b);
					} else {
						num.push(Integer.parseInt(String.valueOf(str.charAt(i))));	
					}
					break;
				}
			}
			while(num.size()!=1) {
				int b = num.pop();
				int a = num.pop();
				num.push(a+b);
			}
			int result = num.pop();
			
			output.append("#" + tc + " " + result + "\n");
		}
		System.out.println(output.toString());
	}

}
