package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

	static int T, N, L;
	static int[][] ingredients;
	static int calorie, score;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			N = Integer.parseInt(tokenizer.nextToken());
			L = Integer.parseInt(tokenizer.nextToken());
			calorie = 0;
			score = 0;
			count = 0;
			
			ingredients = new int[N][2];
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				ingredients[i][0] = Integer.parseInt(tokenizer.nextToken());
				ingredients[i][1] = Integer.parseInt(tokenizer.nextToken());
			}

			powerSet(0, 0, 0, new boolean[N]);

			output.append("#" + tc + " " + score + "\n");
		}
		System.out.println(output.toString());
	}

	static void powerSet(int cnt, int curCal, int curScore, boolean[] isSelected) {
//		if (count == (1<<(N-1))) {
//			return;
//		}
		
		if (curCal>L) {
			return;
		}
		
		if (cnt == N) {
//			count++;
//			int sumScore = 0;
//			int sumCalorie = 0;
//			int extraScore = 0;
//			int extraCalorie = 0;
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i]) {
//					sumScore += ingredients[i][0];
//					sumCalorie += ingredients[i][1];
//				} else {
//					extraScore += ingredients[i][0];
//					extraCalorie += ingredients[i][1];
//				}
//			}
//			if (sumScore > score && sumCalorie <= L) {
//				score = sumScore;
//			}
//			if (extraScore > score && extraCalorie <= L) {
//				score = extraScore;
//			}
			
			score = Math.max(curScore, score);
			return;
		}

		isSelected[cnt] = true;
		powerSet(cnt + 1, curCal+ingredients[cnt][1], curScore+ingredients[cnt][0], isSelected);
		isSelected[cnt] = false;
		powerSet(cnt + 1, curCal,curScore, isSelected);
	}

}
