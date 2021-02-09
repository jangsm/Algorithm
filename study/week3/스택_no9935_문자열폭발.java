package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/9935
 * @mem stack 이용: 103061KB
 * 		char[] 이용: 31252KB
 * @time stack 이용: 892ms
 * 		 char[] 이용: 468ms
 * @caution 스택을 이용해서 푸는 아이디어는 생각했으나 정확한 구현에서 어려움을 겪음, 스택을 이용할 경우 pop연산을 통해 빼야되는
 *          시간도 있는데 char[]을 사용해서 그냥 위에 덮어쓰는 방식으로 구현하면 더 빠르게 구현할 수 있음
 */

public class Solution_9935_문자열폭발 {

	static String text, target;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		text = input.readLine();
		target = input.readLine();

		System.out.println(solutionCharArray().length() == 0 ? "FRULA" : solutionCharArray());
//		System.out.println(solutionStack().length() == 0 ? "FRULA" : solutionStack());
	}

	////////////////////////////////////// char[] 이용 풀이
	////////////////////////////////////// /////////////////////////////////
	static String solutionCharArray() {
		char[] arr = new char[text.length()];
		int index = 0;
		for (int i = 0; i < text.length(); i++) {
			arr[index] = text.charAt(i);
			// 아이디어는 입력시마다 현재 index에서 target.length 이전 인덱스까지 확인하며
			// target문자열과 일치하면 해당 위치부터 덮어써준다.
			if (isTarget(index, arr)) {
				index -= target.length();
			}
			index++;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			result.append(arr[i]);
		}
		return result.toString();
	}

	static boolean isTarget(int index, char[] arr) {
		if (index < target.length() - 1) { // 아직 타겟 문자열 길이만큼도 안들어온경우
			return false;
		}
		for (int i = 0; i < target.length(); i++) { // 현재 index에서 target.length 이전 인덱스까지 확인
			if (target.charAt(i) != arr[index - target.length() + 1 + i]) {
				return false;
			}
		}
		return true;
	}
	////////////////////////////////////// char[] 이용 풀이
	////////////////////////////////////// /////////////////////////////////

	////////////////////////////////////// stack 이용 풀이
	////////////////////////////////////// /////////////////////////////////
	static String solutionStack() {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < text.length(); i++) {
			stack.push(text.charAt(i));

			if (stack.size() >= target.length()) {
				boolean flag = true;
				for (int j = 0; j < target.length(); j++) {
					if (target.charAt(j) != stack.get(stack.size() - target.length() + j)) { // i에서 빼주는게 아닌 stack.size에서 빼줘야함 
															 									// -> pop하는 연산이 있으므로 실제 size와 달라짐
																								// 둘다 size이므로 char[]처럼 1을 더해줄 필요는 없음
						flag = false;
						break;
					}
				}
				
				if (flag) {
					for(int j=0; j<target.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i=0; i<stack.size(); i++) {
			result.append(stack.get(i));
		}
		return result.toString();
	}
}
