package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/2716
 * @mem 16252
 * @time 156
 * @caution 포인트는 결국 무게를 맞추기 위해서는 가장 깊은 노드를 기준으로 반대쪽도 같은 무게이므로 x2씩 무게가 증가한다. 즉, depth만큼 2를 곱해줘야 한다.!!
 */

public class Solution_2716_원숭이매달기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			String str = input.readLine();
			int maxDepth = 0;
			int depth = 0;
			for(int j=0; j<str.length(); j++) {
				if (str.charAt(j)=='[') {
					depth++;
					if (depth>maxDepth) {
						maxDepth = depth;
					}
				} else {
					depth--;
				}
			}
			
			int result = (int)Math.pow(2, maxDepth);
			output.append(result+"\n");
		}
		System.out.println(output.toString());
	}

}
