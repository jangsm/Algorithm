package baekjoon.group.practice;

import java.util.Scanner;

public class no1919_애너그램만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();

		int[] alphabet = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			alphabet[str1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < str2.length(); i++) {
			alphabet[str2.charAt(i) - 'a']--;
		}

		int answer = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] > 0) {
				answer += alphabet[i];
			} else {
				answer -= alphabet[i];
			}
		}

		System.out.println(answer);
	}

}
