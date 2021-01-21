package baekjoon.group.workbook.basicDS;

import java.util.Scanner;

public class no11328_Strfry {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();

		for (int tc = 0; tc < T; tc++) {
			String str1 = scanner.next();
			String str2 = scanner.next();

			int[] alphabet = new int[26];

			for (int i = 0; i < str1.length(); i++) {
				alphabet[str1.charAt(i) - 'a']++;
			}

			for (int i = 0; i < str2.length(); i++) {
				alphabet[str2.charAt(i) - 'a']--;
			}

			boolean flag = true;

			for (int i = 0; i < alphabet.length; i++) {
				if (alphabet[i] != 0) {
					flag = false;
					break;
				}
			}

			System.out.println(flag ? "Possible" : "Impossible");
		}
	}

}
