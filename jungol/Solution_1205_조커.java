package ps.jo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 25.
 * @author user
 * @see http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=488&sca=99&sfl=wr_hit&stx=1205
 * @mem 13mb
 * @time 261
 * @caution 로직 자체는 금방 생각했는데 예외처리에서 고생함
 */

public class Solution_1205_조커 {

	static int N, result = Integer.MIN_VALUE;
	static ArrayList<Integer> cards;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		N = Integer.parseInt(input.readLine());
		cards = new ArrayList<>();

		int joker = 0;
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			if (num == 0) {
				joker++;
			} else {
				boolean isDuplicate = false;
				for (int j = 0; j < cards.size(); j++) {
					if (cards.get(j) == num) {
						isDuplicate = true;
						break;
					}
				}
				if (!isDuplicate) {
					cards.add(num);
				}
			}
		}

		Collections.sort(cards);
		
		if (cards.size()<2) {
			result = joker + cards.size();
		} else {
			for (int i = 1; i < cards.size(); i++) {
				int diff = 0;
				int temp = joker;
				int straight = 1;
				int index = i;
				while (true) {
					if (index >= cards.size()) {
						result = Math.max(result, straight + temp);
						break;
					}
					diff = cards.get(index) - cards.get(index - 1) - 1;
					if (diff > temp) {
						result = Math.max(result, straight + temp);
						break;
					} else {
						temp -= diff;
						straight += diff + 1;
						index++;
					}
				}
			}	
		}

		System.out.println(result);
	}

}
