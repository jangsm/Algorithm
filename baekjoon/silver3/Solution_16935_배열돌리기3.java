package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 10.
 * @author user
 * @see https://www.acmicpc.net/problem/16935
 * @mem 47120
 * @time 424
 * @caution 회전시키면 N, M이 바뀐다!! -> N, M을 가지고 코드를 짜지말고 map.length, map[0].length를 이용해야 회전되서 배열의 모양이 변하더라도 정상적으로 작동하는 코드가 된다.
 */

public class Solution_16935_배열돌리기3 {

	static int N, M, R;
	static int[][] map;
	static int rotateCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		R = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int order = Integer.parseInt(tokenizer.nextToken());

			switch (order) {
			case 1:
				flipVertical();
				break;
			case 2:
				flipHorizontal();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				divideAndRight();
				break;
			case 6:
				divideAndLeft();
				break;
			default:
				break;
			}
		}

		for (int[] row : map) {
			for (int r : row) {
				output.append(r + " ");
			}
			output.append("\n");
		}

		System.out.println(output.toString());
	}

	static void flipVertical() { // 상하반전
		
		for(int c = 0 ; c < map[0].length ; ++c) {
			for(int r1 = 0, r2 = map.length - 1 ; r1 < r2 ; r1++, r2--) {
				int temp = map[r1][c];
				map[r1][c] = map[r2][c];
				map[r2][c] = temp;
			}
		}
		
		
//		for (int r = 0; r < map.length/2; r++) {
//			int[] temp = map[r].clone();
//			map[r] = map[map.length - 1 - r].clone();
//			map[map.length - 1 - r] = temp.clone();
//		}
	}

	static void flipHorizontal() { // 좌우반전
		
		for(int r = 0 ; r < map.length ; ++r) {
			for(int c1 = 0, c2 = map[0].length - 1 ; c1 < c2 ; c1++, c2--) {
				int temp = map[r][c1];
				map[r][c1] = map[r][c2];
				map[r][c2] = temp;
			}
		}
		
		
//		for (int r = 0; r < map.length/2; r++) {
//			for (int c = 0; c < map[0].length / 2; c++) {
//				int temp = map[r][c];
//				map[r][c] = map[r][map[0].length - 1 - c];
//				map[r][map[0].length - 1 - c] = temp;
//			}
//		}
	}

	static void rotateRight() {

//		rotateCnt++;
//		if (rotateCnt%2==0) {
//			int[][] columns = new int[N][M];
//			for (int r = 0; r < M; r++) {
//				for (int c = 0; c < N; c++) {
//					columns[c][M - 1 - r] = map[r][c];
//				}
//			}
//
//			map = new int[N][M];
//			for (int r = 0; r < N; r++) {
//				map[r] = columns[r].clone();
//			}
//		} else {
//			int[][] columns = new int[M][N];
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					columns[c][N - 1 - r] = map[r][c];
//				}
//			}
//
//			map = new int[M][N];
//			for (int r = 0; r < M; r++) {
//				map[r] = columns[r].clone();
//			}	
//		}

		int[][] result = new int[map[0].length][map.length];

		for (int r = 0; r < map.length; ++r) {
			for (int c = 0; c < map[0].length; ++c) {
				result[c][map.length - 1 - r] = map[r][c];
			}
		}

		map = result;
		
	}

	static void rotateLeft() {

//		rotateCnt++;
//		if (rotateCnt % 2 == 0) {
//			int[][] columns = new int[N][M];
//			for (int r = 0; r < M; r++) {
//				for (int c = 0; c < N; c++) {
//					columns[c][r] = map[r][c];
//				}
//			}
//
//			map = new int[N][M];
//			for (int r = 0; r < N; r++) {
//				map[r] = columns[N - 1 - r].clone();
//			}
//		} else {
//			int[][] columns = new int[M][N];
//			for (int r = 0; r < N; r++) {
//				for (int c = 0; c < M; c++) {
//					columns[c][r] = map[r][c];
//				}
//			}
//
//			map = new int[M][N];
//			for (int r = 0; r < M; r++) {
//				map[r] = columns[M - 1 - r].clone();
//			}
//		}

		int[][] result = new int[map[0].length][map.length];

		for (int r = 0; r < result.length; ++r) {
			for (int c = 0; c < result[0].length; ++c) {
				result[r][c] = map[c][result.length - 1 - r];
			}
		}

		map = result;

	}

	static void divideAndRight() {
		int halfR = map.length / 2;
		int halfC = map[0].length / 2;

		int[][] newMap = new int[map.length][map[0].length];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if (r < halfR && c < halfC) { // 1위치
					newMap[r][c + halfC] = map[r][c];
				} else if (r < halfR && c >= halfC) { // 2위치
					newMap[r + halfR][c] = map[r][c];
				} else if (r >= halfR && c >= halfC) { // 3위치
					newMap[r][c - halfC] = map[r][c];
				} else { // 4위치
					newMap[r - halfR][c] = map[r][c];
				}
			}
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				map[r][c] = newMap[r][c];
			}
		}
	}

	static void divideAndLeft() {
		int halfR = map.length / 2;
		int halfC = map[0].length / 2;

		int[][] newMap = new int[map.length][map[0].length];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if (r < halfR && c < halfC) { // 1위치
					newMap[r + halfR][c] = map[r][c];
				} else if (r < halfR && c >= halfC) { // 2위치
					newMap[r][c - halfC] = map[r][c];
				} else if (r >= halfR && c >= halfC) { // 3위치
					newMap[r - halfR][c] = map[r][c];
				} else { // 4위치
					newMap[r][c + halfC] = map[r][c];
				}
			}
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				map[r][c] = newMap[r][c];
			}
		}
	}

}
