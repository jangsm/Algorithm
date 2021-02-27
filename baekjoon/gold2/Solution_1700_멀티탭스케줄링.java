package ps.bj.g2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 27.
 * @author user
 * @see https://www.acmicpc.net/problem/1700
 * @mem 11552
 * @time 76
 * @caution 그리디!! 콘센트가 꽉찬 이후 교체 순서는 꽂혀있는 것중 가장 나중에 들어올것을 교체해준다.
 */

public class Solution_1700_멀티탭스케줄링 {

	static int N, K, result;
	static int[] arr, use;

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		K = Integer.parseInt(tokenizer.nextToken());
		use = new int[N];
		arr = new int[K];

		// 꽂아야될 제품부터 순차적으로 탐색해 현재 꽂혀있는 제품 중 가장 뒤에 나오는 것을 교체 -> 가장 늦게 사용될 제품임
		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int index = 0;
		outer : for (int i = 0; i < K; i++) {
			if (index<N) { // 아직 멀티탭이 모두 사용중이지 않은 경우
				// arr[i]가 이미 사용되고 있는지 확인이 필요
				for(int j = 0; j<N; j++) {
					if (use[j] == arr[i] ) { // 이미 사용되고 있다면
						continue outer; // 다음 i로 넘어감
					}
				}
				// 여기까지 도달하면 사용중이지 않은 경우
				use[index++] = arr[i]; // index올리고 멀티탭에 꽂는다.
			} else { // 모두 사용중인경우
				for(int j=0; j<N; j++) {
					if (use[j] == arr[i] ) { // 새로 사용할 제품이 이미 사용중이면
						continue outer; // 다음 i로 넘어감
					}
				}
				// 새로 꽂아야하는경우
				boolean[] visited = new boolean[N];
				int cnt = 0;
				for(int j=i+1; j<K; j++) {
					for(int k = 0; k<N; k++) {
						if (!visited[k] && arr[j] == use[k]) {
							visited[k] = true;
							if (cnt<N-1) {
								cnt++;
							}else {
								use[k] = arr[i];
								result++;
								continue outer;
							}
						}
					}
				}
				
				// 뒤에 더이상 나오지 않는 경우라면
				for(int j =0; j<N; j++) {
					if (!visited[j]) {
						use[j] = arr[i];
						result++;
						continue outer;
					}
				}
			}
		}
		
		System.out.println(result);
	}

}
