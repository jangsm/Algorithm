package ps.bj.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_15663_N과M_9 {
	
	static int[] data;
	static int N,M;
	static StringBuilder output = new StringBuilder();
	static Set<Sequence> set = new LinkedHashSet<>(); // set인데 순서 유지됨

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;

		tokenizer = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokenizer.nextToken());
		M = Integer.parseInt(tokenizer.nextToken());

		data = new int[N];

		tokenizer = new StringTokenizer(input.readLine(), " ");
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		Arrays.sort(data);
		
		makePerm(0, new int[M], new boolean[N]);
		
		Iterator<Sequence> iter = set.iterator();
		while(iter.hasNext()) {
			Sequence sequence = iter.next();
			for(int i=0; i<sequence.getChoosed().length; i++) {
				output.append(sequence.getChoosed()[i]).append(" ");
			}
			output.append("\n");
		}
		
		System.out.println(output.toString());
		
	}
	
	static void makePerm(int cnt, int[] choosed, boolean[] isSelected) {
		if (cnt==M) {
//			System.out.println("함수: " + Arrays.toString(choosed));
			Sequence sequence = new Sequence(choosed.clone());
			set.add(sequence);
			return;
		}
		
		for(int i=0; i<data.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			
			choosed[cnt] = data[i];
			isSelected[i]= true;
			makePerm(cnt+1, choosed, isSelected);
			isSelected[i]= false; 
		}
	}
}

class Sequence{
	
	private int[] choosed;
	
	public Sequence(int[] choosed) {
		this.choosed = choosed;
	}
	

	public int[] getChoosed() {
		return choosed;
	}


	public void setChoosed(int[] choosed) {
		this.choosed = choosed;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(choosed);
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
		Sequence other = (Sequence) obj;
		if (!Arrays.equals(choosed, other.choosed))
			return false;
		return true;
	}


	
	
}
