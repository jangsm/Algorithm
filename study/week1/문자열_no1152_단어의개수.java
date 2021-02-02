package baekjoon.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열_no1152_단어의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		br.close();

		int answer = 1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				answer++;
			}
		}
		
		
		if (str.charAt(0)==' ') {
			answer--;
		}
		
		if (str.charAt(str.length()-1)==' ') {
			answer--;
		}
		
		System.out.println(answer);
	}

}
