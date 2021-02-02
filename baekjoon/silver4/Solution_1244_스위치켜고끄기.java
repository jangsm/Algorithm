package com.ssafy.homework.algo.bg.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 1.
 * @author user
 * @see https://www.acmicpc.net/problem/1244
 * @mem 14400
 * @time 132
 * @caution
 */

public class Solution_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringBuilder output2 = new StringBuilder(); 
		StringTokenizer tokenizer;

		int switchNum = Integer.parseInt(input.readLine());
		boolean[] status = new boolean[switchNum+1];
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 1; i <= switchNum; i++) {
			status[i] = tokenizer.nextToken().charAt(0) == '1' ? true : false;
		}

		int studentNum = Integer.parseInt(input.readLine());
		for (int i = 0; i < studentNum; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int gender = Integer.parseInt(tokenizer.nextToken());
			int num = Integer.parseInt(tokenizer.nextToken());

			if (gender == 1) {
				int multiNum = switchNum / num;
				for (int j = 1; j <= multiNum; j++) {
					status[j*num] = !status[j*num];
				}
			} else if (gender == 2) {
				status[num] = !status[num];
				int index = 1;
				while((num-index)>=1 && (num+index)<=switchNum && status[num-index] == status[num+index]) {
					status[num-index] = !status[num-index];
					status[num+index] = !status[num+index];
					index++;
				}
			}
		}
		
		for(int i=1; i<status.length; i++) {
			if (status[i]) {
//				System.out.print("1 ");
				output.append("1 ");
			} else {
				output.append("0 ");
//				System.out.print("0 ");
			}
			
			if (i%20==0) {
				output.append("\n");
			}
			
//			if (output.length()==40) {
//				output.append("\n");
//				output2.append(output);
//				output.setLength(0);
//			}
		}
		
//		System.out.println(output.length());
//		output.setLength(output.length()-1);
		System.out.println(output.toString());

	}

}
