package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 26.
 * @author user
 * @see https://www.acmicpc.net/problem/2527
 * @mem 11616
 * @time 80
 * @caution 분기처리 고생함
 * 			x좌표, y좌표에대혀 겹치는지 확인하는부분에서 
 * 			등호가 들어가야하는 부분들이 있음
 * 			각 직사각형에대해 위, 아래변 만나면 등호x
 * 			위, 위 or 아래, 아래 만나면 등호 가능
 */

public class Solution_2527_직사각형 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < 4; i++) {

			tokenizer = new StringTokenizer(input.readLine(), " ");

			int x1 = Integer.parseInt(tokenizer.nextToken());
			int y1 = Integer.parseInt(tokenizer.nextToken());
			int x2 = Integer.parseInt(tokenizer.nextToken());
			int y2 = Integer.parseInt(tokenizer.nextToken());

			int x3 = Integer.parseInt(tokenizer.nextToken());
			int y3 = Integer.parseInt(tokenizer.nextToken());
			int x4 = Integer.parseInt(tokenizer.nextToken());
			int y4 = Integer.parseInt(tokenizer.nextToken());

			boolean isDupX = false;
			boolean isDupY = false;
			
//			if (Math.max(x1, x3) < Math.min(x2, x4)) {
//				isDupX = true;
//			}
//			
//			if (Math.max(y1, y3) < Math.min(y2, y4)) {
//				isDupY = true;
//			}

			// x좌표 중첩 검사
			if (x3 >= x1 && x3 < x2) {
				isDupX = true;
			}
			if (x4 > x1 && x4 <= x2) {
				isDupX = true;
			}
			if (x1 >= x3 && x1 < x4) {
				isDupX = true;
			}
			if (x2 > x3 && x2 <= x4) {
				isDupX = true;
			}

			// y좌표 중첩 검사
			if (y3 >= y1 && y3 < y2) {
				isDupY = true;
			}
			if (y4 > y1 && y4 <= y2) {
				isDupY = true;
			}
			if (y1 >= y3 && y1 < y4) {
				isDupY = true;
			}
			if (y2 > y3 && y2 <= y4) {
				isDupY = true;
			}

			if (isDupX && isDupY) { // x, y 둘다 겹치면 직사각형
				output.append("a\n");
			} else if ((isDupX && (y2 == y3 || y1 == y4)) || (isDupY && (x1 == x4 || x2 == x3))) {
				// x가 겹치면서 y값이 직사각형 위아래로 같으면 선분
				output.append("b\n");
			} else if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3)) {
				// 좌표같으면 점
				output.append("c\n");
			} else {
				output.append("d\n");
			}

		}

		System.out.println(output.toString());
	}

}
