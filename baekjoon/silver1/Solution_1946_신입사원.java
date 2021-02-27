package ps.bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 28.
 * @author user
 * @see https://www.acmicpc.net/problem/1946
 * @mem 313784
 * @time 3084 (tc가 최대 20이라 크다 -> 시간복잡도는 정렬을 위한 O(nlogn)
 * @caution 서류점수를 내림차순 정렬하고 면접점수를 비교한다는 아이디어는 맞았음
 * 			면접점수를 비교할때 0 ~ 현재 index까지 모두 탐색하면서 for문을 중첩해서 사용했는데 지원자가 10만이므로 당연히 시간초과
 * 			생각해보면 현재까지 검사한 people의 최대 면접점수만 알고 있으면 비교가능 -> 그거보다 커야 합격자(인덱스순으로 서류점수는 낮으므로)
 */

public class Solution_1946_신입사원 {

	static int T, N;
	static int[][] people;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();
		
		T = Integer.parseInt(input.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(input.readLine());
			people = new int[N][2];
			for(int i = 0; i<N; i++) {
				tokenizer = new StringTokenizer(input.readLine(), " ");
				int rank1 = Integer.parseInt(tokenizer.nextToken());
				int rank2 = Integer.parseInt(tokenizer.nextToken());
				
				people[i][0] = N - rank1; // 서류점수
				people[i][1] = N - rank2; // 면접점수
			}
			
			Arrays.sort(people, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return -1*Integer.compare(o1[0], o2[0]);
				}
			});
			
			int result = 1;
			int compareNum = people[0][1]; // 비교해야할 면접 점수 -> 서류 내림차순 정렬이므로 합격자이려면 현재까지 순회결과의 최대 면접점수보다 높아야함
			for(int i=1; i<N; i++) {
				if (people[i][1] > compareNum) {
					compareNum = people[i][1];
					result++;
				}
			}
			
			output.append(result + "\n");
		}
		System.out.println(output.toString());
	}

}
