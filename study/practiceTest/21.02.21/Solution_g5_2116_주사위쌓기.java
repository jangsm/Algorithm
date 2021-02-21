package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_g5_2116_주사위쌓기 {

	static int N, result, answer;
	static int[][] dice;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		dice = new int[N][6];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(tokenizer.nextToken()); // [0,5], [1,3], [2,4]
			}
		}
		
		for(int i = 0; i<6; i++) {
			solve(dice[0][i]);
			int index = convert(i);
			int max = 0;
			for(int j = 0; j<6; j++) {
				if (j!= i && j!= index) {
					max = Math.max(max, dice[0][j]);
				}
			}
			result += max;
			answer = Math.max(answer, result);
			result = 0;
		}
		
		System.out.println(answer);
	}

	static void solve(int top) {

		int curTop = top;

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 6; j++) {
				if (dice[i][j] == curTop) {
					int index = convert(j);
					curTop = dice[i][index];
					int max = 0;
					for(int k = 0; k<6; k++) {
						if (k!= j && k!= index) {
							max = Math.max(max, dice[i][k]);
						}
					}
					result += max;
					break;
				}
			}
		}
	}

	static int convert(int a) {
		int num = 0;
		switch (a) {
		case 0:
			num = 5;
			break;
		case 1:
			num = 3;
			break;
		case 2:
			num = 4;
			break;
		case 3:
			num = 1;
			break;
		case 4:
			num = 2;
			break;
		case 5:
			num = 0;
			break;
		default:
			break;
		}
		return num;
	}

}
