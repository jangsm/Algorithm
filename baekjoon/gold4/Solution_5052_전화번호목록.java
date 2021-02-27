package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 28.
 * @author user
 * @see https://www.acmicpc.net/problem/5052
 * @mem 222700
 * @time 512
 * @caution 문자열을 저장하고 효율적으로 탐색하기위한 Trie 자료구조 -> 트리형태로 저장
 * 			가장 간단하게는 String이 sort되는 성질(각 char별 오름차순 + 짧은길이순)을 이용하여 현재인덱스와 다음인덱스만 비교해주는식으로도 구현이 가능하다.
 */

public class Solution_5052_전화번호목록 {

	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		outer: for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(input.readLine());
			Trie root = new Trie();
			String[] list = new String[N];
			for (int i = 0; i < N; i++) {
				list[i] = input.readLine();
				root.insert(list[i]);
			}

			for (int i = 0; i < N; i++) {
				if (root.find(list[i])) {
					output.append("NO\n");
					continue outer;
				}
			}
			output.append("YES\n");
		}

		System.out.println(output.toString());
	}

	static class Trie {
		boolean finish;
		Trie[] childs = new Trie[10];

		public void insert(String s) {
			if (s.length() == 0) {
				this.finish = true;
			} else {
				if (this.childs[s.charAt(0) - '0'] == null) {
					Trie child = new Trie();
					this.childs[s.charAt(0) - '0'] = child;
					child.insert(s.substring(1));
				} else {
					this.childs[s.charAt(0) - '0'].insert(s.substring(1));
				}
			}
		}

		public boolean find(String s) {
			if (s.length() == 0) { // 끝까지 찾은 경우
				return false;
			} else if (this.finish) { // 끝이 아닌데 finish? -> 접두어로 겹친다.
				return true;
			} else {
				return this.childs[s.charAt(0) - '0'].find(s.substring(1));
			}
		}
	}

}
