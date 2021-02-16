package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 16.
 * @author user
 * @see https://www.acmicpc.net/problem/1629
 * @mem 11520
 * @time 80
 * @caution 재귀호출시 반복되는 값을 한번만 구하고 변수로 담아둔뒤 사용해야한다.
 * 			long n = exp(a, b / 2, c); => n*n
 * 			exp(a, b / 2, c) * exp(a, b / 2, c) => 이렇게 호출하면 구한값을 다시 또 구하기 위해 계속 연산하므로 결국 분할정복의 이점이 사라진다.
 * 			숫자가 큰 문제의 경우 long 사용!!
 */

public class Solution_1629_곱셈 {

	static int A, B, C;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		A = Integer.parseInt(tokenizer.nextToken());
		B = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());

		System.out.println(exp(A, B, C));
	}

	static long exp(int a, int b, int c) {
		if (b == 1) {
			return a % c;
		}

		long n = exp(a, b / 2, c);
		long result = (n * n) % c; // n*n이 순간적으로 int 범위 초과 가능
		if (b % 2 == 1) {
			result = (result * a) % c;
		}

		return result;
	}

}
