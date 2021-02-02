package baekjoon.group.practice;

import java.util.Scanner;

public class no13300_방배정 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int gender = 0;
		int grade = 0;
		
		int[][] student = new int[7][2]; // [학년][성별], 학년 1부터, 성별 0: 여자 1: 남자
		for (int i = 0; i < N; i++) {
			gender = scanner.nextInt();
			grade = scanner.nextInt();
			
			student[grade][gender]++; 
		}
		
		int answer = 0;
		
		for(int i=1; i<student.length; i++) {
			for(int j=0; j<2; j++) {
				if(student[i][j]>0) {
					int charge = student[i][j]/K;
					int remaining = student[i][j]%K;
					if (remaining==0) {
						answer+=charge;
					} else {
						answer+=charge+1;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
