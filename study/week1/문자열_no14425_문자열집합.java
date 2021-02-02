package baekjoon.study.week1;

import java.util.Scanner;

public class 문자열_no14425_문자열집합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		String[] strings = new String[N];
		
		for(int i=0; i<N; i++) {
			strings[i] = scanner.next(); 
		}
		
		int answer = 0;
		
		for(int i=0; i<M; i++) {
			String findStr = scanner.next();
			for(int j=0; j<N; j++) {
				if (findStr.equals(strings[j])) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
