package ps.bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		String str = input.readLine();
		int len = str.length();

		int R = 0, C = 0;
		for (int i = (int) Math.sqrt(len); i >= 1; i--) {
			if (len % i == 0) {
				R = i;
				C = len / i;
				break;
			}
		}

		char[][] arr = new char[R][C];
		int index = 0;
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				arr[r][c] = str.charAt(index++);
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				output.append(arr[r][c]);
			}
		}

		System.out.println(output.toString());
	}

}
