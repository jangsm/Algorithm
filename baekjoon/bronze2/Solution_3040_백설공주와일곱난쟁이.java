package ps.bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3040_백설공주와일곱난쟁이 {
	
	static int[] nums;
	static int N = 9;
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		
		nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(String.valueOf(input.readLine())); 
		}
		
		makeComb(0, new int[7], 0);
		System.out.println(output.toString());
	}
	
	static void makeComb(int cnt, int[] choosed, int startIdx) {
		if (cnt==7) {
			int sum = 0;
			for(int i : choosed) {
				sum += i;
			}
			if (sum==100) {
				for(int i : choosed) {
					output.append(i + "\n");
				}
			}
			return;
		}
		
		for(int i=startIdx; i<N; i++) {
			choosed[cnt] = nums[i];
			makeComb(cnt+1, choosed, i+1);
		}
	}

}
