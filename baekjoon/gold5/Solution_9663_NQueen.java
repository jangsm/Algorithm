package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9663_NQueen {

	static int N, ans;
	static int[] col; // 같은 행에는 둘 필요가 없으므로 열만 기억하면 된다.

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		col = new int[N + 1]; // 1부터 시작

		setQueen(0); // 0 queen은 없지만 있다고 가정하면 
		// 1번부터는 탐색시작하는 구조로 짤 수 있다.
		
		System.out.println(ans);
	}

	static void setQueen(int rowNo) {

		// 현재 노드가 유망하지 않다면 돌아가기
		if (!isAvailable(rowNo)) {
			return;
		}

		if (rowNo == N) {
			ans++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			col[rowNo + 1] = i;
			setQueen(rowNo + 1);
		}
	}

	static boolean isAvailable(int rowNo) {
		// 가로, 세로, 대각선 검사 => 가로는 애초에 안두기로 했으므로 검사 필요x
		for (int i = 1; i < rowNo; i++) {
			// 퀸이 서로 위협적인 위치면 false
			if (col[rowNo] == col[i] || Math.abs(col[rowNo] - col[i]) == rowNo - i) { // 같은 열에 있으면 또는 대각선이면
				// 대각선의 경우 열차이와 행차이가 같게되는 특성이용
				// (2, 2) 기준으로 (1, 1),(1,3),(3,1),(3,3)이 대각선인데
				// 모두 열차이 행차이가 1이 난다.(절대값 기준)
				return false;

			}
		}

		return true;
	}

}
