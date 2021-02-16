package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2961_도영이가만든맛있는음식 {

	static int N;
	static int[][] ingredients;
	static int count;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		ingredients = new int[N][2];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			ingredients[i][0] = Integer.parseInt(tokenizer.nextToken());
			ingredients[i][1] = Integer.parseInt(tokenizer.nextToken());
		}
		
		powerSet(0, new boolean[N]);
		System.out.println(result);
	}

	static void powerSet(int cnt, boolean[] visited) {
		if (count == (1 << (N - 1))) {
			return;
		}
		if (cnt == N) {
			int selectedS = 1;
			int selectedB = 0;
			int unselectedS = 1;
			int unselectedB = 0;
			int selectCount = 0;
			int unselectCount = 0;
			for(int i=0; i<visited.length; i++) {
				if (visited[i]) {
					selectedS *= ingredients[i][0];
					selectedB += ingredients[i][1];
					selectCount++;
				} else {
					unselectedS *= ingredients[i][0];
					unselectedB += ingredients[i][1];
					unselectCount++;
				}
			}
			if (selectCount != 0 && unselectCount!=0) {
				int temp = Math.min(Math.abs(selectedS-selectedB), Math.abs(unselectedS-unselectedB));
				result = Math.min(result, temp);
			} else {
				if (selectCount==0) {
					result = Math.min(result, Math.abs(unselectedS-unselectedB));	
				} else {
					result = Math.min(result, Math.abs(selectedS-selectedB));
				}
				
			}
			count++;
//			System.out.println("[ " +selectCount + ", "+ unselectCount +", " + selectedS + ", " + selectedB + ", " + unselectedS+", " + unselectedB + ", " + result +" ]");
			return;
		}

		visited[cnt] = true;
		powerSet(cnt + 1, visited);
		visited[cnt] = false;
		powerSet(cnt + 1, visited);
	}

}
