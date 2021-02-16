package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1931_회의실배정 {

	static int N;
	static int[][] meeting;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		meeting = new int[N][2];
		for(int i=0; i<N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			meeting[i][0] = Integer.parseInt(tokenizer.nextToken());
			meeting[i][1] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int result = 1;
		int start = meeting[0][1];
		for(int i=1; i<N; i++) {
			if (start<=meeting[i][0]) {
				start = meeting[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}

}
