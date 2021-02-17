package ps.bj.g4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 17.
 * @author user
 * @see https://www.acmicpc.net/problem/17135
 * @mem 내가 푼 방법: 29112
 * @time 내가 푼 방법: 632
 * @caution 조건을 제대로 읽고 명확하게 구분해서 코딩을 하자. 고려할게 많아지면 헷갈리기 시작한다. 특히 한칸씩 내리거나 하는 부분은 맨 위부터 움직일지 맨 아래부터 움직일지가 중요!!!
 * 			문제에 따라 다르지만 이 문제는 맨 아래 궁수 위치부터 가장 가까운 적을 공격하니까 bfs로 푸는게 적이 있는 모든 경우를 계산해주는것보다 빠른듯..?? 적을 만나는순간 bfs 그만둔다
 * 			왼쪽, 위쪽, 오른쪽 순으로 죽인다.
 * 			각 경우에 대해서 계산하는것이므로 원본값을 복사해서 사용!! 원본값 건드리면 그 다음 경우에서 변경된 map에 대해서 계산한다.
 * 			적이 내려오게 하는것보다 궁수가 올라가는게 계산 편함 -> 왼쪽, 위쪽, 오른쪽 순으로 탐색하면 한칸씩 올라가면서 뒤는 신경 안써도 됨
 */

public class Solution_17135_캐슬디펜스 {

	static int N, M, D, result = Integer.MIN_VALUE;
	static int[][] map;
	static List<Pair> enemy;
	static int archerCount = 3;

	static class Pair {
		int x, y;
		int targetIndex;
		boolean isDelete;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.isDelete = false;
		}

		public Pair(int x, int y, int targetIndex) {
			super();
			this.x = x;
			this.y = y;
			this.targetIndex = targetIndex;
			this.isDelete = false;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());
		D = Integer.parseInt(tokenizer.nextToken());

		map = new int[N][M]; // 마지막 줄은 궁수
		enemy = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokenizer.nextToken());
				if (map[r][c] == 1) {
					enemy.add(new Pair(r, c));
				}
			}
		}

		makeComb(0, new int[archerCount], 0);
		System.out.println(result);
	}

	static void makeComb(int cnt, int[] choosed, int startIdx) {
		if (cnt == archerCount) {
			Pair[] target = new Pair[archerCount]; // target이 겹칠 수 있으므로 한번에 죽이기 위해서 따로 관리
			int[][] tempMap = new int[N][M]; // 각 경우마다 사용할 복사한 map
			List<Pair> enemyTemp = new ArrayList<>(); // 각 경우마다 사용할 복사한 enemy
			
			for (int i = 0; i < N; i++) {
				tempMap[i] = map[i].clone();
			}
			for (int i = 0; i < enemy.size(); i++) {
				enemyTemp.add(new Pair(enemy.get(i).x, enemy.get(i).y));
			}
			
			int kill = 0; // 궁수의 위치에 대한 각 경우의 결과값
			while (true) {
				boolean isBreak = true;
				outer: for (int i = 0; i < N; i++) { // 탈출조건, 적이 더 이상 없을때
					for (int j = 0; j < M; j++) {
						if (tempMap[i][j] == 1) {
							isBreak = false;
							break outer;
						}
					}
				}

				if (isBreak) {
					break;
				}

				for (int i = 0; i < target.length; i++) { // 타겟 초기화
					target[i] = null;
				}

				for (int i = 0; i < archerCount; i++) {
					int archerX = N;
					int archerY = choosed[i];
					int minDist = Integer.MAX_VALUE;
					for (int j = 0; j < enemyTemp.size(); j++) {
						if (enemyTemp.get(j).isDelete) {
							continue;
						}
						int enemyX = enemyTemp.get(j).x;
						int enemyY = enemyTemp.get(j).y;
						int dist = Math.abs(archerX - enemyX) + Math.abs(archerY - enemyY); // 궁수 위치에 대하여 모든 적의 위치까지의 최소값구하기
						if (dist <= D) {
							if (minDist > dist) { // 더 작으면 무조건 변경
								target[i] = new Pair(enemyX, enemyY, j);
								minDist = dist;
							} else if (minDist == dist) { // 같다는건 기존 값이 있다.
								if (target[i].y > enemyY) { // 새로 들어온 값이 기존 값보다 더 왼쪽에 있으면
									target[i] = new Pair(enemyX, enemyY, j);
								}
							}
						}
					}
				}
				for (int i = 0; i < target.length; i++) {
					if (target[i] == null) { // 궁수 i가 타겟으로 삼을 수 있는 적이 없다
						continue;
					}
					if (tempMap[target[i].x][target[i].y] == 1) { // 같은 타겟을 잡을 수 있다. -> 아직 살아있는 적을 죽인 경우 kill을 올려준다.
						tempMap[target[i].x][target[i].y] = 0;
						kill++;
					}
				}

				for (int i = enemyTemp.size() - 1; i >= 0; i--) { // 아래로 한칸씩 밀기때문에 맨 밑에서부터 옮겨주는 작업을 해야함, 맨 위부터 하면 덮어준 값을 이용해서 계속 덮어주게됨
					if (enemyTemp.get(i).x < N && tempMap[enemyTemp.get(i).x][enemyTemp.get(i).y] == 1
							&& !enemyTemp.get(i).isDelete) { // 범위 안에 들어오고 0으로 바뀌지 않은 아직
						// 살아있는 적에 대해서
						tempMap[enemyTemp.get(i).x][enemyTemp.get(i).y] = 0; // 한칸 이동을 위해 기존 위치는 0으로
						enemyTemp.get(i).x += 1; // 한칸 아래로 이동
						if (enemyTemp.get(i).x < N) {
							tempMap[enemyTemp.get(i).x][enemyTemp.get(i).y] = 1; // 새로운 위치에 적 표시
						} else {
							enemyTemp.get(i).isDelete = true;
						}
					} else {
						enemyTemp.get(i).isDelete = true;
					}
				}
			}

			result = Math.max(result, kill);
			return;
		}

		for (int i = startIdx; i < M; i++) {
			choosed[cnt] = i;
			makeComb(cnt + 1, choosed, i + 1);
		}
	}

}
