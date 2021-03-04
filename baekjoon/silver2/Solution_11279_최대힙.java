package ps.bj.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 3.
 * @author user
 * @see https://www.acmicpc.net/problem/11279
 * @mem 28460
 * @time 356
 * @caution pq 기본은 min-heap, Collections.reverseOrder 하면 max-heap
 */

public class Solution_11279_최대힙 {

	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(input.readLine());
			if (x>0) {
				pq.add(x);
			} else if (x==0) {
				if (pq.size()!=0) {
					output.append(pq.poll()+"\n");
				} else {
					output.append("0\n");
				}
			}
		}
		
		System.out.println(output.toString());
	}

}
