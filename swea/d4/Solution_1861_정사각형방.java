package ps.swea.d4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_정사각형방 {

	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static Point[] points;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(input.readLine());
			int[][] map = new int[N][N];
			points = new Point[N*N+1];
			int startX = 0;
			int startY = 0;

			for (int i = 0; i < N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tokenizer.nextToken());
					points[map[i][j]] = new Point(i,j);
					if (map[i][j] == 1) {
						startX = i;
						startY = j;
					}
				}
			}

			int curNum = 1;
			int result = 0;
			int temp = 1;
			int resultNum = 0;
			
			while (true) {

				if (curNum == N*N+1) {
					break;
				}

				boolean isNext = false;
				
				for (int i = 0; i < 4; i++) {
					int newX = startX + dir[i][0];
					int newY = startY + dir[i][1];

					if (newX < 0 || newX >= N || newY < 0 || newY >= N) { // 불가능한 좌표
						continue;
					}

					if (map[newX][newY] == map[startX][startY] + 1) {
						isNext = true;
						curNum++;
						temp++;
						startX = newX;
						startY = newY;
						break;
					}
				}
				
				if (!isNext) { // 다음이 없으면 그 다음 수를 map에서 찾는다.
					curNum++; // 다음 수 탐색
					if (temp>result) { // 지금까지 이동거리와 result를 비교해서 더 큰 경우에 값 교체
						result = temp;
						resultNum = curNum - result;
					}
					temp = 1; // 초기화
					if (curNum<=N*N) {
						startX = points[curNum].x;
						startY = points[curNum].y;	
					}
//					outer:for(int i = 0; i<N; i++) {
//						for(int j =0; j<N; j++) {
//							if (map[i][j]== curNum ) {
//								startX = i;
//								startY = j;
//								break outer;
//							}
//						}
//					}
				}
			}
			
			output.append("#").append(tc).append(" ").append(resultNum).append(" ").append(result).append("\n");
		}
		System.out.println(output.toString());
	}

}
