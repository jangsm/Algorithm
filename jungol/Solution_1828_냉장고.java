package ps.jo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 16.
 * @author user
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
 * @mem 12876
 * @time 212
 * @caution 그리디로 해결!!
 */

public class Solution_1828_냉장고 {

	static int N;
	static int[][] things;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		things = new int[N][2];
		for(int i=0; i<N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			things[i][0] = Integer.parseInt(tokenizer.nextToken());
			things[i][1] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(things, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]==o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int max = things[0][1];
		int result = 1;
		
		for(int i=1; i<N; i++) {
			if (max < things[i][0]) {
				max = things[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}

}
