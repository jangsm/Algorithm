package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15650_N과M_2 {

	static int[] data;
	static int N, M;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = i + 1;
		}
		
		makeComb(0, new int[M], 0);
		System.out.println(output.toString());
	}

	static void makeComb(int cnt, int[] choosed, int startIdx) {
		if (cnt==M) {
			for(int i=0; i<choosed.length; i++) {
				output.append(choosed[i]).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for(int i=startIdx; i<data.length; i++) {
			choosed[cnt] = data[i];
			makeComb(cnt+1, choosed, i+1);
		}
	}
}
