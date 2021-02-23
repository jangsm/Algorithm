package ps.study.practiceTest.date210221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 23.
 * @author user
 * @see https://www.acmicpc.net/problem/10158
 * @mem 11548
 * @time 76
 * @caution 수학적인 생각을 하는게 어려웠다, 삽질 많이함
 * 			결국 x, y축 1칸씩 이동하므로 이걸 이용하자!!
 */

public class Solution_s5_10158_개미 {

	static int w, h, p, q, t;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		w = Integer.parseInt(tokenizer.nextToken());
		h = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(input.readLine(), " ");
		p = Integer.parseInt(tokenizer.nextToken());
		q = Integer.parseInt(tokenizer.nextToken());

		t = Integer.parseInt(input.readLine());
		
		p = (p+t)%(2*w);
		q = (q+t)%(2*h);
		
		p = w - Math.abs(p-w);
		q = h - Math.abs(q-h);

		output.append(p + " " + q);
		System.out.println(output.toString());

	}

}
