package ps.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 3.
 * @author user
 * @see https://www.acmicpc.net/problem/2644
 * @mem 11632
 * @time 80
 * @caution
 */

public class Solution_2644_촌수계산 {

	static int N, X, Y, M;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		tokenizer = new StringTokenizer(input.readLine(), " ");
		X = Integer.parseInt(tokenizer.nextToken());
		Y = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(input.readLine());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			map[x][y] = 1;
			map[y][x] = 1; 
		}
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(X);
		
		int depth = 0;
		boolean isBreak = false;
		outer: while(!queue.isEmpty()) {
			
			int size = queue.size();
			while(size-- >0) {
				int temp = queue.poll();
				if (temp==Y) {
					isBreak = true;
					break outer;
				}
				
				for(int i=1; i<=N; i++) {
					if (map[temp][i]==1) {
						queue.offer(i);
						map[temp][i] = 0;
						map[i][temp] = 0;
					}
				}	
			}
			depth++;
		}
		
		if (!isBreak) {
			depth = -1;
		}
		
		System.out.println(depth);
	}

}
