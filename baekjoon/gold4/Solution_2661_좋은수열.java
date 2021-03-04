package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 3.
 * @author user
 * @see https://www.acmicpc.net/problem/2661
 * @mem 21716
 * @time 120
 * @caution 완탐으로 해결 -> 검사하면서 계속 가지치기 되기 때문에 경우의 수 계산 가능
 */

public class Solution_2661_좋은수열 {

	static int N;
	static boolean isEnd;
	static String result = "";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		solve(0, new String());
		System.out.println(result);
	}
	
	static void solve(int cnt, String nums) {
		
		for(int len=1; len<=nums.length()/2; len++) {
			for(int i=0; i<nums.length()-len; i++) {
				String temp1 = nums.substring(i, i+len);
				String temp2 = "";
				if (i+len+len < cnt) {
					temp2 = nums.substring(i+len, i+len+len);
				} else {
					temp2 = nums.substring(i+len);
				}
				
				if (temp1.equals(temp2)) {
					return;
				}
			}
		}
		
		if (cnt==N) {
			result = nums;
			isEnd = true;
			return;
		}
		// 1선택
		if (nums.length()==0) {
			solve(cnt+1, nums+"1");	
		}
		else if (nums.charAt(nums.length()-1)!='1') {
			solve(cnt+1, nums+"1");	
		}
		
		if (isEnd) {
			return;
		}
		// 2선택
		if (nums.length()==0) {
			solve(cnt+1, nums+"2");	
		}
		else if (nums.charAt(nums.length()-1)!='2') {
			solve(cnt+1, nums+"2");	
		}
		
		if (isEnd) {
			return;
		}
		// 3선택
		if (nums.length()==0) {
			solve(cnt+1, nums+"3");	
		}
		else if (nums.charAt(nums.length()-1)!='3') {
			solve(cnt+1, nums+"3");	
		}
		if (isEnd) {
			return;
		}
	}

}
