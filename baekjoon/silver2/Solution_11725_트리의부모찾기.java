package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 16.
 * @author user
 * @see https://www.acmicpc.net/problem/11725
 * @mem 97196
 * @time 608
 * @caution N의 범위로 인해 인접행렬로 구현시 메모리초과
 * 			인접리스트로 구현해야한다.
 * 			ArrayList<ArrayList<Integer>>
 * 			ArrayList<Integer>[] 
 * 			이런식으로 사용 가능하다.
 */

public class Solution_11725_트리의부모찾기 {

	static int N;
	static int[] nodes;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<Integer>());
		}
		nodes = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int first = Integer.parseInt(tokenizer.nextToken());
			int second = Integer.parseInt(tokenizer.nextToken());

			list.get(first).add(second);
			list.get(second).add(first);
		}
		
		dfs(1, 0);

		for (int i = 2; i <= N; i++) {
			output.append(nodes[i] + "\n");
		}
		System.out.println(output.toString());
	}

	static void dfs(int start, int parent) {

		for (int i = 0; i < list.get(start).size(); i++) {
			if (list.get(start).get(i) != parent) {
				dfs(list.get(start).get(i), start);
				nodes[list.get(start).get(i)] = start; 
			}
		}
	}

}
