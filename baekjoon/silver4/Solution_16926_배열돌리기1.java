package ps.bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 10.
 * @author user
 * @see https://www.acmicpc.net/problem/16926
 * @mem 299604
 * @time 952
 * @caution 구현문제!! 시간과 메모리를 너무 많이 사용해서 품 -> 더 나은 방법을 생각해봐야한다.
 * 			문제를 분해해서 하나씩 본다!! 문제에서 사용할 수 있는 index를 이용해서 먼저 각 경우를 표현해본 후 코딩하기
 * 			메모리 문제의 경우 새로운 배열을 만들어서 값을 복사해오는것이 아닌 기존 배열에 값을 덮어쓰면서 마지막에 덮어씌여질 값만 따로 변수로 저장해놓는다!!
 */

public class Solution_16926_배열돌리기1 {

	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		R = Integer.parseInt(tokenizer.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		
		for(int i = 0; i<R; i++) {
			arr = rotate();
		}
		
		for(int i = 0; i<N; i++) {
			for(int j=0; j<M; j++) {
				output.append(arr[i][j]+" ");
			}
			output.append("\n");
		}
		
		System.out.println(output.toString());
	}

	static int[][] rotate() {
		int[][] newArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int distX, distY;
				if (i<N/2) {
					distX = i;
				} else {
					distX = N-1-i;
				}
				
				if (j<M/2) {
					distY = j;
				} else {
					distY = M-1-j;
				}
				
				int depth = Math.min(distX, distY);
				
				if (i == depth) {
					if (j - 1 >= depth) {
						newArr[i][j - 1] = arr[i][j];
					}
				}
				if (j == depth) {
					if (i + 1 < N - depth) {
						newArr[i + 1][j] = arr[i][j];
					}
				}
				if (i == N - 1 - depth) {
					if (j + 1 < M - depth) {
						newArr[i][j + 1] = arr[i][j];
					}
				}
				if (j == M - 1 - depth) {
					if (i - 1 >= depth) {
						newArr[i - 1][j] = arr[i][j];
					}
				}
			}
		}
		
		return newArr;

	}
}
