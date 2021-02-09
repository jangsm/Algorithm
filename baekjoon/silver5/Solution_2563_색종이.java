package ps.bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		boolean[][] map = new boolean[100][100];
		
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int startX = Integer.parseInt(tokenizer.nextToken());
			int startY = Integer.parseInt(tokenizer.nextToken());
			
			for(int x=startX; x<startX+10; x++) {
				for(int y = startY; y<startY+10; y++) {
					map[x][y]= true; 
				}
			}
		}
		int result = 0;
		for(int x=0; x<100; x++) {
			for(int y=0; y<100; y++) {
				if (map[x][y]) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}

}
