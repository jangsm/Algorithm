package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		int[] arr = new int[N];
		int[] result = new int[N];
		tokenizer = new StringTokenizer(input.readLine(), " ");
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
			while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
				int[] temp = stack.pop();
				result[temp[1]] = arr[i];
			}
			
			stack.push(new int[] {arr[i], i});
		}
		
		while(!stack.isEmpty()) {
			int[] temp = stack.pop();
			result[temp[1]] = -1;
		}
		
		for(int i=0; i<result.length; i++) {
			output.append(result[i]+" ");
		}
		
		System.out.println(output.toString());
	}

}
