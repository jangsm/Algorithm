package ps.study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 2.
 * @author user
 * @see https://www.acmicpc.net/problem/16956
 * @mem 22304
 * @time 200
 * @caution 스페셜저지 문제 : 정답 여러가지!!
 * 			늑대를 울타리로 둘러싸는 방법으로 해결
 */

public class Solution_16956_늑대와양 {

	static int R, C;
	static char[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());
		map = new char[R][C];

		List<int[]> wolf = new ArrayList<int[]>();
		for (int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
			for (int c = 0; c < map[r].length; c++) {
				if (map[r][c] == 'W') {
					wolf.add(new int[] { r, c });
				}
			}
		}

		int result = 1;
		outer: for (int i = 0; i < wolf.size(); i++) {
			int x = wolf.get(i)[0];
			int y = wolf.get(i)[1];

			for (int d = 0; d < dir.length; d++) {
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];
				
				if (nx<0 || nx>=R || ny<0 || ny>=C) {
					continue;
				}
				
				if (map[nx][ny]=='S') {
					result = 0;
					break outer;
				} else if (map[nx][ny]=='.') {
					map[nx][ny] = 'D'; 
				}
			}
		}
		
		if (result==1) {
			output.append(result + "\n");
			for(int r=0; r<R; r++) {
				for(int c=0; c<C;c++) {
					output.append(map[r][c]);
				}
				output.append("\n");
			}
		} else {
			output.append(result + "\n");
		}
		
		System.out.println(output.toString());
	}

}
