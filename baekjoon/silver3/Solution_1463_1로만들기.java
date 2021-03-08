package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1463_1로만들기 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		arr = new int[N+1];
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1);
		arr[1] = 0;
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			if (x==N) {
				break;
			}
			
			if (x*3<=N && arr[x*3]==0 ) {
				arr[x*3] = arr[x]+1;
				queue.offer(x*3);
			}
			
			if (x*2<=N && arr[x*2]==0) {
				arr[x*2] = arr[x]+1;
				queue.offer(x*2);
			}
			
			if (x+1<=N && arr[x+1]==0) {
				arr[x+1] =arr[x]+1;
				queue.offer(x+1);
			}
		}
		
		System.out.println(arr[N]);
	}

}
