package ps.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 2.
 * @author user
 * @see https://www.acmicpc.net/problem/1018
 * @mem
 * @time
 * @caution
 */

public class 브루트포스_no1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		char[][] chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			chess[i] = input.readLine().toCharArray();
		}

		int maxStartX = N - 8;
		int maxStratY = M - 8;

		int result = Integer.MAX_VALUE;

		for (int i = 0; i <= maxStartX; i++) {
			for (int j = 0; j <= maxStratY; j++) {
				int tempW = 0;
				int tempB = 0;
				for (int a = i; a < i + 8; a++) {
					for (int b = j; b < j + 8; b++) {
						if ((a+b)%2==0 && chess[a][b]!='W') {
							tempW++;
						} else if ((a+b)%2==1 && chess[a][b]!='B') {
							tempW++;
						}
						
						if ((a+b)%2==1 && chess[a][b]!='W') {
							tempB++;
						} else if ((a+b)%2==0 && chess[a][b]!='B') {
							tempB++;
						}
					}
				}
				
				int temp = Math.min(tempW, tempB);
				result = Math.min(temp, result);
			}
		}
		
		System.out.println(result);
	}

}
