package ps.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 4.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV14eWb6AAkCFAYD&probBoxId=AXdrBVk6tdcDFAS5&type=PROBLEM&problemBoxTitle=0204&problemBoxCnt=1
 * @mem
 * @time
 * @caution
 */

public class Solution_1218_괄호짝짓기 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			input.readLine(); // 사용안해도 되는 입력
			String str = input.readLine();
			
			Stack<Character> s1 = new Stack<>(); // ()
			Stack<Character> s2 = new Stack<>(); // []
			Stack<Character> s3 = new Stack<>(); // {}
			Stack<Character> s4 = new Stack<>(); // <>
			
			boolean isOuter = false;
			outer:for(int i=0; i<str.length(); i++) {
				switch (str.charAt(i)) {
				case '(':
					s1.push(str.charAt(i));
					break;
				case ')':
					if (!s1.isEmpty()) {
						s1.pop();
					} else {
						isOuter = true;
						break outer;
					}
					break;
				case '[':
					s2.push(str.charAt(i));
					break;
				case ']':
					if (!s2.isEmpty()) {
						s2.pop();
					} else {
						isOuter = true;
						break outer;
					}
					break;
				case '{':
					s3.push(str.charAt(i));
					break;
				case '}':
					if (!s3.isEmpty()) {
						s3.pop();
					} else {
						isOuter = true;
						break outer;
					}
					break;
				case '<':
					s4.push(str.charAt(i));
					break;
				case '>':
					if (!s4.isEmpty()) {
						s4.pop();
					} else {
						isOuter = true;
						break outer;
					}
					break;
				default:
					break;
				}
			}
			
			int result = 0;
			
			if (!isOuter) {
				result = 0;
			}
			if (!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty() || !s4.isEmpty()) {
				result = 0;
			} else {
				result = 1;
			}
			
			output.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(output.toString());
	}

}
