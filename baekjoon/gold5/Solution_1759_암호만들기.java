package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/1759
 * @mem 11936
 * @time 80
 * @caution comb 만들때 순서대로 배열한다고 원본 choosed에대해서 sort하면 
 * 			값의 위치가 다 바뀌어서 return해서 돌아가면 변경된 배열에 대해서 계산된다.
 * 			clone을 통해 복사해서 사용하자.
 */

public class Solution_1759_암호만들기 {

	static int L, C ,count;
	static char[] arr;
	static List<String> results = new ArrayList<String>();;
	static StringBuilder output;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		L = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());
		arr = new char[C];

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < C; i++) {
			arr[i] = tokenizer.nextToken().charAt(0);
		}

		makeComb(0, new char[L], 0);
		Collections.sort(results);
		for(String s : results) {
			output.append(s+"\n");
		}
		System.out.println(output.toString());
	}

	static void makeComb(int cnt, char[] choosed, int startIdx) {
		if (cnt == L) {
			int vowels = 0; // 모음
			int consonants = 0; // 자음
			
			for(int i=0; i<choosed.length; i++) {
				switch (choosed[i]) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					vowels++;
					break;
				default:
					consonants++;
					break;
				}
				
				if (vowels>=1 && consonants>=2) {
					char[] copy = choosed.clone(); // 복사해서 사용하지 않고 원본 sort하면 return해서 이전으로 돌아갔을때 값이 변경되어있어서 이상하게 된다.
					Arrays.sort(copy);
					String str = "";
					for(int j=0; j<copy.length; j++) {
						str += copy[j];
					}
					results.add(str);
					return;
				}
			}
			return;
		}

		for (int i = startIdx; i < C; i++) {
			choosed[cnt] = arr[i];
			makeComb(cnt + 1, choosed, i + 1);
		}
	}

}
