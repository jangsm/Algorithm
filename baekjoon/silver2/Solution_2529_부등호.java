package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/2529
 * @mem 20576
 * @time 300
 * @caution 더 빠른 방법으로 그리디?? 하게 풀 수 있다. 
 * 			<가 나오는 만큼 더 작은 수부터 시작, >가 나오는만큼 더 큰 수부터 시작
 * 			이해가 잘 안감 나중에 한번 더 확인
 * 			https://medium.com/hyeon-hwang/%EB%B0%B1%EC%A4%80-2529-%EB%B6%80%EB%93%B1%ED%98%B8-%EA%B7%B8%EB%A6%AC%EB%94%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-80d7ffe2d048
 */

public class Solution_2529_부등호 {

	static int K;
	static String max = "", min = "";
	static char[] arr;
	static boolean isEnd;
	static int[] minNums = {0,1,2,3,4,5,6,7,8,9};
	static int[] maxNums = {9,8,7,6,5,4,3,2,1,0};
	static StringBuilder output;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		output = new StringBuilder();
		
		K = Integer.parseInt(input.readLine());
		arr = new char[K];
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for(int i=0; i<K; i++) {
			arr[i] = tokenizer.nextToken().charAt(0); 
		}
		
		makePerm(0, new int[K+1], new boolean[10], true);
		isEnd = false;
		makePerm(0, new int[K+1], new boolean[10], false);
		
		output.append(max + "\n" + min);
		System.out.println(output.toString());
	}
	
	static void makePerm(int cnt, int[] choosed, boolean[] visited, boolean flag) { // flag false : min, true: max
		if (cnt==K+1) {
			boolean isCorrect = true;
			int index = 0;
			while (index<K) {
				if (arr[index]=='<') {
					if (choosed[index] < choosed[index+1]) {
						index++;
						continue;
					} else {
						isCorrect = false;
						break;
					}
				} else if (arr[index]=='>') {
					if (choosed[index]> choosed[index+1] ) {
						index++;
						continue;
					} else {
						isCorrect = false;
						break;
					}
				}
			}
			
			if (isCorrect) {
				if (flag) {
					for(int i=0; i<choosed.length; i++) {
						max += choosed[i];
					}
				} else {
					for(int i=0; i<choosed.length; i++) {
						min += choosed[i];
					}
				}
				isEnd = true;
			}
			return;
		}
		
		for(int i=0; i<10; i++) {
			if (flag) {
				if (visited[i]) {
					continue;
				}
				choosed[cnt] = maxNums[i];
				visited[i] = true;
				makePerm(cnt+1, choosed, visited, flag);
				if (isEnd) {
					return;
				}
				visited[i] = false; 
			} else {
				if (visited[i]) {
					continue;
				}
				choosed[cnt] = minNums[i];
				visited[i] = true;
				makePerm(cnt+1, choosed, visited, flag);
				if (isEnd) {
					return;
				}
				visited[i] = false; 
			}
		}
	}

}
