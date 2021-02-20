package ps.swea.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 19.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AWIeUtVakTMDFAVH&probBoxId=AXe3jlIKUxMDFAUO&type=PROBLEM&problemBoxTitle=0219&problemBoxCnt=2
 * @mem 33896
 * @time 189
 * @caution [1,2] [3,4] 와 [3,4] [1,2]는 같으므로 연산횟수를 절반으로 줄일 수 있다.
 */

public class Solution_4012_요리사 {

	static int T, N, result = Integer.MAX_VALUE;
	static int count, maxCount;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N + 1][N + 1]; // 음식 번호 1부터
			result = Integer.MAX_VALUE; // result 초기화
			maxCount = 0;
			count = 0;
			for (int r = 1; r <= N; r++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				for (int c = 1; c <= N; c++) {
					map[r][c] = Integer.parseInt(tokenizer.nextToken());
				}
			}
			maxCount = combCount(N, N / 2);
			makeComb(0, new boolean[N + 1], 1);
			output.append("#" + tc + " " + result + "\n");
		}
		System.out.println(output.toString());
	}

	static int combCount(int n, int r) {

		// r까지만 곱, r이후는 나누기
		int num = 1;
		for (int i = n; i >= 1; i--) {
			if (i > r) {
				num *= i;
			} else {
				num /= i;
			}
		}
		return num;
		// 아래는 다 계산 하는 방식
//		BigInteger a = new BigInteger("1");
//		BigInteger b = new BigInteger("1");
//		for (int i = 1; i <= n; i++) {
//			a = a.multiply(new BigInteger(Integer.toString(i)));
//			if (i <= r) {
//				b = b.multiply(new BigInteger(Integer.toString(i)));
//			}
//		}
//
//		String num = a.divide((b.multiply(b))).toString();
//		return Integer.parseInt(num);
	}

	static void makeComb(int cnt, boolean[] choosed, int startIdx) {

		if (count >= maxCount / 2) {
			return;
		}

		if (cnt == N / 2) {
			count++;
			List<Integer> selected = new ArrayList<>();
			List<Integer> unselected = new ArrayList<>();
			for (int i = 1; i < choosed.length; i++) {
				if (choosed[i]) {
					selected.add(i);
				} else {
					unselected.add(i);
				}
			}
//			System.out.println(selected);
//			System.out.println(unselected);
			int foodA = 0;
			int foodB = 0;
			for (int i = 0; i < cnt - 1; i++) {
				for (int j = i + 1; j < cnt; j++) {
					foodA += map[selected.get(i)][selected.get(j)] + map[selected.get(j)][selected.get(i)];
					foodB += map[unselected.get(i)][unselected.get(j)] + map[unselected.get(j)][unselected.get(i)];
				}
			}
			int diff = Math.abs(foodA - foodB);
			result = Math.min(result, diff);
		}

		for (int i = startIdx; i <= N; i++) {
			choosed[i] = true;
			makeComb(cnt + 1, choosed, i + 1);
			choosed[i] = false;
		}
	}

}
