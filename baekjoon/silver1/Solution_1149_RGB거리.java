package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 23.
 * @author user
 * @see https://www.acmicpc.net/problem/1149
 * @mem 12100
 * @time 96
 * @caution dp인데 greedy로 시도함 -> 색칠할 수 있는 경우가 3개이므로 3개에 대해서 dp를 한다.
 * 			dp[N][0] = Math.min(dp[N-1][1], dp[N-1][2]) + costArr[N].red;
 * 			현재단계에서 칠할 색과 이전 단계에서 칠할수 있는 색 중 최소를 더한다.
 */

public class Solution_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		Cost[] costArr = new Cost[N+1];
		for(int i=1; i<=N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int red = Integer.parseInt(tokenizer.nextToken());
			int green = Integer.parseInt(tokenizer.nextToken());
			int blue = Integer.parseInt(tokenizer.nextToken());
			
			costArr[i] = new Cost(red, green, blue); 
		}
		
		int[][] dp = new int[N+1][3];
		dp[1][0] = costArr[1].red;
		dp[1][1] = costArr[1].green;
		dp[1][2] = costArr[1].blue;
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costArr[i].red;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costArr[i].green;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costArr[i].blue;
		}
		
		int min = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
		
		System.out.println(min);
		
//		dp[N][0] = Math.min(dp[N-1][1], dp[N-1][2]) + costArr[N].red;
		
	}
	
	static class Cost {
		int red, green, blue;

		public Cost(int red, int green, int blue) {
			super();
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
		
		
	}

}
