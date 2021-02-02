package baekjoon.study.week1;

import java.util.Arrays;
import java.util.Scanner;

public class 문자열_no2697_다음수구하기 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String strNum = scanner.next();
			
			int index = -1;
			for(int i=strNum.length()-1; i>=1; i--) {
				if(strNum.charAt(i-1)<strNum.charAt(i)) {
					index = i-1;
					break;
				}
			}
			
			if (index==-1) {
				System.out.println("BIGGEST");
			} else {
				for(int i=strNum.length()-1; i>index; i--) {
					if (strNum.charAt(i)>strNum.charAt(index)) {
						StringBuilder stringBuilder = new StringBuilder(strNum);
						char temp = strNum.charAt(i);
						stringBuilder.setCharAt(i, strNum.charAt(index));
						stringBuilder.setCharAt(index, temp);
						String str1 = stringBuilder.substring(0,index+1);
						String str2 = stringBuilder.substring(index+1);
						char[] arr = str2.toCharArray();
						Arrays.sort(arr);
						str1 += new StringBuilder(new String(arr)).toString();
						System.out.println(str1);
						break;
					}
				}
			}
		}
	}

}

// 이 외에 next_Permutation을 이용하면 그 다음 수가 나온다.
