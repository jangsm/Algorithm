package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/14430
 * @mem 20896
 * @time 204
 * @caution dp이용-> 완탐으로는 시간초과
 */

public class Solution_14430_자원캐기 {

	static int N, M, result = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		solve();
		System.out.println(map[N-1][M-1]);
	}

//	static void solve(int x, int y, int cnt) {
//		
//		if(x==N-1 && y==M-1) {
//			result = Math.max(result, cnt);
//			return;
//		}
//
//		for (int i = 0; i < dir.length; i++) {
//			int nx = x + dir[i][0];
//			int ny = y + dir[i][1];
//
//			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
//				continue;
//			}
//
//			if (map[nx][ny] == 1) {
//				solve(nx, ny, cnt + 1);
//			} else {
//				solve(nx, ny, cnt);
//			}
//		}
//	}
	
	static void solve() {
		// 범위를 N+1, M+1로 하면 초기화작업 분기처리 없이 어차피 0행, 0열은 0이므로 같은 방식으로 해결 가능
		// 입력받으면서 바로 처리도 가능..??
		for(int c=1; c<M; c++) {
			map[0][c] += map[0][c-1]; 
		}
		
		for(int r=1; r<N; r++) {
			map[r][0] += map[r-1][0];
		}
		
		for(int r=1; r<N; r++) {
			for(int c=1; c<M; c++) {
				map[r][c]+= Math.max(map[r][c-1], map[r-1][c]); 
			}
		}
	}

}
