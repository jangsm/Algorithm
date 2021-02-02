package baekjoon.group.practice;

import java.util.Scanner;

public class no10807_개수세기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[] array = new int[num];
		for(int i=0; i<num; i++) {
			array[i]= scanner.nextInt(); 
		}
		
		int find = scanner.nextInt();
		
		int answer = 0;
		for(int i:array) {
			if (i==find) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
