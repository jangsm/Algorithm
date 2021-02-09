package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1747_소수팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());

		while (true) {
			if (isPrime(N) && isPallin((N))) {
				System.out.println(N);
				break;
			}
			N++;
		}
	}

	static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	static boolean isPallin(int num) {
		String numStr = Integer.toString(num);

		for (int i = 0; i < numStr.length() / 2; i++) {
			if (numStr.charAt(i) == numStr.charAt(numStr.length() - 1 - i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}
