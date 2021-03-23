package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 23.
 * @author user
 * @see https://www.acmicpc.net/problem/1717
 * @mem 48916
 * @time 372
 * @caution 유니온 파인드
 */

public class Solution_1717_집합의표현 {
	
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		parents = new int[N+1];
		M = Integer.parseInt(tokenizer.nextToken());
		
		makeSet();
		for(int i=0; i<M; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int command = Integer.parseInt(tokenizer.nextToken());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			
			if(command==0) {
				union(a, b);
			} else if(command==1) {
				int aRoot = findSet(a);
				int bRoot = findSet(b);
				
				if (aRoot == bRoot) {
					output.append("YES\n");
				} else {
					output.append("NO\n");
				}
			}
		}
		
		System.out.println(output.toString());
	}
	
	static void makeSet() {
		for(int i=0; i<parents.length; i++) {
			parents[i] = i; 
		}
	}
	
	static int findSet(int a) {
		if(a==parents[a]) {
			return a;
		}
		
		return parents[a] = findSet(parents[a]); 
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		parents[bRoot] =aRoot;
		return true;
	}

}
