package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 16.
 * @author user
 * @see https://www.acmicpc.net/problem/12865
 * @mem 51344
 * @time 148
 * @caution 0/1 Knapsack problem => dp이용해야한다
 * 			물건을 선택하지 못하는 경우(무게 초과), 선택할 수 있는 경우 -> 선택할 수 있는데 안하는 것과, 선택한 것중 더 큰값
 * 			비교는 이전 단계(물건 개수)에서 무게를 기준으로!!
 */

public class Solution_12865_평범한배낭 {

	static int N, K;
	static int[][] things;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());
		things = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			things[i][0] = Integer.parseInt(tokenizer.nextToken()); // 무게
			things[i][1] = Integer.parseInt(tokenizer.nextToken()); // 가치
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				int weight = things[i][0];
				int value = things[i][1];
				// 못넣는 경우, 넣을 수 있는 경우(안 넣는 경우, 넣는 경우)
				// 1. 못 넣는 경우
				if(weight>j) {
					dp[i][j] = dp[i-1][j]; // 못넣는 경우에는 이전거 그대로가 최선 
				} 
				// 2. 넣을 수 있는 경우
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value); // 선택 안하는 경우, 선택하는 경우 	
					// 이번거를 선택안하고 이전거 선택하는게 최대 가치일 수 있음
					// 무게에 따라 다르다. 
					// dp[i-1][j-weight]+value는 이전 선택 가치에 지금 선택 가치를 더하는 거일 수도 있지만 이전 선택 x에 이번거만 일 수 있다.
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
		
	}

}
