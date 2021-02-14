package ps.study.practiceTest.date210214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 14.
 * @author user
 * @see 
 * @mem
 * @time
 * @caution
 */

public class Solution_s1_1991_트리순회 {

	static int N;
	static char[][] nodes;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		N = Integer.parseInt(input.readLine());
		nodes = new char[N + 1][3];

		for (int n = 1; n <= N; n++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			char parent = tokenizer.nextToken().charAt(0);
			char left = tokenizer.nextToken().charAt(0);
			char right = tokenizer.nextToken().charAt(0);

			int index = parent - 'A' + 1;
			nodes[index] = new char[] { parent, left, right };
		}

		preorder('A');
		output.append("\n");
		inorder('A');
		output.append("\n");
		postorder('A');
		output.append("\n");
		System.out.println(output.toString());

	}

	static void preorder(char root) {
		int index = root - 'A' + 1;

		output.append(nodes[index][0]);
		if (nodes[index][1] != '.') {
			preorder(nodes[index][1]);
		}
		if (nodes[index][2] != '.') {
			preorder(nodes[index][2]);
		}
	}

	static void inorder(char root) {
		int index = root - 'A' + 1;

		if (nodes[index][1] != '.') {
			inorder(nodes[index][1]);
		}
		output.append(nodes[index][0]);
		if (nodes[index][2] != '.') {
			inorder(nodes[index][2]);
		}
	}

	static void postorder(char root) {
		int index = root - 'A' + 1;

		if (nodes[index][1] != '.') {
			postorder(nodes[index][1]);
		}
		if (nodes[index][2] != '.') {
			postorder(nodes[index][2]);
		}
		output.append(nodes[index][0]);
	}

}
