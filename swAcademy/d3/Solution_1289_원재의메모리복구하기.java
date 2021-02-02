package ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 1.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AXdbYpUKxsoDFAUO+&type=PROBLEM&problemBoxTitle=0201&problemBoxCnt=++1+#
 * @mem 16076
 * @time 98
 * @caution 
 */

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokenizer;
		
//		input = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			char[] memory = input.readLine().toCharArray();
			int answer = 0;
			if (memory[0]=='1') {
				answer++;
			}
			for(int i=1; i<memory.length; i++) {
				if (memory[i-1]!=memory[i]) {
					answer++;
				}
			}
			
			output.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(output);
	}
	
	// 입력을 받아놓자
	static String src = "2\r\n" + 
			"0011\r\n" + 
			"100";

}
