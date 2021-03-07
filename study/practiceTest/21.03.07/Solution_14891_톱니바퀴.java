package ps.study.practiceTest.date210307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 7.
 * @author user
 * @see https://www.acmicpc.net/problem/14891
 * @mem 11716
 * @time 88
 * @caution
 */

public class Solution_14891_톱니바퀴 {

	static int[][] gear;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String state = input.readLine();
			for (int j = 0; j < state.length(); j++) {
				gear[i][j] = Integer.parseInt(String.valueOf(state.charAt(j)));
			}
		}

		K = Integer.parseInt(input.readLine());
		for (int i = 0; i < K; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			solve(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				result += Math.pow(2, i);
			}
		}

		System.out.println(result);
	}

	static void solve(int n, int dir) {
		int index = n - 1;

		boolean[] flag = new boolean[3]; // false이면 이동 x
		for (int i = 1; i <= 3; i++) {
			if (gear[i - 1][2] == gear[i][6]) {
				flag[i - 1] = false;
			} else {
				flag[i - 1] = true;
			}
		}

		int[] rotate = new int[4];
		Arrays.fill(rotate, 99);
		rotate[index] = dir;

		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(index);

		while (!queue.isEmpty()) {
			index = queue.poll();

			if (index + 1 < 4 && rotate[index + 1] == 99) {
				queue.offer(index + 1);
				if (!flag[index]) {
					rotate[index + 1] = 0; // 변화 x
				} else {
					rotate[index + 1] = -rotate[index];
				}
			} 
			
			if (index - 1 >= 0 && rotate[index - 1] == 99) {
				queue.offer(index - 1);
				if (!flag[index - 1]) {
					rotate[index - 1] = 0; // 변화 x
				} else {
					rotate[index - 1] = -rotate[index];
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			rotate(i, rotate[i]);
		}
	}

	static void rotate(int n, int dir) {
		if (dir == 0) {
			return;
		} else if (dir == -1) {
			int temp = gear[n][0];
			for (int i = 1; i < 8; i++) {
				gear[n][i - 1] = gear[n][i];
			}
			gear[n][7] = temp;
			return;
		} else if (dir == 1) {
			int temp = gear[n][7];
			for (int i = 6; i >= 0; i--) {
				gear[n][i + 1] = gear[n][i];
			}
			gear[n][0] = temp;
			return;
		}
	}

}
