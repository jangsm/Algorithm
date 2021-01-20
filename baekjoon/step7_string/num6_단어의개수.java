package baekjoon.step7_string;

import java.util.Scanner;

public class num6_단어의개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		int count = 1;
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		
		if (str.charAt(0)==' ') {
			count--;
		}
		
		if (str.charAt(str.length()-1)==' ') {
			count--;
		}
		
		System.out.println(count);
	}

}
