package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 7.
 * @author user
 * @see https://www.acmicpc.net/problem/1914
 * @mem 63864
 * @time 480
 * @caution 이동횟수를 구하는 점화실을 알아야하는 문제, 
 * 			원판 n개에 대하여 2^n-1번 이동한다, 
 * 			횟수가 굉장히 빠르게 증가하기 때문에 long으로도 담지 못하고 BigInteger필요
 */

public class Solution_1914_하노이탑 {

	static int N;
	static BigInteger result = new BigInteger("1");
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			result = result.multiply(new BigInteger("2"));
		}
		result = result.subtract(new BigInteger("1"));
		output.append(result + "\n");
		if (N<=20) {
			hanoi(N, 1, 2, 3);	
		}
		System.out.println(output.toString());
	}

	static void hanoi(int n, int start, int temp, int end) {
		if (n == 0) {
			return;
		}

		hanoi(n - 1, start, end, temp);
		output.append(start + " " + end + "\n");
		hanoi(n - 1, temp, start, end);
	}

}
