package ps.bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2621_카드게임 {

	static int[] colors = new int[4]; // 0: R, 1: B, 2: Y, 3: G
	static int[] nums = new int[10]; // 0은 사용하지 않음

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			char color = tokenizer.nextToken().charAt(0);
			int num = Integer.parseInt(tokenizer.nextToken());

			switch (color) {
			case 'R':
				colors[0]++;
				break;
			case 'B':
				colors[1]++;
				break;
			case 'Y':
				colors[2]++;
				break;
			case 'G':
				colors[3]++;
				break;
			default:
				break;
			}

			nums[num]++;
		}

		int score = 0;

		if (is5SameColor() && isContinueNum() != 0) {
			score = 900 + isContinueNum();
			System.out.println(score);
		} else if (is4SameNum() != 0) {
			score = 800 + is4SameNum();
			System.out.println(score);
		} else if (is3SameNum() != 0 && is2SameNum(1) != 0) {
			score = 700 + 10 * is3SameNum() + is2SameNum(1);
			System.out.println(score);
		} else if (is5SameColor()) {
			score = 600 + getHighScore();
			System.out.println(score);
		} else if (isContinueNum() != 0) {
			score = 500 + isContinueNum();
			System.out.println(score);
		} else if (is3SameNum() != 0) {
			score = 400 + is3SameNum();
			System.out.println(score);
		} else if (is2SameNum(1) != 0 && is2SameNum(is2SameNum(1) + 1) != 0) {
			score = 300 + 10 * is2SameNum(is2SameNum(1) + 1) + is2SameNum(1);
			System.out.println(score);
		} else if (is2SameNum(1) != 0) {
			score = 200 + is2SameNum(1);
			System.out.println(score);
		} else {
			score = 100 + getHighScore();
			System.out.println(score);
		}
	}

	static boolean is5SameColor() {
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] == 5) {
				return true;
			}
		}
		return false;
	}

	static int isContinueNum() {
		int result = 0;
		outer: for (int i = 1; i <= 5; i++) {
			if (nums[i] == 1) {
				for (int j = i + 1; j < i + 5; j++) {
					if (nums[j] != 1) {
						continue outer;
					}
				}
				result = i + 4;
				return result;
			}
		}
		return result;
	}

	static int is4SameNum() {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 4) {
				return i;
			}
		}
		return 0;
	}

	static int is3SameNum() {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 3) {
				return i;
			}
		}
		return 0;
	}

	static int is2SameNum(int startIdx) {
		for (int i = startIdx; i < nums.length; i++) {
			if (nums[i] == 2) {
				return i;
			}
		}
		return 0;
	}

	static int getHighScore() {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] != 0) {
				return i;
			}
		}
		return 0;
	}

	static int getLowScore() {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != 0) {
				return i;
			}
		}
		return 0;
	}

}
