package ps.study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 5.
 * @author user
 * @see https://www.acmicpc.net/problem/5430
 * @mem
 * @time
 * @caution
 */

public class Deque_no5430_AC {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String order = input.readLine();

			int use = 1; // 1이면 앞에서부터 작업, 2이면 뒤에서부터 작업
			boolean errorFlag = false;
			
			int n = Integer.parseInt(input.readLine());

			StringBuilder sb = new StringBuilder(input.readLine());
			String strArr = sb.substring(1, sb.length() - 1);
			Deque<String> deque = new ArrayDeque<>();
			if (strArr.length()!=0) { // 길이가 0인 문자열에 대해 split하면 빈문자가 들어감
				String[] arr = strArr.split(",");
//				System.out.println(Arrays.toString(arr) + ", " + arr.length);
				for (int i = 0; i < arr.length; i++) {
					deque.addLast(arr[i]);
					use = 1;
				}
			}

			for (int i = 0; i < order.length(); i++) {
				if (order.charAt(i) == 'R') {
					if (use == 1) {
						use = 2;
					} else if (use == 2) {
						use = 1;
					}
				} else if (order.charAt(i) == 'D') {
					if (use==1) {
						if (!deque.isEmpty()) {
							deque.pollFirst();
						} else {
							errorFlag = true;
						}
					} else if (use==2) {
						if (!deque.isEmpty()) {
							deque.pollLast();
						} else {
							errorFlag = true;
						}
					}
				}
			}
			
			if (errorFlag) {
				output.append("error").append("\n");
			} else {
				output.append("[");
				if (use==1) {
					while (!deque.isEmpty()) {
						output.append(deque.pollFirst()).append(",");
					}
				} else if (use==2) {
					while (!deque.isEmpty()) {
						output.append(deque.pollLast()).append(",");
					}
				}
				if (output.charAt(output.length()-1)==',') {
					output.setLength(output.length()-1); // 빈 배열에 대하여 R만 하는 경우 [가 없어짐	
				}
				output.append("]").append("\n");
			}
		}
		
		System.out.println(output.toString());
	}

}
