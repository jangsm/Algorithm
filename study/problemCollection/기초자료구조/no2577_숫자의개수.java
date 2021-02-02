package baekjoon.group.workbook.basicDS;

import java.util.Scanner;

public class no2577_숫자의개수 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		int num = A*B*C;
		
		String strNum = Integer.toString(num);
		
		int[] nums = new int[10];
		
		for(int i=0; i<strNum.length(); i++) {
			nums[strNum.charAt(i)-'0']++;
		}
		
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
