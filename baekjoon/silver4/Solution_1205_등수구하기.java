package ps.bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 28.
 * @author user
 * @see https://www.acmicpc.net/problem/1205
 * @mem 11664
 * @time 80
 * @caution n이 0이면 입력이 들어오면 안되므로 input.readLine null에러
 * 			클래스를 만들어서 사용한경우와 그냥 푼경우의 차이..??
 */

public class Solution_1205_등수구하기 {

	static int N, score, P;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken()); // 리스트에 있는 개수
		score = Integer.parseInt(tokenizer.nextToken());
		P = Integer.parseInt(tokenizer.nextToken()); // 랭킹리스트에 올라갈수 있는 개수

		List<Score> list = new ArrayList<Score>();
		if (N > 0) { // n이 0이상인경우만 입력 주어짐
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int i = 0; i < N; i++) {
				list.add(new Score(false, Integer.parseInt(tokenizer.nextToken())));
			}

		}
		list.add(new Score(true, score));

		Collections.sort(list, new Comparator<Score>() {
			@Override
			public int compare(Score o1, Score o2) {
				if (o1.score == o2.score) {
					return Boolean.compare(o1.isYujin, o2.isYujin);
				}
				return -1 * Integer.compare(o1.score, o2.score);
			}
		});

//		System.out.println(list.toString());

		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isYujin) {
				index = i;
				break;
			}
		}

//		System.out.println(index);
//		if (score > list.get(0)) {
//			list.add(0, score);
//			index = 0;
//		} else {
//			for (int i = 0; i < list.size() - 1; i++) {
//				if (list.get(i) >= score && list.get(i + 1) < score) {
//					list.add(i + 1, score);
//					index = i + 1;
//					break;
//				}
//				// 맨 마지막 위치까지 add안된경우
//				if (i == list.size() - 2 && index == -1) {
//					list.add(score);
//					index = list.size() - 1;
//					break;
//				}
//			}
//		}

		List<Integer> rankList = new ArrayList<Integer>();
		rankList.add(1);
		int dupCnt = 1;
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).score == list.get(i - 1).score) { // 이전과 같으면 같은 랭크
				rankList.add(rankList.get(i - 1));
				dupCnt++;
			} else {
				rankList.add(rankList.get(i - 1) + dupCnt);
				dupCnt = 1;
			}
		}

//		System.out.println(rankList.toString());

		int result = 0;
		if (index <= P - 1) {
			result = rankList.get(index);
		} else {
			result = -1;
		}

		System.out.println(result);
	}

	static class Score {
		boolean isYujin;
		int score;

		public Score(boolean isYujin, int score) {
			super();
			this.isYujin = isYujin;
			this.score = score;
		}

		@Override
		public String toString() {
			return "Score [isYujin=" + isYujin + ", score=" + score + "]";
		}

	}

}
