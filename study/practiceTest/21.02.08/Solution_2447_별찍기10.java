package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2447_별찍기10 {

	static StringBuilder output = new StringBuilder();
	static char[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		int N = Integer.parseInt(input.readLine());
		arr = new char[N][N];
		recursive(N, 0, 0, false);
		for(char[] subArr : arr) {
			for(char c : subArr) {
				output.append(c);
			}
			output.append("\n");
		}
		System.out.println(output.toString());
		
	}
	
	static void recursive(int n, int startX, int startY, boolean space) {
		if (space) {
			for (int i = startX; i < startX+n; i++) {
				for(int j=startY; j<startY+n; j++) {
					arr[i][j] = ' '; 
				}
			}
			return;
		}
		if (n==1) {
			arr[startX][startY] = '*';
//			for (int i = startX; i < startX+3; i++) {
//				for(int j=startY; j<startY+3; j++) {
//					if (i==startX+1 && j==startY+1) {
//						arr[i][j] = ' '; 
//					} else {
//						arr[i][j]= '*'; 
//					}
//				}
//			}
			return;
		}
		
		int size = n/3;
		
		for(int i =startX; i<startX + n; i+=size) {
			for(int j=startY; j<startY+n; j+=size) {
				if (i==startX + size && j==startY + size) {
					// 빈칸
					recursive(n/3, i, j, true);	
				} else {
					recursive(n/3, i, j, false);	
				}
			}
		}
	}

}
