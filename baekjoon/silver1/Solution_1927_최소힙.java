package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1927_최소힙 {

	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i =0; i<N; i++) {
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
