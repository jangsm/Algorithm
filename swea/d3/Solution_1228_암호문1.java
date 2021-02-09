package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(input.readLine());
			tokenizer = new StringTokenizer(input.readLine(), " ");
			LinkedList<Integer> list = new LinkedList<>();
			for(int i=0; i<N; i++) {
				list.addLast(Integer.parseInt(tokenizer.nextToken()));
			}
			
			int M = Integer.parseInt(input.readLine());
			tokenizer = new StringTokenizer(input.readLine(), " ");
			while(tokenizer.hasMoreTokens()) {
				if (tokenizer.nextToken().charAt(0)=='I') {
					int x = Integer.parseInt(tokenizer.nextToken());
					int y = Integer.parseInt(tokenizer.nextToken());
					for(int i=0; i<y; i++) {
						list.add(x+i, Integer.parseInt(tokenizer.nextToken()));
					}
				}
			}
			
			output.append("#" + tc + " ");
			for(int i=0; i<10; i++) {
				output.append(list.get(i)+" ");
			}
			output.append("\n");
		}
		System.out.println(output.toString());
	}

}
