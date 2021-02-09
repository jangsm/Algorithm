package ps.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV141176AIwCFAYD&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0209&problemBoxCnt=1&probBoxId=AXeFTdYKuJwDFAUO
 * @mem 20540
 * @time 115
 * @caution
 */

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(input.readLine());
			char[] nodes = new char[N + 1]; // 0번 사용x
			int leafStartIdx = -1;
			for (int i = 1; i <= N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				if (leafStartIdx==-1 && tokenizer.countTokens()==2) {
					leafStartIdx = i;
				}
				int index = Integer.parseInt(tokenizer.nextToken());
				char c = tokenizer.nextToken().charAt(0);
				nodes[index] = c;
			}
			// 구조상 leaf 노드만 숫자여야 하고 나머지는 연산자여야한다.
//			int height = 0;
//			for (int i = 0; i < 9; i++) {
//				if (N < (int) Math.pow(2, i)) {
//					height = i - 1;
//					break;
//				}
//			}
			
//			int leafStartIdx = (int)Math.pow(2, height);
//			System.out.println(leafStartIdx);
			boolean isError = false;
			for(int i=1; i<leafStartIdx; i++) {
				if (nodes[i]!='+'&&nodes[i]!='-'&&nodes[i]!='*'&&nodes[i]!='/') {
					isError = true;
					break;
				}
			}
			
			if (!isError) {
				for(int i =leafStartIdx; i<=N; i++) {
					if(nodes[i]<'0' || nodes[i]>'9') {
						isError = true;
						break;
					}
				}
			}
			
			output.append("#"+tc+" ");
			if (isError) {
				output.append("0\n");
			} else {
				output.append("1\n");
			}
		}
		System.out.println(output.toString());
	}

}
