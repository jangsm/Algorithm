package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 21.
 * @author user
 * @see https://www.acmicpc.net/problem/14696
 * @mem 26276
 * @time 244
 * @caution
 */

public class Solution_b1_14696_딱지놀이 {

	static int N;
	static int[] arrA, arrB;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		N = Integer.parseInt(input.readLine());
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int num = Integer.parseInt(tokenizer.nextToken());
			arrA = new int[4];
			for (int j = 0; j < num; j++) {
				int shape = Integer.parseInt(tokenizer.nextToken());
				switch (shape) {
				case 4:
					arrA[0]++;
					break;
				case 3:
					arrA[1]++;
					break;
				case 2:
					arrA[2]++;
					break;
				case 1:
					arrA[3]++;
					break;
				default:
					break;
				}
			}

			tokenizer = new StringTokenizer(input.readLine(), " ");
			num = Integer.parseInt(tokenizer.nextToken());
			arrB = new int[4];
			for (int j = 0; j < num; j++) {
				int shape = Integer.parseInt(tokenizer.nextToken());
				switch (shape) {
				case 4:
					arrB[0]++;
					break;
				case 3:
					arrB[1]++;
					break;
				case 2:
					arrB[2]++;
					break;
				case 1:
					arrB[3]++;
					break;
				default:
					break;
				}
			}
			
			solve();
		}
		
		System.out.println(output.toString());
	}

	static void solve() {
		
		for(int i=0; i<4; i++) {
			if (arrA[i] > arrB[i] ) {
				output.append("A\n");
				break;
			} else if (arrA[i]< arrB[i] ) {
				output.append("B\n");
				break;
			}
			
			if (i==3 && arrA[i]== arrB[i] ) {
				output.append("D\n");
				break;
			}
		}
	}

}
