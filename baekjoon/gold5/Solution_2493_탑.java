package ps.bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		int N = Integer.parseInt(input.readLine());
		Stack<int[]> building = new Stack<>(); // [0] : height, [1] : index
		List<Integer> answer = new ArrayList<>();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 1; i <= N; i++) { // index가 1부터 시작함
			int height = Integer.parseInt(tokenizer.nextToken());
			while (!building.isEmpty() && building.peek()[0] <= height) { // stack이 비어있지 않고 지금 들어오는 건물의 높이가 더 높다면 이전까지
																			// 스택에 담아둔 값은 필요없음
				building.pop();
			}
			if (building.isEmpty()) { // stack이 비어버리면 내가 제일 큰 빌딩
				answer.add(0);
			} else { // 비지 않았으면 stack의 탑의 인덱스
				answer.add(building.peek()[1]);
			}
			building.push(new int[] { height, i });
		}
		
		for(int i=0; i<answer.size(); i++) {
			output.append(answer.get(i)).append(" ");
		}
		System.out.println(output.toString());
	}

}
