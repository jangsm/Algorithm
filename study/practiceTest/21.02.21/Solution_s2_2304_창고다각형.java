package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 21.
 * @author user
 * @see https://www.acmicpc.net/problem/2304
 * @mem 11968
 * @time 88
 * @caution 높이가 같은 경우 계산을 위해서 <=로 처리해주어야함
 */

public class Solution_s2_2304_창고다각형 {

	static int N;
	static int[] arr = new int[1001];
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		int maxIndex = 0;
		int maxHeight = 0;
		for(int i = 0; i<N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int index = Integer.parseInt(tokenizer.nextToken());
			int height = Integer.parseInt(tokenizer.nextToken());
			
			if (maxHeight < height) {
				maxHeight = height;
				maxIndex = index;
			}
			
			arr[index] = height; 
		}
		
		int curIndex = 0;
		for(int i=0; i<=maxIndex; i++) {
			if (arr[i]!=0 && arr[curIndex] <= arr[i]) {
				if (curIndex!=0) {
					result += (i-curIndex)*arr[curIndex];	
				}
				curIndex = i;
			}
		}
		
		curIndex= 0;
		for(int i = arr.length-1; i>= maxIndex; i--) {
			if (arr[i]!=0 && arr[curIndex] <= arr[i]) {
				if (curIndex!=0) {
					result += (curIndex-i)*arr[curIndex];	
				}
				curIndex = i;
			}
		}
		
		System.out.println(result + maxHeight);
	}

}
