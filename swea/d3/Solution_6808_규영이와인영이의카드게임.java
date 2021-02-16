package ps.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {

	static int T;
	static int[] cards, remains;
	static boolean[] uses;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		T = Integer.parseInt(input.readLine());
		for (int tc = 1; tc <= T; tc++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			cards = new int[9];
			remains = new int[9];
			uses = new boolean[19]; // 1부터 index
			for (int i = 0; i < cards.length; i++) {
				cards[i] = Integer.parseInt(tokenizer.nextToken());
				uses[cards[i]] = true;
			}

			int index = 0;
			for (int i = 1; i < uses.length; i++) {
				if (!uses[i]) {
					remains[index] = i;
					index++;
				}
			}

			int win = 0;
			do {
				int winSum = 0;
				int loseSum = 0;
				for (int i = 0; i < cards.length; i++) {
					if (cards[i] > remains[i]) {
						winSum += cards[i] + remains[i];
					}
					if (winSum > 85) {
						win++;
						break;
					}
				}
			} while (nextPerm(remains));

			int lose = 362880 - win;
			output.append("#" + tc + " " + win + " " + lose + "\n");
		}
		System.out.println(output.toString());
	}

	static boolean nextPerm(int[] remains) {
		int i = remains.length - 1;
		int j = remains.length - 1;
		while (i > 0 && remains[i - 1] >= remains[i])
			i--;
		if (i == 0) {
			return false;
		}

		while (remains[i - 1] >= remains[j])
			j--;

		int temp = remains[i - 1];
		remains[i - 1] = remains[j];
		remains[j] = temp;

		int k = remains.length - 1;
		while (i < k) {
			temp = remains[i];
			remains[i] = remains[k];
			remains[k] = temp;
			i++;
			k--;
		}
		return true;
	}

}
