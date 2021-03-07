package ps.bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @since 2021. 3. 5.
 * @author user
 * @see https://www.acmicpc.net/problem/1764
 * @mem 25712
 * @time 228
 * @caution 다른방법은 어떻게..?? 분류는 이분탐색
 */

public class Solution_1764_듣보잡 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		tokenizer = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());
		
		List<String> result = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			map.put(input.readLine(), 1);
		}
		
		for(int i=0; i<M; i++) {
			String str = input.readLine();
			if (map.get(str)!=null) {
				result.add(str);
			}
		}
		
		Collections.sort(result);
		
		output.append(result.size()+"\n");
		for(String s : result) {
			output.append(s+"\n");
		}
		System.out.println(output.toString());
	}

}
