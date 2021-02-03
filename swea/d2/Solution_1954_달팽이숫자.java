package ps.swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @since 2021. 2. 2.
 * @author user
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq&categoryId=AV5PobmqAPoDFAUq&categoryType=CODE&problemTitle=1954&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * @mem
 * @time
 * @caution
 */

public class Solution_1954_달팽이숫자 {

	static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int T = Integer.parseInt(input.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(input.readLine());

			int[][] matrix = new int[N][N];

			int index = 1;
			int x = 0, y = 0;
			matrix[x][y] = index;
			index++;
			int curDir = 0;
			while (index != N * N + 1) {
				
				if (curDir == 0) {
					int newX = x + dir[curDir][0];
					int newY = y + dir[curDir][1];
					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
						curDir = 1;
					}
					else if (matrix[newX][newY] != 0) {
						curDir = 1;
					} 
					else {
						x = newX;
						y = newY;
						matrix[x][y] = index;
						index++;	
					}
				}
				else if (curDir == 1) {
					int newX = x + dir[curDir][0];
					int newY = y + dir[curDir][1];
					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
						curDir = 2;
					}
					else if (matrix[newX][newY] != 0) {
						curDir = 2;
					} 
					else {
						x = newX;
						y = newY;
						matrix[x][y] = index;
						index++;	
					}
				}
				else if (curDir == 2) {
					int newX = x + dir[curDir][0];
					int newY = y + dir[curDir][1];
					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
						curDir = 3;
					}
					else if (matrix[newX][newY] != 0) {
						curDir = 3;
					} 
					else {
						x = newX;
						y = newY;
						matrix[x][y] = index;
						index++;	
					}
				}
				else if (curDir == 3) {
					int newX = x + dir[curDir][0];
					int newY = y + dir[curDir][1];
					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
						curDir = 0;
					}
					else if (matrix[newX][newY] != 0) {
						curDir = 0;
					} 
					else {
						x = newX;
						y = newY;
						matrix[x][y] = index;
						index++;	
					}
				}

//				for (int i = 0; i < dir.length; i++) {
//					int newX = x + dir[i][0];
//					int newY = y + dir[i][1];
//					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
//						continue;
//					}
//					if (matrix[newX][newY] != 0) {
//						continue;
//					}
//					x = newX;
//					y = newY;
//					matrix[x][y] = index;
//					index++;
//					break;
//				}
			}
			
			output.append("#").append(tc).append("\n");
			for (int[] subArr : matrix) {
				for(int i=0; i<subArr.length; i++) {
					output.append(subArr[i]).append(" ");
				}
				output.append("\n");
			}
		}
		System.out.println(output.toString());
	}

}
