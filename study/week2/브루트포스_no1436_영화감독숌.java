package ps.study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_no1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		int N = Integer.parseInt(input.readLine());
		
		int num = 666;
		int cnt = 1;
		
		while(cnt<N) {
			num++;
			if (Integer.toString(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
	}

}
