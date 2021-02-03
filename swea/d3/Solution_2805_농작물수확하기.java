package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 3.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV7GLXqKAWYDFAXB&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0203&problemBoxCnt=2&probBoxId=AXdmB9SaRgQDFAUO
 * @mem 23888
 * @time 118
 * @caution
 */

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(input.readLine());

			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] arr = input.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Integer.parseInt(String.valueOf(arr[j]));
				}
			}

			// 출력확인
//			for(int[] subArr : farm) {
//				System.out.println(Arrays.toString(subArr));
//			}

			int sum = 0;
			for (int i = 0; i < N; i++) {
				int index;
				if (i <= N / 2) {
					index = N / 2 - i;
				} else {
					index = i - N / 2;
				}
				for(int j=index; j<N-index; j++) {
					sum += farm[i][j];
				}
			}
			
			output.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		System.out.println(output.toString());
	}

}
