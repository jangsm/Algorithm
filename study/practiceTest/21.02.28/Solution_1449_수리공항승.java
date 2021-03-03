package ps.study.practiceTest.date210228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 28.
 * @author user
 * @see https://www.acmicpc.net/problem/1449
 * @mem 11716
 * @time 92
 * @caution 입력이 오름차순이라는 내용이 없으므로 sort
 */

public class Solution_1449_수리공항승 {

	static int N, L;
	static int[] pos;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		L = Integer.parseInt(tokenizer.nextToken());

		pos = new int[N];
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pos[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(pos); // sort 해주기

		int index = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (pos[i] - pos[index] + 1 > L) {
				index = i;
				count++;
			}
		}
		
		// 마지막 n-1번째는 무조건 테이프 하나 더 필요
		count++;
		System.out.println(count);
	}

}
