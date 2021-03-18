package ps.jo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1863_종교 {

	static int n, m, count;
	static int[] represent;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		represent = new int[n+1];
		
		makeSet(n);
		count = n;
		
		for(int i=0; i<m; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			
			union(a, b);
		}
		
		System.out.println(count);
	}
	
	static void makeSet(int n) {
		for(int i=1; i<=n; i++) {
			represent[i] = i; 
		}
	}
	
	static int findSet(int a) {
		if(represent[a]==a) {
			return a;
		}
		
		return represent[a] = findSet(represent[a]); 
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) { // 같은 집합
			return false;
		} else {
			represent[bRoot] =aRoot;
			count--;
			return true;
		}
	}

}
