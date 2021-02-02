package baekjoon.step7_string;

import java.util.Scanner;

public class num4_문자열반복 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = 0;
		Scanner scanner = new Scanner(System.in);
		testCase = scanner.nextInt();
		
		for(int i = 0; i<testCase; i++) {
			int repeat = scanner.nextInt();
			String str = scanner.next();
			
			String result = "";
			
			for(int j=0; j<str.length(); j++) {
				for(int k=0; k<repeat; k++) {
					result+=str.charAt(j);
				}
			}
			
			System.out.println(result);
		}
	}

}
