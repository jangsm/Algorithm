package baekjoon.step7_string;

import java.util.Scanner;

public class num3_알파벳찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		scanner.close();
		
		int[] alphabet = new int[26];

		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = -1;
			for (int j = 0; j < str.length(); j++) {
				if ((char) (i + 'a') == str.charAt(j)) {
					alphabet[i] = j;
					break;
				}
			}
		}
		
		for(int i=0; i<alphabet.length; i++) {
			System.out.print(alphabet[i] + " " );
		}
		System.out.println();
	}

}
