package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 21.
 * @author user
 * @see https://www.acmicpc.net/problem/2559
 * @mem 25440
 * @time 284
 * @caution
 */

public class Solution_s3_2559_수열 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());

		arr = new int[N];
		tokenizer = new StringTokenizer(input.readLine(), " ");
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
			if (i < K) {
				sum += arr[i];
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		result.add(sum);
		int index = 0;
		for (int i = K; i < N ; i++, index++) {
			sum += arr[i];
			sum -= arr[index];
			result.add(sum);
		}
		
		Collections.sort(result);
		
		System.out.println(result.get(result.size()-1));

	}

}
