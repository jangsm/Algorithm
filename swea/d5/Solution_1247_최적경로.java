package ps.swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {

	static int T, N, result = Integer.MAX_VALUE;
	static int[][] map;
	static Pair current;
	static Pair home;
	static Pair[] customers;
//	static int[] perm;

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			
			tokenizer = new StringTokenizer(input.readLine(), " ");
			current = new Pair(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())); // 초기 현재위치는 회사																							
			home = new Pair(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())); 
			customers = new Pair[N];
//			perm = new int[N];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				customers[i] = new Pair(Integer.parseInt(tokenizer.nextToken()),
						Integer.parseInt(tokenizer.nextToken()));
//				perm[i] = i + 1;
			}

//			do {
//				int dist = 0;
////				System.out.println(Arrays.toString(perm));
//				for (int i = 0; i < perm.length; i++) {
//					int index = perm[i] - 1; // customers배열에 접근할 index
//					dist += Math.abs(customers[index].x - current.x) + Math.abs(customers[index].y - current.y);
//					current.x = customers[index].x;
//					current.y = customers[index].y;
//				}
//				dist += Math.abs(home.x - current.x) + Math.abs(home.y - current.y);
//				System.out.println("dist : " + dist);
//				result = Math.min(result, dist);
//			} while (nextPerm(perm));
			
			makePerm(0, new boolean[N], 0, current.x, current.y);

			output.append("#" + tc + " " + result + "\n");
		}
		System.out.println(output.toString());

	}
	
	static void makePerm(int cnt, boolean[] visited, int dist, int x, int y) {
		
		if (dist > result) {
			return;
		}
		
		if (cnt==N) {
			dist += Math.abs(home.x - x) + Math.abs(home.y - y); // 집위치까지 이동
			result = Math.min(result, dist);
			return;
		}
		
		for(int i = 0; i<N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			int temp = Math.abs(customers[i].x - x) + Math.abs(customers[i].y - y);
			makePerm(cnt+1, visited, dist + temp, customers[i].x, customers[i].y);
			visited[i] = false; 
		}
	}

//	static boolean nextPerm(int[] arr) {
//		int i = arr.length - 1;
//		int j = arr.length - 1;
//
//		while (i > 0 && arr[i - 1] >= arr[i])
//			i--;
//		if (i == 0) {
//			return false;
//		}
//
//		while (arr[i - 1] >= arr[j])
//			j--;
//
//		int temp = arr[i - 1];
//		arr[i - 1] = arr[j];
//		arr[j] = temp;
//
//		int k = arr.length - 1;
//		while (i < k) {
//			temp = arr[i];
//			arr[i] = arr[k];
//			arr[k] = temp;
//			i++;
//			k--;
//		}
//		return true;
//	}
}
