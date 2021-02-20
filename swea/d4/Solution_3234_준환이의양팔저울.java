package ps.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 20.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWAe7XSKfUUDFAUw&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0219&problemBoxCnt=2&probBoxId=AXe3jlIKUxMDFAUO
 * @mem 20620
 * @time 764
 * @caution 전역변수와 지역변수의 시간차이???
 * 			순열 후 powerset을 다시 하면 시간초과 -> 굉장히 비효율적
 * 			순열을 진행하면서 재귀적 호출을 할때 left, right값을 따로 관리해주면 한번에 처리 가능하다.
 * 			이 경우, 무조건 left가 남은부분에 상관없이 큰 상황이 오면 남은 개수에 대해서 n! * 2^n 만큼의 경우가 나온다.
 * 			해당 경우는 n이 1부터 9까지 동일하므로 미리 구해놓고 가져다 사용하는식으로 시간을 줄일 수 있다.
 */

public class Solution_3234_준환이의양팔저울 {

	static int T, N, sum, result;
	static int[] weight, copy;
	static int[] preCnt; // 전처리 n! * 2^n을 담아놓는다.

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		preCnt = new int[10]; // N은 9까지 이므로 한번만 구해놓고 가져다가 사용
		preCnt[0] = 1;
		for (int i = 1; i <= 9; i++) {
			preCnt[i] = preCnt[i - 1] * i * 2; // n! * 2^n = (n-1)! * 2^(n-1) * n * 2
		}

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			weight = new int[N];
			sum = 0;
			result = 0;

			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(tokenizer.nextToken());
				sum += weight[i];
			}

			makePerm(0, new boolean[N], 0, 0);

			output.append("#" + tc + " " + result + "\n");
		}
		System.out.println(output.toString());
	}

	static void makePerm(int cnt, boolean[] visited, int left, int right) { // 순열을 만들면서 순열 후 powerset연산을 하는것까지 포함시킬 수 있다.

		if (right > left) {
			return;
		}

		if (left > sum / 2) { // 합의 절반이 넘었으면 남은 부분에 상관없이 무조건 조건에 충족
//			int n = N - cnt;
//			int num = 1;
//			for (int i = 1; i <= n; i++) {
//				num *= i;
//			}
//			result += num * Math.pow(2, n); // 순열을 만들면서 좌 우 검사를 해야하므로 2^n * n!이 되어야한다
			result += preCnt[N-cnt];
			return;
		}

		if (cnt == N) {
			result++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			makePerm(cnt + 1, visited, left + weight[i], right);
			makePerm(cnt + 1, visited, left, right + weight[i]);
			visited[i] = false;
		}
	}

//	static boolean nextPerm() {
//		int i = weight.length - 1;
//		int j = weight.length - 1;
//
//		while (i > 0 && weight[i - 1] >= weight[i])
//			i--;
//		if (i == 0) {
//			return false;
//		}
//
//		while (weight[i - 1] >= weight[j])
//			j--;
//
//		int temp = weight[i - 1];
//		weight[i - 1] = weight[j];
//		weight[j] = temp;
//
//		int k = weight.length - 1;
//		while (i < k) {
//			temp = weight[i];
//			weight[i] = weight[k];
//			weight[k] = temp;
//			i++;
//			k--;
//		}
//		return true;
//	}
//
//	static void powerset(int cnt, int left, int right) { // true가 왼쪽
//
//		if (right > left) {
//			return;
//		}
//
//		if (left > sum / 2) { // 합의 절반이 넘었으면 남은 부분에 상관없이 무조건 조건에 충족
//			result += Math.pow(2, N - cnt);
//			return;
//		}
//
//		if (cnt == N) {
//			result++;
//			return;
//		}
//
//		powerset(cnt + 1, left + weight[cnt], right); // left
//		powerset(cnt + 1, left, right + weight[cnt]); // right
//	}

}
