package baekjoon.step7_string;

import java.util.Scanner;

public class num2_숫자의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		String str = scanner.next();
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			sum += str.charAt(i)-'0';
		}
		
		System.out.println(sum);
	}

}
