package baekjoon.step7_string;

import java.util.Scanner;

public class num7_상수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		
		String str_num1 = Integer.toString(num1);
		String str_num2 = Integer.toString(num2);
		
		String new_str_num1 = "";
		String new_str_num2 = "";
		
		for(int i=2; i>=0; i--) {
			new_str_num1 += str_num1.charAt(i);
			new_str_num2 += str_num2.charAt(i);
		}
		
		int new_num1 = Integer.parseInt(new_str_num1);
		int new_num2 = Integer.parseInt(new_str_num2);
		
		System.out.println(new_num1>new_num2 ? new_num1 : new_num2);
	}

}
