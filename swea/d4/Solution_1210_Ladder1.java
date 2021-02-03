package ps.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import jdk.internal.dynalink.beans.StaticClass;

/**
 * @since 2021. 2. 2.
 * @author user
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV14ABYKADACFAYh&probBoxId=AXdgvuDKbeYDFAUO&type=PROBLEM&problemBoxTitle=0202&problemBoxCnt=2
 * @mem
 * @time
 * @caution
 */

public class Solution_1210_Ladder1 {
	
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 } }; // 왼쪽 오른쪽 위쪽
	static int[][] matrix = new int[100][100];
	static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int endX = 0;
		int endY = 0;

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(input.readLine());
			for (int i = 0; i < 100; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					matrix[j][i] = Integer.parseInt(tokenizer.nextToken());

					if (matrix[j][i] == 2) {
						endX = j;
						endY = i;
					}
				}
			}
			search(endX, endY);
			output.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(output.toString());
	}
	
	static void search(int startX, int startY) {
		
		int x = startX;
		int y = startY;
		
		if (y==0) {
			result = x;
			return;
		}
		
		for(int i=0; i<3; i++) {
			int newX = x+dir[i][0];
			int newY = y + dir[i][1];
			
			if (newX<0 || newX>=100 || newY<0 || newY>=100) {
				continue;
			}
			if (matrix[newX][newY]==0) {
				continue;
			}
			x = newX;
			y = newY;
			matrix[x][y]=0;
			search(x, y);
			break;
		}
		
//		if (startY==0) {
//		result = startX;
//		System.out.println("결과 : " + result);
//		return;
//	}
		
//		int leftX = startX + dir[0][0];
//		int leftY = startY + dir[0][1];
//		
//		int rightX = startX + dir[1][0];
//		int rightY = startY + dir[1][1];
//		
//		int upX = startX + dir[2][0];
//		int upY = startY + dir[2][1];
//		
//		if (matrix[leftX][leftY]==1 && leftX>=0 && leftX<100 && leftY>=0 && leftY<100) {
//			while(leftX>=0 && matrix[leftX][leftY]==1) {
//				matrix[leftX][leftY]=0;
//				leftX -= 1;
//			}
//			leftX += 1;
//			search(leftX, leftY);
//		} else if (matrix[rightX][rightY]==1 && rightX>=0 && rightX<100 && rightY>=0 && rightY<100) {
//			while(rightX<100 && matrix[rightX][rightY]==1) {
//				matrix[rightX][rightY]=0;
//				rightX += 1;
//			}
//			rightX -= 1;
//			search(rightX, rightY);
//		} else if (matrix[upX][upY]==1 && upX>=0 && upX<100 && upY>=0 && upY<100) {
//			while(upY>=0 && matrix[upX][upY]==1) {
//				matrix[upX][upY]=0;
//				upY -= 1;
//			}
//			upY += 1;
//			search(upX, upY);
//		}
	}

}
