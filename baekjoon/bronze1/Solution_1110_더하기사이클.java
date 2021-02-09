package ps.bj.b1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1110_더하기사이클 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		int newNum = N;
		int count = 0; 
		
		while(true) {
			count++;
			int a = newNum/10;
			int b = newNum%10;
			
			int temp = a+b;
			temp = temp%10;
			
			newNum = b*10 + temp;
			if (newNum == N) {
				break;
			}
		}
		
		System.out.println(count);
	}

}
