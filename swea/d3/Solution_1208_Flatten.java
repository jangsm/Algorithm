package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 2.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV139KOaABgCFAYh&probBoxId=AXdgvuDKbeYDFAUO&type=PROBLEM&problemBoxTitle=0202&problemBoxCnt=1
 * @mem 20340
 * @time 120
 * @caution
 */

public class Solution_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int[] box = new int[100];

		for (int tc = 1; tc <= 10; tc++) {
			output.setLength(0);
			int dump = Integer.parseInt(input.readLine());
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < box.length; i++) {
				box[i] = Integer.parseInt(tokenizer.nextToken());
			}

			int result = 0;
			int max = 0;
			int maxIndex = 0;
			int min = 101;
			int minIndex = 0;

			boolean isFlat = false;

			for (int i = 0; i < dump; i++) {
				for (int j = 0; j < box.length; j++) {
					if (max < box[j]) {
						max = box[j];
						maxIndex = j;
					}

					if (min > box[j]) {
						min = box[j];
						minIndex = j;
					}
				}

				if (max - min == 1) {
					result = 1;
					isFlat = true;
					break;
				} else if (max - min == 0) {
					result = 0;
					isFlat = true;
					break;
				} else {
					box[maxIndex] -= 1;
					box[minIndex] += 1;
					max = 0;
					min = 101;
				}
			}

			if (!isFlat) {
				for (int i = 0; i < box.length; i++) {
					if (max < box[i]) {
						max = box[i];
						maxIndex = i;
					}

					if (min > box[i]) {
						min = box[i];
						minIndex = i;
					}
				}

				result = max - min;
			}

			output.append("#").append(tc).append(" ").append(result);
			System.out.println(output.toString());
		}

	}

}
