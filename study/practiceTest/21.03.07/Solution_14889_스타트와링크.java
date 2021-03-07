package ps.study.practiceTest.date210307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 7.
 * @author user
 * @see https://www.acmicpc.net/problem/14889
 * @mem 44520
 * @time 372
 * @caution
 */

public class Solution_14889_스타트와링크 {

	static int N, teamAIdx, teamBIdx, teamAScore, teamBScore, result = Integer.MAX_VALUE;
	static int[][] matrix;
	static int[] teamA, teamB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		matrix = new int[N+1][N+1]; // 1번부터 N번까지
		for(int i=1; i<N+1; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for(int j=1; j<N+1; j++) {
				matrix[i][j] = Integer.parseInt(tokenizer.nextToken()); 
			}
		}
		
		makeComb(0, 1, new boolean[N+1]);
		
		System.out.println(result);
	}
	
	static void makeComb(int cnt, int startIdx, boolean[] visited) {
		if (cnt==N/2) {
			teamA = new int[cnt];
			teamAIdx = 0;
			teamAScore = 0;
			teamB = new int[cnt];
			teamBIdx = 0;
			teamBScore = 0;
			for(int i=1; i<visited.length; i++) {
				if (visited[i]) {
					teamA[teamAIdx++] = i;
				} else {
					teamB[teamBIdx++] = i;
				}
			}
			
			makeComb2(0, 0, new int[2], 1);
			makeComb2(0, 0, new int[2], 0);
			result = Math.min(result, Math.abs(teamAScore-teamBScore));
			return;
		}
		
		for(int i=startIdx; i<=N; i++) { // 1~N
			visited[i] = true;
			makeComb(cnt+1, i+1, visited);
			visited[i] = false; 
		}
	}
	
	static void makeComb2(int cnt, int startIdx, int[] choosed, int team) {
		if (cnt==2) {
			if (team==1) {
				teamAScore += matrix[choosed[0]][choosed[1]];
				teamAScore += matrix[choosed[1]][choosed[0]];
			} else {
				teamBScore += matrix[choosed[0]][choosed[1]];
				teamBScore += matrix[choosed[1]][choosed[0]];
			}
			return;
		}
		
		for(int i=startIdx; i<N/2; i++) {
			if (team==1) {
				choosed[cnt] = teamA[i];
				makeComb2(cnt+1, i+1, choosed, team);
			} else {
				choosed[cnt] = teamB[i];
				makeComb2(cnt+1, i+1, choosed, team);
			}
		}
	}

}
