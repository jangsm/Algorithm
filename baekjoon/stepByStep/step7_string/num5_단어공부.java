package baekjoon.step7_string;

import java.util.Scanner;

public class num5_단어공부 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		
		int[] alphabet = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			if (str.charAt(i)<'a') {
				alphabet[str.charAt(i)-'A']++;
			}
			else if (str.charAt(i)>='a') {
				alphabet[str.charAt(i)-'a']++;
			}
		}
		
		int max = 0;
		char max_alphabet=' ';
		boolean isDuplicate = false;
		
		for(int i=0;i<alphabet.length; i++) {
			if(alphabet[i]>max) {
				max = alphabet[i];
				max_alphabet = (char)(i+'A');
				isDuplicate = false;
			}
			else if(alphabet[i]==max) {
				max = alphabet[i];
				max_alphabet = '?';
				isDuplicate = true;
			}
		}
		
		System.out.println(max_alphabet);
	}

}
