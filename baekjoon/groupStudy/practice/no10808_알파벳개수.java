package baekjoon.group.practice;

import java.util.Scanner;

public class no10808_알파벳개수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		int[] alphabet = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			alphabet[str.charAt(i)-'a']++;
		}
		
		for(int a : alphabet) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
