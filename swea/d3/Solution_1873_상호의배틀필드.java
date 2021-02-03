package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {

	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int T = Integer.parseInt(input.readLine());
		for(int tc=1; tc<=T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int H = Integer.parseInt(tokenizer.nextToken());
			int W = Integer.parseInt(tokenizer.nextToken());
			
			int curX = 0, curY = 0;
			int curDir = 0; // 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
			map = new char[H][W];
			for(int i=0; i<H; i++) {
				char[] arr = input.readLine().toCharArray();
//				map[i]=  input.readLine().toCharArray(); // 이렇게 작성하는것이 더 간단하다.
				for(int j=0; j<W; j++) {
					map[i][j] = arr[j]; 
					
					if (map[i][j]=='^') {
						curX = i;
						curY = j;
						curDir = 0;
					} else if (map[i][j]=='>') {
						curX = i;
						curY = j;
						curDir = 1;
					} else if (map[i][j]=='v') {
						curX = i;
						curY = j;
						curDir = 2;
					} else if (map[i][j]=='<') {
						curX = i;
						curY = j;
						curDir = 3;
					}
				}
			}
			
			//출력확인
//			for(char[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			int N = Integer.parseInt(input.readLine());
			char[] action = input.readLine().toCharArray();
			for(int i = 0; i<action.length; i++) {
				int newX = 0, newY = 0;
				switch (action[i]) {
				case 'U': // 0
					curDir = 0;
					newX = curX + dir[curDir][0];
					newY = curY + dir[curDir][1];
					if (newX<0||newX>=H||newY<0||newY>=W) { // map밖으로 나가면 끝
						map[curX][curY] = '^'; // 기존땅을 위쪽을 바라보는 전차
						break;
					}
					if (map[newX][newY]=='.') { // 가려고하는곳이 평지이면
						map[curX][curY] = '.'; // 기존땅을 평지로 바꾸고
						map[newX][newY] = '^'; // 이동하려는땅에 위쪽을 바라보는 전차
						curX = newX; // 위치 변경
						curY = newY;
					} else { // 평지가 아니면
						map[curX][curY] = '^'; // 기존땅을 위쪽을 바라보는 전차
					}
					break;
				case 'R': // 1
					curDir = 1;
					newX = curX + dir[curDir][0];
					newY = curY + dir[curDir][1];
					if (newX<0||newX>=H||newY<0||newY>=W) { // map밖으로 나가면 끝
						map[curX][curY] = '>'; // 기존땅을 오른쪽을 바라보는 전차
						break;
					}
					if (map[newX][newY]=='.') { // 가려고하는곳이 평지이면
						map[curX][curY] = '.'; // 기존땅을 평지로 바꾸고
						map[newX][newY] = '>'; // 이동하려는땅에 오른쪽을 바라보는 전차
						curX = newX; // 위치 변경
						curY = newY;
					} else { // 평지가 아니면
						map[curX][curY] = '>'; // 기존땅을 오른쪽을 바라보는 전차
					}
					break;
				case 'D': // 2
					curDir = 2;
					newX = curX + dir[curDir][0];
					newY = curY + dir[curDir][1];
					if (newX<0||newX>=H||newY<0||newY>=W) { // map밖으로 나가면 끝
						map[curX][curY] = 'v'; // 기존땅을 아래쪽을 바라보는 전차
						break;
					}
					if (map[newX][newY]=='.') { // 가려고하는곳이 평지이면
						map[curX][curY] = '.'; // 기존땅을 평지로 바꾸고
						map[newX][newY] = 'v'; // 이동하려는땅에 아래쪽을 바라보는 전차
						curX = newX; // 위치 변경
						curY = newY;
					} else { // 평지가 아니면
						map[curX][curY] = 'v'; // 기존땅을 아래쪽을 바라보는 전차
					}
					break;
				case 'L': // 3
					curDir = 3;
					newX = curX + dir[curDir][0];
					newY = curY + dir[curDir][1];
					if (newX<0||newX>=H||newY<0||newY>=W) { // map밖으로 나가면 끝
						map[curX][curY] = '<'; // 기존땅을 왼쪽을 바라보는 전차
						break;
					}
					if (map[newX][newY]=='.') { // 가려고하는곳이 평지이면
						map[curX][curY] = '.'; // 기존땅을 평지로 바꾸고
						map[newX][newY] = '<'; // 이동하려는땅에 왼쪽을 바라보는 전차
						curX = newX; // 위치 변경
						curY = newY;
					} else { // 평지가 아니면
						map[curX][curY] = '<'; // 기존땅을 왼쪽을 바라보는 전차
					}
					break;
				case 'S':
					int missileX =curX;
					int missileY = curY;
					while(true) {
						newX = missileX + dir[curDir][0];
						newY = missileY + dir[curDir][1];
						
						if (newX<0||newX>=H||newY<0||newY>=W) { // map밖으로 나가면 끝
							break;
						}
						if (map[newX][newY]=='*') { // 벽돌로 만들어진 벽이면 평지로 바뀌고 끝
							map[newX][newY] = '.';
							break;
						}
						if (map[newX][newY]=='#') { // 강철로 만들어진 벽이면 그냥 끝
							break;
						}
						
						// 모든 경우에 걸리지 않으면 이동
						missileX = newX;
						missileY = newY;
					}
					break;
				default:
					break;
				}
			}
			
			output.append("#").append(tc).append(" ");
			for(char[] subArr : map) {
				for(char sub : subArr) {
					output.append(sub);
				}
				output.append("\n");
			}
		}
		System.out.println(output.toString());
	}

}
