package ps.swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 25.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV4suNtaXFEDFAUf&solveclubId=AXdbYpT6xskDFAUO&problemBoxTitle=0225&problemBoxCnt=1&probBoxId=AXfXLWUKsHEDFAUO
 * @mem 첫풀이 : 27340, 재시도 : 27656
 * @time 첫풀이 : 1056  재시도 : 301
 * @caution startIdx로 접근하고 모든 경우에 대해 선택 비선택이므로 for문이 필요없다!!!!
 * 			순서가 의미없으므로!!
 * 			추가적인 가지치기???
 */

public class Solution_1767_프로세서연결하기 {

	static int T, N, index;
	static int[][] arr;
	static List<int[]> core;
	static int selectedNum = Integer.MIN_VALUE;
	static int resultNum = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(input.readLine());
			arr = new int[N][N];
			selectedNum = Integer.MIN_VALUE;
			resultNum = Integer.MAX_VALUE;

			core = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tokenizer.nextToken());

					if (arr[i][j] == 1) {
						if (i!=0 && i!=N-1 && j!=0 && j!=N-1) {
							core.add(new int[] { i, j });	
						}
					}
				}
			}
			solve(0, 0, 0, 0);
			output.append("#" + tc + " " + resultNum + "\n");
		}
		System.out.println(output.toString());
	}

	static void solve(int cnt, int selectedCnt, int curLength, int startIdx) {
		
		if (cnt==core.size()) {
			if (selectedNum < selectedCnt) {
				selectedNum = selectedCnt;
				resultNum = curLength;
			} else if (selectedNum == selectedCnt) {
				if (resultNum > curLength) {
					resultNum = curLength;
				}
			} 
			return;
		}
		
//		if (selectedNum >= selectedCnt && resultNum < curLength) {
//			return;
//		}
		
		boolean topFlag = true, bottomFlag = true, leftFlag = true, rightFlag = true;

		for (int r = 0; r < core.get(startIdx)[0]; r++) { // 위쪽
			if (arr[r][core.get(startIdx)[1]] != 0) {
				topFlag = false;
				break;
			}
		}

		for (int r = core.get(startIdx)[0] + 1; r < N; r++) { // 아래쪽
			if (arr[r][core.get(startIdx)[1]] != 0) {
				bottomFlag = false;
				break;
			}
		}

		for (int c = 0; c < core.get(startIdx)[1]; c++) { // 왼쪽
			if (arr[core.get(startIdx)[0]][c] != 0) {
				leftFlag = false;
				break;
			}
		}

		for (int c = core.get(startIdx)[1] + 1; c < N; c++) { // 오른쪽
			if (arr[core.get(startIdx)[0]][c] != 0) {
				rightFlag = false;
				break;
			}
		}

		if (topFlag) {
			for (int r = 0; r < core.get(startIdx)[0]; r++) { // 선택된 길은 막힘
				arr[r][core.get(startIdx)[1]] = 2;
			}
			solve(cnt + 1, selectedCnt + 1, curLength + core.get(startIdx)[0], startIdx+1); // 갈 수 있으면 선택, 길이 증가
			for (int r = 0; r < core.get(startIdx)[0]; r++) { // 다시 돌아와서는 풀어줌
				arr[r][core.get(startIdx)[1]] = 0;
			}
		}

		if (bottomFlag) {
			for (int r = core.get(startIdx)[0] + 1; r < N; r++) { // 선택된 길은 막힘
				arr[r][core.get(startIdx)[1]] = 2;
			}
			solve(cnt + 1, selectedCnt + 1, curLength + (N - core.get(startIdx)[0] - 1), startIdx+1); // 갈 수 있으면 선택, 길이 증가
			for (int r = core.get(startIdx)[0] + 1; r < N; r++) { // 다시 돌아와서는 풀어줌
				arr[r][core.get(startIdx)[1]] = 0;
			}
		}

		if (leftFlag) {
			for (int c = 0; c < core.get(startIdx)[1]; c++) { // 선택된 길은 막힘
				arr[core.get(startIdx)[0]][c] = 2;
			}
			solve(cnt + 1, selectedCnt + 1, curLength + core.get(startIdx)[1], startIdx+1); // 갈 수 있으면 선택, 길이 증가
			for (int c = 0; c < core.get(startIdx)[1]; c++) { // 다시 돌아와서는 풀어줌
				arr[core.get(startIdx)[0]][c] = 0;
			}
		}

		if (rightFlag) {
			for (int c = core.get(startIdx)[1] + 1; c < N; c++) { // 선택된 길은 막힘
				arr[core.get(startIdx)[0]][c] = 2;
			}
			solve(cnt + 1, selectedCnt + 1, curLength + (N - core.get(startIdx)[1] - 1), startIdx+1); // 갈 수 있으면 선택, 길이 증가
			for (int c = core.get(startIdx)[1] + 1; c < N; c++) { // 다시 돌아와서는 풀어줌
				arr[core.get(startIdx)[0]][c] = 0;
			}
		}

		// 갈 수 있는 방향이 없을때 미선택이 아닌 그냥 미선택인 경우가 필요?? 
		// -> 초반에는 아직 길이 많아서 선택가능한 경우 많은데 나중에는 안좋을 수 있음
		solve(cnt + 1, selectedCnt, curLength, startIdx+1); // 미선택, 카운트 증가
	}

}
