package ps.bj.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @since 2021. 2. 9.
 * @author user
 * @see https://www.acmicpc.net/problem/8979
 * @mem 14920
 * @time 160
 * @caution 객체비교 equals를 오버라이드하고 ==으로 비교하는 실수를 하지말자..!!
 */

public class Solution_8979_올림픽 {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder output = new StringBuilder();

		tokenizer = new StringTokenizer(input.readLine(), " ");
		int N = Integer.parseInt(tokenizer.nextToken());
		int K = Integer.parseInt(tokenizer.nextToken());

		Nation[] nations = new Nation[N];
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(input.readLine(), " ");
			int no = Integer.parseInt(tokenizer.nextToken());
			int gold = Integer.parseInt(tokenizer.nextToken());
			int silver = Integer.parseInt(tokenizer.nextToken());
			int bronze = Integer.parseInt(tokenizer.nextToken());
			nations[i] = new Nation(no, gold, silver, bronze);
		}

		Arrays.sort(nations, new Comparator<Nation>() {
			@Override
			public int compare(Nation o1, Nation o2) {
				if (o1.gold > o2.gold) {
					return -1;
				} else if (o1.gold == o2.gold) {
					if (o1.silver > o2.silver) {
						return -1;
					} else if (o1.silver == o2.silver) {
						if (o1.bronze > o2.bronze) {
							return -1;
						} else if (o1.bronze == o2.bronze) {
							return 0;
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			}
		});
		
//		System.out.println(Arrays.toString(nations));
		
		int index = 0;
		for(int i=0; i<N; i++) {
			if (nations[i].no == K) {
				index = i;
				break;
			}
		}
		
//		System.out.println(index + " : " + (nations[index-1] == nations[index])); // ==은 주소비교임!!
		
		while(index>0 && nations[index-1].equals(nations[index]) ) {
			index--;
		}
		
		System.out.println(index+1);
	}

}

class Nation {
	int no;
	int gold;
	int silver;
	int bronze;

	public Nation(int no, int gold, int silver, int bronze) {
		super();
		this.no = no;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bronze;
		result = prime * result + gold;
		result = prime * result + silver;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nation other = (Nation) obj;
		if (bronze != other.bronze)
			return false;
		if (gold != other.gold)
			return false;
		if (silver != other.silver)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nation [no=" + no + ", gold=" + gold + ", silver=" + silver + ", bronze=" + bronze + "]";
	}

	

}
