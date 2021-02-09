package ps.bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/1652
 * @mem
 * @time
 * @caution
 */

public class Solution_1652_누울자리를찾아라 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		char[][] room = new char[N][N];
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			String row = input.readLine();
			room[i] = row.toCharArray();
			int continuity = 0;
			for(int j=0; j<N; j++) {
				if (room[i][j]=='.') {
					continuity++;
				} else {
					continuity = 0;
				}
				
				if (continuity==2) {
					r++;
				}
			}
		}

		for (int j = 0; j < N; j++) {
			int continuity = 0;
			for (int i = 0; i < N; i++) {
				if (room[i][j]=='.') {
					continuity++;
				} else {
					continuity = 0;
				}
				
				if (continuity==2) {
					c++;
				}
			}
		}

		System.out.println(r + " " + c);
	}

}
